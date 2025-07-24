import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LojaServlet extends HttpServlet {
  private Connection conectar() throws SQLException {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      throw new SQLException("Driver SQLite não encontrado.");
    }
    return DriverManager.getConnection("jdbc:sqlite:/opt/jetty/webapps/root/ecommerce.db");
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    HttpSession session = req.getSession();
    String user = (String) session.getAttribute("user");

    String page = req.getParameter("page");

    try (Connection conn = conectar()) {
      if (user == null && page == null) {
        out.println("<form method='post'>Usuário: <input name='user'><br>Senha: <input type='password' name='pass'><br><input type='submit' value='Entrar'></form>");
        return;
      }

      if (page == null || page.equals("produtos")) {
        out.println("<h1>Loja Java</h1>");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");
        while (rs.next()) {
          int id = rs.getInt("id");
          String nome = rs.getString("nome");
          double preco = rs.getDouble("preco");
          out.println("<form method='POST' action='?page=checkout'>");
          out.println("Produto: " + nome + " - R$" + preco + "<input type='hidden' name='produto' value='" + id + "'><br>");
          out.println("<input type='submit' value='Comprar'>");
          out.println("</form>");
        }
      } else if (page.equals("confirmado")) {
        String pid = req.getParameter("produto");
        PreparedStatement stmt = conn.prepareStatement("SELECT nome FROM produtos WHERE id = ?");
        stmt.setInt(1, Integer.parseInt(pid));
        ResultSet rs = stmt.executeQuery();
        String nome = rs.next() ? rs.getString("nome") : "Desconhecido";

        out.println("<h2>Compra Confirmada!</h2>");
        out.println("<p>Produto: " + nome + "</p>");
        out.println("<p>Endereço: " + req.getParameter("endereco") + "</p>");
        out.println("<a href='?page=produtos'>Voltar</a>");
      }
    } catch (SQLException e) {
      out.println("<p>Erro de banco de dados: " + e.getMessage() + "</p>");
    }
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
    HttpSession session = req.getSession();
    String user = (String) session.getAttribute("user");
    if (user == null) {
      if ("admin".equals(req.getParameter("user")) && "admin".equals(req.getParameter("pass"))) {
        session.setAttribute("user", "admin");
        res.sendRedirect(".");
      } else {
        res.getWriter().println("Login inválido.");
      }
      return;
    }

    String produto = req.getParameter("produto");
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<h2>Checkout</h2>");
    out.println("<form method='POST' action='?page=confirmado'>");
    out.println("Endereço: <input name='endereco'><br>");
    out.println("<input type='hidden' name='produto' value='" + produto + "'>");
    out.println("<input type='submit' value='Confirmar'>");
    out.println("</form>");
  }
}
