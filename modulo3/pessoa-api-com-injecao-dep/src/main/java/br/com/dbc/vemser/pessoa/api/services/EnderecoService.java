package br.com.dbc.vemser.pessoa.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.vemser.pessoa.api.entities.Endereco;
import br.com.dbc.vemser.pessoa.api.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository eRepo;
	
	public List<Endereco> get() {
		return eRepo.list();
	}
	
	public Endereco getById(Integer id) throws Exception {
		return eRepo.getEnderecoBydId(id);
	}
	
	public List<Endereco> getByPessoa(Integer id) throws Exception {
		return eRepo.getEnderecoBydIdPessoa(id);
	}
	
	public Endereco create(Integer id, Endereco endereco) {
		return eRepo.create(id, endereco);
	}
	
	public Endereco update(Integer id, Endereco endereco) throws Exception {
		return eRepo.update(id, endereco);
	}
	
	public Endereco delete(Integer id) throws Exception {
		return eRepo.delete(id);
	}
}
