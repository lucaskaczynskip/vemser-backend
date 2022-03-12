package br.com.dbc.vemser.pessoa.api.entities;

public class Endereco {
	
	private Integer idEndereco;
	private Integer idPessoa;
	private String logradouro;
	
	public Endereco(Integer idEndereco, Integer idPessoa, String logradouro) {
		this.idEndereco = idEndereco;
		this.idPessoa = idPessoa;
		this.logradouro = logradouro;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
}
