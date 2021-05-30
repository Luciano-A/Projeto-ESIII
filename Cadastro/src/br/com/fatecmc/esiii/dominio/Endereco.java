package br.com.fatecmc.esiii.dominio;

public class Endereco extends EntidadeDominio{
	private String logradouro;
	private String numero;
	private String cep;
	private String estado;
	private String cidade;

	
	public Endereco() {}
	
	public Endereco(String logradouro, String numero, String cep, 
			String estado, String cidade) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}

