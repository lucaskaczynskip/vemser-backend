package com.dbc;

import com.dbc.entities.Cliente;
import com.dbc.entities.ContaCorrente;
import com.dbc.entities.Contato;
import com.dbc.entities.Endereco;

public class Main {

    public static void main(String[] args) {
        Contato contatoLucas = new Contato("Telefone pessoal", "996829690", 1);
        Endereco enderecoLucas = new Endereco(1, "Av. Mauricio Cardoso", 2187, "casa", "96700-000", "São Jerônimo", "RS", "Brasil");
        Contato[] listaContatosLucas = new Contato[2];
        Endereco[] listaEnderecosLucas = new Endereco[2];
        listaContatosLucas[0] = contatoLucas;
        listaEnderecosLucas[0] = enderecoLucas;
        Cliente lucas = new Cliente("Lucas Kaczynski Primon", "054.108.160-80", listaContatosLucas, listaEnderecosLucas);
        ContaCorrente contaCorrenteLucas = new ContaCorrente(lucas, "2189", 5, 2500.5, 30);

        lucas.imprimirCliente();
        contaCorrenteLucas.imprimirContaCorrente();
        contaCorrenteLucas.depositar(40);
        System.out.println("\nSaldo total depois do deposito: " + contaCorrenteLucas.retornarSaldoComChequeEspecial());
        contaCorrenteLucas.sacar(1000);
        System.out.println("\nSaldo total depois do saque: " + contaCorrenteLucas.retornarSaldoComChequeEspecial());

        Contato contatoNicolas = new Contato("Telefone pessoal", "XXXXXXXXXXXXX", 1);
        Endereco enderecoNicolas = new Endereco(1, "XX XXXXXXX XXXXX", 200, "casa", "9670X-XXX", "Charqueadas", "RS", "Brasil");
        Contato[] listaContatosNicolas = new Contato[2];
        Endereco[] listaEnderecosNicolas = new Endereco[2];
        listaContatosNicolas[0] = contatoNicolas;
        listaEnderecosNicolas[0] = enderecoNicolas;
        Cliente nicolas = new Cliente("Nicolas Fiedler", "XXX.XXX.XXX-XX", listaContatosNicolas, listaEnderecosNicolas);
        ContaCorrente contaCorrenteNicolas = new ContaCorrente(nicolas, "3000", 7, 3000, 0);

        contaCorrenteNicolas.imprimirContaCorrente();

        contaCorrenteLucas.transferir(contaCorrenteNicolas, 254.70);
        System.out.println("\nSaldo total da conta do Lucas depois que transferiu: " + contaCorrenteLucas.retornarSaldoComChequeEspecial());

        contaCorrenteNicolas.imprimirContaCorrente();
    }
}
