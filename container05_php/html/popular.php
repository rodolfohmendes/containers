<?php
$db = new SQLite3('ecommerce.db');
$db->exec("CREATE TABLE IF NOT EXISTS produtos (id INTEGER PRIMARY KEY, nome TEXT, preco REAL)");
$db->exec("INSERT INTO produtos (nome, preco) VALUES ('Camiseta Preta', 49.90)");
$db->exec("INSERT INTO produtos (nome, preco) VALUES ('Tênis Esportivo', 199.90)");
echo "Banco populado!";
?>
