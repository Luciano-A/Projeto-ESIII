package br.com.fatecmc.esiii.viewhelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public interface IViewHelper {
	public EntidadeDominio getEntidade(HttpServletRequest request);
	public void setView(Object resultado, 
			HttpServletRequest request, HttpServletResponse response)throws ServletException;
}
