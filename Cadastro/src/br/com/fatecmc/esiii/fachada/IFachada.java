package br.com.fatecmc.esiii.fachada;

import br.com.fatecmc.esiii.dominio.EntidadeDominio;
import java.util.List;

public interface IFachada {
	public String salvar(EntidadeDominio entidade);
	public  String editar(EntidadeDominio entidade);
	public String excluir(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
}
