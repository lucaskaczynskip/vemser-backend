package br.com.dbc.vemser.pessoa.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbc.vemser.pessoa.api.entities.Contato;
import br.com.dbc.vemser.pessoa.api.services.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@GetMapping
	public List<Contato> list() {
		return contatoService.list();
	}
	
	@GetMapping("/{idPessoa}")
	public List<Contato> listContatoByIdPessoa
						 (@PathVariable("idPessoa") Integer idPessoa) throws Exception {
		return contatoService.getContatoByPessoa(idPessoa);
	}
	
	@PostMapping("/{idPessoa}")
	public Contato create(@PathVariable("idPessoa") Integer idPessoa,
						  @RequestBody Contato contato) {
		contato.setIdPessoa(idPessoa);
		return contatoService.create(contato);
	}
	
	@PutMapping("/{idContato}")
	public Contato update(@PathVariable("idContato") Integer idContato,
			  Contato contato) throws Exception {
		return contatoService.update(idContato, contato);
	}
	
	@DeleteMapping("/{idContato}")
	public Contato delete(@PathVariable("idContato") Integer idContato) throws Exception {
		return contatoService.delete(idContato);
	}
}