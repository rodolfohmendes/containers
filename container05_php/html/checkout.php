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
<h2>Checkout</h2>
<form method="POST" action="confirm.php">
    <p>Produto: <?= htmlspecialchars($product) ?></p>
    Endereço: <input type="text" name="address" required><br>
    <input type="hidden" name="product_id" value="<?= htmlspecialchars($product_id) ?>">
    <input type="submit" value="Finalizar Compra">
</form>
