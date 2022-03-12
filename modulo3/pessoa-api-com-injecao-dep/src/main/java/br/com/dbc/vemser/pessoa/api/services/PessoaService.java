package br.com.dbc.vemser.pessoa.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.vemser.pessoa.api.entities.Pessoa;
import br.com.dbc.vemser.pessoa.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService(){
        pessoaRepository = new PessoaRepository();
    }

    public Pessoa create(Pessoa pessoa) throws Exception{
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
