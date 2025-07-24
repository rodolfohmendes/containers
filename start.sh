#!/bin/bash
echo "[*] Subindo containers com docker-compose..."
docker-compose --env-file .env up --build -d
echo "[*] Containers iniciados. Acesse as lojas nos respectivos IPs e portas."
