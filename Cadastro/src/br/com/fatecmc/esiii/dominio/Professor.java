package br.com.fatecmc.esiii.dominio;

public class Professor extends Pessoa {
	private String cpf;
	private String formacao;
	private Curso curso;
	private Endereco endereco;
	
	public Professor() {}
	
	public Professor(String cpf,String formacao,Endereco endereco,Curso curso) {
	this.cpf = cpf;
	this.formacao=formacao;
	this.curso = curso;
	this.endereco = endereco;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
