package br.com.fatecmc.esiii.command;

import br.com.fatecmc.esiii.dominio.EntidadeDominio;;

public class EditarCommand extends AbstractCommand {

	public String execute(EntidadeDominio entidade) {
			
		return fachada.editar(entidade);
	}
}