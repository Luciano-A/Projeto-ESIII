package br.com.fatecmc.esiii.strategy;

import br.com.fatecmc.esiii.dominio.Aluno;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public class ValidadorRg implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Aluno aluno = (Aluno) entidade;
		String rg = aluno.getRg();
		if(rg == null || rg == "" ||rg.length()<9 || rg.length()>9  ){
			return " Rg invalido ";
		}
		return null;
		
	}

}
