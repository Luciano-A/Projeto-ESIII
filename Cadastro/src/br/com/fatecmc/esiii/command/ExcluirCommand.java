package br.com.fatecmc.esiii.command;

import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public class ExcluirCommand extends AbstractCommand {

	public String execute(EntidadeDominio entidade) {
			
		return fachada.excluir(entidade);
	}
}
