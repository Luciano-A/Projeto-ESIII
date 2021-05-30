package br.com.fatecmc.esiii.strategy;

import br.com.fatecmc.esiii.dominio.Curso;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public class ValidadorCurso implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Curso curso = (Curso)entidade;
		if(curso.getDescricao() == null || curso.getDescricao().trim().equals("")) {
			return " Descricao invalida  ";
		}else if(curso.getNome() == null || curso.getNome().trim().equals("")) {
			return " Nome invalido  ";
		}
		return null;
	}

}
