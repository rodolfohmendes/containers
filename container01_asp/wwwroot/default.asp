<%@ LANGUAGE="VBScript" %>
<%
If Request.Form("username") <> "" Then
  If Request.Form("username") = "admin" And Request.Form("password") = "admin" Then
    Session("user") = "admin"
  Else
    Response.Write("<p>Login inválido</p>")
  End If
End If

If Session("user") = "" Then
%>
  <form method="POST" action="default.asp">
    Usuário: <input type="text" name="username"><br>
    Senha: <input type="password" name="password"><br>
    <input type="submit" value="Entrar">
  </form>
<%
ElseIf Request.Form("endereco") <> "" Then
%>
  <h2>Pedido Confirmado</h2>
  <p>Produto: <%= Request.Form("produto") %></p>
  <p>Endereço: <%= Request.Form("endereco") %></p>
  <a href="default.asp">Voltar</a>
<%
ElseIf Request.Form("produto") <> "" Then
%>
  <h2>Checkout</h2>
  <form method="POST" action="default.asp">
    <input type="hidden" name="produto" value="<%= Request.Form("produto") %>">
    Endereço: <input type="text" name="endereco"><br>
    <input type="submit" value="Finalizar">
  </form>
<%
Else
%>
  <h1>Loja ASP</h1>
  <form method="POST" action="default.asp">
    <input type="hidden" name="produto" value="Camiseta - R$49,90">
    <input type="submit" value="Comprar Camiseta">
  </form>
  <form method="POST" action="default.asp">
    <input type="hidden" name="produto" value="Tênis - R$199,90">
    <input type="submit" value="Comprar Tênis">
  </form>
<%
End If
%>
