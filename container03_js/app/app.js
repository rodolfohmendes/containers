const express = require('express');
const session = require('express-session');
const bodyParser = require('body-parser');
const sqlite3 = require('sqlite3').verbose();
const app = express();
const port = 8012;

const db = new sqlite3.Database('./ecommerce.db');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(session({ secret: 'secretkey', resave: false, saveUninitialized: true }));
app.set('view engine', 'ejs');

app.get('/', (req, res) => {
  db.all("SELECT * FROM produtos", [], (err, rows) => {
    if (err) return res.send("Erro ao carregar produtos.");
    res.render('index', { products: rows });
  });
});

app.get('/login', (req, res) => {
  res.render('login');
});

app.post('/login', (req, res) => {
  const { username, password } = req.body;
  if (username === 'admin' && password === 'admin') {
    req.session.user = username;
    res.redirect('/');
  } else {
    res.send("Login inválido.");
  }
});

app.post('/checkout', (req, res) => {
  if (!req.session.user) return res.redirect('/login');
  const id = req.body.product_id;
  db.get("SELECT nome FROM produtos WHERE id = ?", [id], (err, row) => {
    if (err || !row) return res.send("Produto não encontrado.");
    res.render('checkout', { product_id: id, nome: row.nome });
  });
});

app.post('/confirm', (req, res) => {
  if (!req.session.user) return res.redirect('/login');
  db.get("SELECT nome FROM produtos WHERE id = ?", [req.body.product_id], (err, row) => {
    if (err || !row) return res.send("Produto inválido.");
    res.render('confirm', { product: row.nome, address: req.body.address });
  });
});

app.listen(port, () => console.log(`Loja Node.js em http://localhost:${port}`));
