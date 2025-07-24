FROM mcr.microsoft.com/windows/servercore:ltsc2019

# Este é um placeholder. Em ambiente Linux, a execução de ASP Clássico não é suportada nativamente.
# Para compatibilidade real, deve-se usar IIS em Windows Server ou soluções como Wine+Apache+mod_aspdotnet.

# Como alternativa, recomenda-se execução via IIS:
# - Subir container Windows com IIS habilitado
# - Copiar conteúdo ASP para C:\inetpub\wwwroot
# - Configurar site no IIS para rodar ASP

# Abaixo está apenas o conteúdo da aplicação, não executável diretamente em Docker Linux.

# Diretório de código
COPY wwwroot /inetpub/wwwroot/
