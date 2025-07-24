import java.sql.*;

public class PopularDB {
  public static void main(String[] args) throws Exception {
    Connection conn = DriverManager.getConnection("jdbc:sqlite:ecommerce.db");
    Statement stmt = conn.createStatement();
    stmt.execute("CREATE TABLE IF NOT EXISTS produtos (id INTEGER PRIMARY KEY, nome TEXT, preco REAL)");
    stmt.execute("DELETE FROM produtos");
    stmt.execute("INSERT INTO produtos (nome, preco) VALUES ('Camiseta Preta', 49.90)");
    stmt.execute("INSERT INTO produtos (nome, preco) VALUES ('Tênis Esportivo', 199.90)");
    conn.close();
  }
}
