<?php
session_start();
if (!isset($_SESSION["user"])) {
    header("Location: login.php");
    exit;
}
$db = new SQLite3('ecommerce.db');
$product_id = $_POST["product_id"] ?? null;
$product = $db->querySingle("SELECT nome FROM produtos WHERE id = " . intval($product_id));
?>
<h2>Pedido Confirmado!</h2>
<p>Produto: <?= htmlspecialchars($product) ?></p>
<p>Endereço: <?= htmlspecialchars($_POST["address"]) ?></p>
<p><a href="index.php">Voltar</a></p>
