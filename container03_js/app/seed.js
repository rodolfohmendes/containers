const sqlite3 = require('sqlite3').verbose();
const db = new sqlite3.Database('./ecommerce.db');

db.serialize(() => {
  db.run("CREATE TABLE IF NOT EXISTS produtos (id INTEGER PRIMARY KEY, nome TEXT, preco REAL)");
  db.run("DELETE FROM produtos");
  db.run("INSERT INTO produtos (nome, preco) VALUES ('Camiseta Preta', 49.90)");
  db.run("INSERT INTO produtos (nome, preco) VALUES ('Tênis Esportivo', 199.90)");
});

db.close();
