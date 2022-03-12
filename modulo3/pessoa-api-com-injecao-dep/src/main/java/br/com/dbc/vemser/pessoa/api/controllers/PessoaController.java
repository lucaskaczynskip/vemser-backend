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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbc.vemser.pessoa.api.entities.Pessoa;
import br.com.dbc.vemser.pessoa.api.services.PessoaService;
import br.com.dbc.vemser.pessoa.api.services.PropertieReader;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PropertieReader propertieReader;
	
	@GetMapping("/ambiente")
	public String getAmbiente() {
		return propertieReader.getAmbiente();
	}

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }

    @GetMapping 
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname")
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PutMapping("/{idPessoa}")
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public Pessoa delete(@PathVariable("idPessoa") Integer id) throws Exception {
        return pessoaService.delete(id);
    }
}
