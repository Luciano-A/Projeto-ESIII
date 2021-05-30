package br.com.fatecmc.esiii.command;

import br.com.fatecmc.esiii.fachada.Fachada;

public abstract class AbstractCommand implements ICommand {
	protected Fachada fachada = new Fachada();
}
