package br.com.dbc.vemser.pessoa.api.services;

import java.util.List;

import br.com.dbc.vemser.pessoa.api.entities.Contato;
import br.com.dbc.vemser.pessoa.api.repository.ContatoRepository;

public class ContatoService {
	
	private ContatoRepository repo;
	
	public ContatoService() {
		repo = new ContatoRepository();
	}
	
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
