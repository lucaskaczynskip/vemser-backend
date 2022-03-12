package br.com.dbc.vemser.pessoa.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.vemser.pessoa.api.entities.Contato;
import br.com.dbc.vemser.pessoa.api.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repo;
	
	public Contato create(Contato contato){
        return repo.create(contato);
    }

    public List<Contato> list(){
        return repo.list();
    }
    
    public List<Contato> getContatoByPessoa(Integer idPessoa) throws Exception {
    	return repo.getContatoByIdPessoa(idPessoa);
    }

    public Contato update(Integer idContato,
                         Contato contatoAtualizar) throws Exception {
        return repo.update(idContato, contatoAtualizar);
    }

    public Contato delete(Integer id) throws Exception {
        return repo.delete(id);
    }
}
