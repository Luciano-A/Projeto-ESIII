package br.com.fatecmc.esiii.command;

import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public interface ICommand {
	public Object execute (EntidadeDominio entidade);
}
