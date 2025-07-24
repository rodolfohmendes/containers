#!/usr/bin/perl
use CGI;
use CGI::Carp qw(fatalsToBrowser);
use strict;

my $q = CGI->new;
print $q->header;
print $q->start_html("Loja CGI");

my $user = $q->param("username");
my $pass = $q->param("password");

if ($user eq "admin" && $pass eq "admin") {
    print "<h2>Login bem-sucedido!</h2>";
    print "<form method='POST' action='/cgi-bin/checkout.pl'>";
    print "Produto: <select name='produto'>
             <option value='1'>Camiseta - R$49,90</option>
             <option value='2'>Tênis - R$199,90</option>
           </select><br>";
    print "<input type='submit' value='Comprar'>";
    print "</form>";
} else {
    print "<p>Login inválido.</p>";
}
print $q->end_html;
