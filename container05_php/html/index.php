<?php
session_start();
$db = new SQLite3('ecommerce.db');
$results = $db->query("SELECT * FROM produtos");
?>
<!DOCTYPE html>
<html>
<head><title>Loja PHP</title></head>
<body>
<h1>Bem-vindo à Loja PHP</h1>
<?php while ($product = $results->fetchArray()): ?>
    <div>
        <h3><?= htmlspecialchars($product["nome"]) ?></h3>
        <p>R$ <?= number_format($product["preco"], 2, ",", ".") ?></p>
        <form method="POST" action="checkout.php">
            <input type="hidden" name="product_id" value="<?= $product["id"] ?>">
            <input type="submit" value="Comprar">
        </form>
    </div>
<?php endwhile; ?>
<p><a href="login.php">Login</a></p>
</body>
</html>
