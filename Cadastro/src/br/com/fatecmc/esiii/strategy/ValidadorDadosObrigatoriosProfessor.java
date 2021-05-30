package br.com.fatecmc.esiii.strategy;

import br.com.fatecmc.esiii.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.dominio.Professor;

public class ValidadorDadosObrigatoriosProfessor implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Professor professor=new Professor();
		professor=(Professor)entidade;
		if(professor.getEmail()==null ||professor.getEmail().trim().equals("")) {
			return "  Email � um dado obrigatorio  ";
		}else if(professor.getFormacao()==null ||professor.getFormacao().trim().equals("")) {
			return "  Forma��o � um dado obrigatorio  ";
		}else if(professor.getPnome()==null ||professor.getPnome().trim().equals("")) {
			return "  Primeiro nome � um dado obrigatorio  ";
		}else if(professor.getUnome()==null ||professor.getUnome().trim().equals("")) {
			return "  Ultimo nome � um dado obrigatorio  ";
		}
		ValidadorEndereco vEnd = new ValidadorEndereco();
		return vEnd.processar(professor.getEndereco());
	}

}
