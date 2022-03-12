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

import br.com.dbc.vemser.pessoa.api.entities.Endereco;
import br.com.dbc.vemser.pessoa.api.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public List<Endereco> getAll() {
		return service.get();
	}
	
	@GetMapping("/{idEndereco}")
	public Endereco getById(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
		return service.getById(idEndereco);
	}
	
	@GetMapping("/{idPessoa}/pessoa")
	public List<Endereco> getByPessoa(@PathVariable("idPessoa") Integer idPessoa) throws Exception {
		return service.getByPessoa(idPessoa);
	}
	
	@PostMapping("/{idPessoa}")
	public Endereco create(@PathVariable("idPessoa") Integer idPessoa,
						   @RequestBody Endereco endereco) {
		return service.create(idPessoa, endereco);
	}
	
	@PutMapping("/{idEndereco}")
	public Endereco update(@PathVariable("idEndereco") Integer idEndereco,
						   @RequestBody Endereco endereco) throws Exception {
		return service.update(idEndereco, endereco);
	}
	
	@DeleteMapping("/{idEndereco}")
	public Endereco delete(@PathVariable("idEndereco") Integer id) throws Exception {
		return service.delete(id);
	}
}
