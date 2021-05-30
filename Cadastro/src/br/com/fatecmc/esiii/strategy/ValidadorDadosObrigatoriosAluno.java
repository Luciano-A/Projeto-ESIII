package br.com.fatecmc.esiii.strategy;

import br.com.fatecmc.esiii.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.dominio.Aluno;

public class ValidadorDadosObrigatoriosAluno implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Aluno aluno=new Aluno();
		aluno=(Aluno)entidade;
		if(aluno.getEmail()==null ||aluno.getEmail().trim().equals("")) {
			return " Email é um dado obrigatorio  ";
		}else if(aluno.getPnome()==null ||aluno.getPnome().trim().equals("")) {
			return " Primeiro nome é um dado obrigatorio  ";
		}else if(aluno.getUnome()==null ||aluno.getUnome().trim().equals("")) {
			return " Ultimo nome é um dado obrigatorio  ";
		}
		ValidadorEndereco vEnd = new ValidadorEndereco();
		return vEnd.processar(aluno.getEndereco());
	}

}
