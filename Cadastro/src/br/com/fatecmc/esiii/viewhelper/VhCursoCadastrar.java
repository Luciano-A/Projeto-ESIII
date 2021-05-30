package br.com.fatecmc.esiii.viewhelper;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.dominio.Curso;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public class VhCursoCadastrar implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
	 	Curso curso = new Curso();
		curso.setNome(request.getParameter("nome"));
		curso.setDescricao(request.getParameter("descricao"));
		
		return curso;
	}

	@Override
	public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		String msg =null;

		if (resultado != null) {
			msg ="Curso nao cadastrado!"+resultado;
		} else {
			msg ="Curso cadastrado!";
		}
		request.setAttribute("mensagem", msg);
		RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
