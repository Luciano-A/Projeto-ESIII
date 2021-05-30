package br.com.fatecmc.esiii.viewhelper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.dominio.Curso;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public class VhCursoConsultar implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Curso curso = new Curso();
		
		return curso;
	}

	@Override
	public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		@SuppressWarnings("unchecked")
		List<EntidadeDominio> lista = (List<EntidadeDominio>) resultado;
		request.setAttribute("cursos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("consultar-curso.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
