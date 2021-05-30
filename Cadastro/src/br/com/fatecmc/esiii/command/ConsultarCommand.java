package br.com.fatecmc.esiii.command;

import java.util.List;

import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public class ConsultarCommand extends AbstractCommand {

	public List<EntidadeDominio> execute(EntidadeDominio entidade) {
			
		return fachada.consultar(entidade);
	}
}