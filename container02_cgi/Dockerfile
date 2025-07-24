FROM perl:latest
RUN cpan CGI
RUN mkdir -p /var/www/html/cgi-bin
COPY cgi-bin /var/www/html/cgi-bin
COPY index.html /var/www/html/index.html
RUN chmod +x /var/www/html/cgi-bin/*.pl
WORKDIR /var/www/html
EXPOSE 8010
CMD ["perl", "-MHTTP::Server::Simple::CGI", "-e", "HTTP::Server::Simple::CGI->new(8010)->run"]
