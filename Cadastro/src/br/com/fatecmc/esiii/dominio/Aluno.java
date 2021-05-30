package br.com.fatecmc.esiii.dominio;

public class Aluno extends Pessoa {
	private String rg;
	private Endereco endereco;
	private Curso curso;
	
	public Aluno() {}
	
	public Aluno(Endereco endereco,String rg,Curso curso) {
		this.rg = rg;
		this.endereco = endereco;
		this.curso = curso;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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
