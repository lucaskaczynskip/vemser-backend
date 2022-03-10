package br.com.dbc.vemser.pessoa.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import br.com.dbc.vemser.pessoa.api.entities.Contato;

public class ContatoRepository {
	
	private List<Contato> listaContatos = new ArrayList<>();
	private AtomicInteger COUNTER = new AtomicInteger();
	
	public ContatoRepository() {
		listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "xxxxxxxxxx"));
		listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "xxxxxxxxxx"));
		listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, "xxxxxxxxxx"));
		listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, "xxxxxxxxxx"));
		listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, "xxxxxxxxxx"));
	}
	
	public Contato create(Contato contato) {
		contato.setIdContato(COUNTER.incrementAndGet());
		listaContatos.add(contato);
		
		return contato;
	}
	
	public List<Contato> list() {
        return listaContatos;
    }
	
	public Contato update(Integer id,
						  Contato contato) throws Exception {
		Contato contatoRecuperado = listaContatos.stream()
				.filter(c -> c.getIdContato().equals(id))
				.findFirst()
				.orElseThrow(() -> new Exception("Contato não econtrado"));
		
		listaContatos.remove(contatoRecuperado);
		
		return contatoRecuperado;
	}
	
	public Contato delete(Integer id) throws Exception {
		Contato contatoRecuperado = listaContatos.stream()
                .filter(c -> c.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        
		listaContatos.remove(contatoRecuperado);
        
        return contatoRecuperado;
	}

	public List<Contato> getContatoByIdPessoa(Integer idPessoa) throws Exception {
		List<Contato> contatosPessoa = listaContatos.stream()
				.filter(contato -> contato.getIdPessoa().equals(idPessoa))
				.collect(Collectors.toList());
	
		System.out.println(contatosPessoa);
		
		return contatosPessoa;
	}
}
