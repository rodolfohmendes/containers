# E-Commerce Multi-Language Containers

Este projeto contém 5 containers Docker simulando lojas virtuais com tecnologias diferentes.

## 📦 Containers incluídos

| Container       | Linguagem     | VIP                | Porta | Status                  |
|----------------|---------------|--------------------|-------|-------------------------|
| container01_asp | ASP Clássico  | 192.168.210.111    | 8014  | Requer ambiente Windows |
| container02_cgi | Perl (CGI)    | 192.168.210.110    | 8010  | Compatível com Linux    |
| container03_js  | Node.js (EJS) | 192.168.210.113    | 8012  | Pronto                  |
| container04_java| Java Servlet  | 192.168.210.112    | 8013  | Pronto                  |
| container05_php | PHP + Apache  | 192.168.210.114    | 8011  | Pronto                  |

## ▶️ Como executar

```bash
# Acesse o diretório do projeto
cd ecommerce_containers

# Execute os containers (exceto container01_asp)
docker-compose up --build
```

> ⚠️ O container `container01_asp` precisa ser executado em host com suporte a containers Windows Server Core + IIS.

## 📂 Estrutura

- Cada container possui:
  - `Dockerfile`
  - Código-fonte da aplicação (HTML, scripts, etc.)
- Rede interna definida no `docker-compose.yml` com IPs fixos

## 💡 Acesso

Após subir, acesse cada loja via:

- PHP: http://localhost:8011
- CGI: http://localhost:8010
- Node.js: http://localhost:8012
- Java: http://localhost:8013
- ASP: http://localhost:8014 (⚠️ IIS necessário)

## 📋 Funcionalidades comuns

- Login com usuário: `admin` e senha: `admin`
- Listagem de 2 produtos
- Formulário de endereço
- Confirmação de pedido
