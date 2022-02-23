package com.dbc;

import java.util.*;
import java.util.stream.Collectors;

public class HomeworkStream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        //1- listar todas as pessoas
        System.out.println("------------ Ex 1 ------------");
        lista.forEach(System.out::println);

        //2- filtrar todas as pessoas com salario maior do que 5 mil
        System.out.println("\n------------ Ex 2 ------------");
        lista.stream()
                .filter(p -> p.getSalario() > 5000)
                .collect(Collectors.toList())
                .forEach(System.out::println);


        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente
        System.out.println("\n------------ Ex 3 ------------");
        lista.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desenvolvedor"))
                .sorted(Comparator.comparing(Pessoa::getSalario))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //4- fazer a média salarial de todos
        System.out.println("\n------------ Ex 4 ------------");
        System.out.println(
                "Média salarial: " +
                        lista.stream()
                                .mapToDouble(Pessoa::getSalario)
                                .average()
                                .getAsDouble()
        );

        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        System.out.println("\n------------ Ex 5 ------------");
        System.out.println(
                "Alguém ganha mais de 20 mil: " +
                        lista.stream()
                                .anyMatch(p -> p.getSalario() > 20000)
        );
        //6 - retornar uma lista de todos os ids das pessoas
        System.out.println("\n------------ Ex 6 ------------");
        List<Integer> listaIds =
                lista.stream()
                        .map(p -> p.getId())
                        .collect(Collectors.toList());

        System.out.println(listaIds);

        //7 - criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
        System.out.println("\n------------ Ex 7 ------------");

        List<Salario> listaSalarios = new ArrayList<>();

        lista.stream()
                .map(pessoa -> pessoa.getSalario())
                .forEach(value -> listaSalarios.add(new Salario(++Salario.i, value)));
        listaSalarios.forEach(System.out::println);

        //8- retornar um Map (HashMap) contendo os ids e os nomes dos colaboradores
        System.out.println("\n------------ Ex 8 ------------");
        Map<Integer, String> mapColaboradores = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));

        System.out.println(mapColaboradores);

        //9- com o mapa da questão 8, retornar o nome com o id=2
        System.out.println("\n------------ Ex 9 ------------");
        System.out.println(
                mapColaboradores.get(2)
        );
    }

    static class Salario {

        private int id;
        private double salario;

        public static int i = 0;

        public Salario(int id, double salario) {
            this.id = id;
            this.salario = salario;
        }

        public int getId() {
            return id;
        }

        public double getSalario() {
            return salario;
        }

        @Override
        public String toString() {
            return "Salario{" +
                    "id=" + id +
                    ", salario=" + salario +
                    '}';
        }
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", salario=" + salario +
                    ", cargo='" + cargo + '\'' +
                    '}';
        }
    }
}