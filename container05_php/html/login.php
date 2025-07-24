<?php
session_start();
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    if ($_POST["username"] === "admin" && $_POST["password"] === "admin") {
        $_SESSION["user"] = $_POST["username"];
        header("Location: index.php");
        exit;
    } else {
        echo "Usuário ou senha inválidos.";
    }
}
?>
<form method="POST">
    Usuário: <input type="text" name="username"><br>
    Senha: <input type="password" name="password"><br>
    <input type="submit" value="Entrar">
</form>
