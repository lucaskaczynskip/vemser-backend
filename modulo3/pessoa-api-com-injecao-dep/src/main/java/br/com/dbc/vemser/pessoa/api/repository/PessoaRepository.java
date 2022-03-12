package br.com.dbc.vemser.pessoa.api.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import br.com.dbc.vemser.pessoa.api.entities.Pessoa;

@Repository
public class PessoaRepository {
	
	private static List<Pessoa> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Rafael Lazzari", LocalDate.parse("01/07/1990", formatter), "12345678916"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Ana", LocalDate.parse("01/07/1990", formatter), "12345678917"));
    }

    public Pessoa create(Pessoa pessoa) throws Exception {
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        
        if (StringUtils.isBlank(pessoa.getNome())) {
        	throw new Exception("Nome não pode ser vazio.");
        }
        
        if (ObjectUtils.isEmpty(pessoa.getDataNascimento())) {
        	throw new Exception("Data de nascimento não pode ser vazia.");
        }
        
        if (StringUtils.isBlank(pessoa.getCpf()) || StringUtils.length(pessoa.getCpf()) != 11) {
        	throw new Exception("CPF inválido.");
        }
        
        return pessoa;
    }

    public List<Pessoa> list() {
        return listaPessoas;
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public Pessoa delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        listaPessoas.remove(pessoaRecuperada);
        
        return pessoaRecuperada;
    }

    public List<Pessoa> listByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
}
