package br.com.dbc.vemser.pessoa.api.entities;

public class Contato {
	
	private Integer idContato;
	private Integer idPessoa;
	private String numero;
	
	
	public Contato(Integer idContato, Integer idPessoa, String numero) {
		this.idContato = idContato;
		this.idPessoa = idPessoa;
		this.numero = numero;
	}
	
	public Integer getIdContato() {
		return idContato;
	}
	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
