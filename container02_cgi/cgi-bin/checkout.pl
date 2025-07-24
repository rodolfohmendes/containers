#!/usr/bin/perl
use CGI;
use strict;

my $q = CGI->new;
print $q->header;
print $q->start_html("Checkout");

my $produto = $q->param("produto");

print "<h2>Checkout</h2>";
print "<form method='POST' action='/cgi-bin/confirm.pl'>";
print "<input type='hidden' name='produto' value='$produto'>";
print "Endereço: <input type='text' name='endereco'><br>";
print "<input type='submit' value='Finalizar Compra'>";
print "</form>";
print $q->end_html;
