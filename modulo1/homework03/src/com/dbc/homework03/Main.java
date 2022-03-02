package com.dbc.homework03;

import com.dbc.homework03.entities.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Contato contatoLucas = new Contato("Telefone pessoal", "996829690", 1);
        Endereco enderecoLucas = new Endereco(1, "Av. Mauricio Cardoso", 2187, "casa", "96700-000", "São Jerônimo", "RS", "Brasil");
        ArrayList<Contato> listaContatosLucas = new ArrayList<>();
        ArrayList<Endereco> listaEnderecosLucas = new ArrayList<>();
        listaContatosLucas.add(contatoLucas);
        listaEnderecosLucas.add(enderecoLucas);
        Cliente lucas = new Cliente("Lucas Kaczynski Primon", "054.108.160-80", listaContatosLucas, listaEnderecosLucas);

        Contato contatoNicolas = new Contato("Telefone pessoal", "XXXXXXXXXXXXX", 1);
        Endereco enderecoNicolas = new Endereco(1, "XX XXXXXXX XXXXX", 200, "casa", "9670X-XXX", "Charqueadas", "RS", "Brasil");
        ArrayList<Contato> listaContatosNicolas = new ArrayList<>();
        ArrayList<Endereco> listaEnderecosNicolas = new ArrayList<>();
        listaContatosNicolas.add(contatoNicolas);
        listaEnderecosNicolas.add(enderecoNicolas);
        Cliente nicolas = new Cliente("Nicolas Fiedler", "XXX.XXX.XXX-XX", listaContatosNicolas, listaEnderecosNicolas);

        ContaCorrente contaCorrenteLucas = new ContaCorrente(lucas, "2189", "5", 2500.5, 30);
        ContaPoupanca contaPoupancaLucas = new ContaPoupanca(lucas, "3021", "1", 1800);
        ContaPagamento contaPagamentoNicolas = new ContaPagamento(nicolas, "3000", "7", 1100);


        System.out.println("----------------------- Mostrando Cliente -----------------------");
        lucas.imprimirCliente();

        System.out.println("----------------------- Testes Conta Corrente -----------------------");
        contaCorrenteLucas.imprimir();
        contaCorrenteLucas.depositar(200);
        System.out.println("\n--------- Após depósito");
        contaCorrenteLucas.imprimir();

        contaCorrenteLucas.transferir(contaPoupancaLucas, 240.75);
        System.out.println("\n--------- Após transeferencia para outra conta");
        contaCorrenteLucas.imprimir();

        System.out.println("\n----------------------- Testes Conta Corrente -----------------------");
        contaPoupancaLucas.imprimir();

        contaPoupancaLucas.sacar(100);
        System.out.println("\n--------- Após sacar");
        contaPoupancaLucas.imprimir();

        contaPoupancaLucas.creditarTaxa();
        System.out.println("\n--------- Após creditar taxa");
        contaPoupancaLucas.imprimir();

        System.out.println("\n----------------------- Testes Conta Pagamento -----------------------");
        contaPagamentoNicolas.imprimir();

        contaPagamentoNicolas.sacar(1096);
        System.out.println("\n--------- Após tentar sacar valor inválido");
        contaPagamentoNicolas.imprimir();

        contaPagamentoNicolas.transferir(contaCorrenteLucas, 1);
        System.out.println("\n--------- Após transefir");
        contaPagamentoNicolas.imprimir();

        contaPagamentoNicolas.sacar(1094.75);
        System.out.println("\n--------- Após sacar valor máximo que retire tudo, considerando taxa de saque");
        contaPagamentoNicolas.imprimir();

    }
}

