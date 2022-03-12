package br.com.dbc.vemser.pessoa.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import br.com.dbc.vemser.pessoa.api.entities.Endereco;

@Repository
public class EnderecoRepository {

	private List<Endereco> lista = new ArrayList<>();
	private AtomicInteger COUNTER = new AtomicInteger();
	
	public EnderecoRepository() {
		lista.add(new Endereco(COUNTER.incrementAndGet(), 1, "Av. Mauricio Cardoso 2187"));
		lista.add(new Endereco(COUNTER.incrementAndGet(), 2, "Av. Mauricio Cardoso 2182"));
		lista.add(new Endereco(COUNTER.incrementAndGet(), 4, "Av. Mauricio Cardoso 2181"));
	}
	
	public Endereco create(Integer idPessoa, Endereco endereco) {
		endereco.setIdEndereco(COUNTER.incrementAndGet());
		endereco.setIdPessoa(idPessoa);
		lista.add(endereco);
		
		return endereco;
	}
	
	public List<Endereco> list() {
		return this.lista;
	}
	
	public Endereco update(Integer id, Endereco endereco) throws Exception {
		Endereco exists = this.getEnderecoBydId(id);
		endereco.setIdEndereco(exists.getIdEndereco());
		endereco.setIdPessoa(exists.getIdPessoa());
		lista.add(lista.indexOf(exists), endereco);
		lista.remove(exists);
		
		return endereco;
	}
	
	public Endereco delete(Integer id) throws Exception {
		Endereco e = this.getEnderecoBydId(id);
		lista.remove(e);
		return e;
	}
	
	public Endereco getEnderecoBydId(Integer id) throws Exception {
		Endereco endereco = lista.stream()
				.filter(e -> e.getIdEndereco().equals(id))
				.findFirst()
				.orElseThrow(() -> new Exception("Endereco não encontrado."));
		return endereco;
	}
	
	public List<Endereco> getEnderecoBydIdPessoa(Integer id) throws Exception {
		List<Endereco> endereco = lista.stream()
				.filter(e -> e.getIdPessoa().equals(id))
				.toList();
		return endereco;
	}
}
