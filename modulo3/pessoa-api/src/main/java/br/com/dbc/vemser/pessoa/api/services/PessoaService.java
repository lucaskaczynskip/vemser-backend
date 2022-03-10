package br.com.dbc.vemser.pessoa.api.services;

import java.util.List;

import br.com.dbc.vemser.pessoa.api.entities.Pessoa;
import br.com.dbc.vemser.pessoa.api.repository.PessoaRepository;

public class PessoaService {
	
    private PessoaRepository pessoaRepository;

    public PessoaService(){
        pessoaRepository = new PessoaRepository();
    }

    public Pessoa create(Pessoa pessoa){
        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public Pessoa delete(Integer id) throws Exception {
        return pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
