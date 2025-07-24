#!/usr/bin/perl
use CGI;
use strict;

my $q = CGI->new;
print $q->header;
print $q->start_html("Confirmado");

my $produto = $q->param("produto");
my $endereco = $q->param("endereco");

print "<h2>Pedido Confirmado!</h2>";
print "<p>Produto: $produto</p>";
print "<p>Endereço: $endereco</p>";
print "<a href='/index.html'>Voltar</a>";
print $q->end_html;
