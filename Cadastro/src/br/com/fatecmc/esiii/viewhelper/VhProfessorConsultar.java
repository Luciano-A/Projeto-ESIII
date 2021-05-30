package br.com.fatecmc.esiii.viewhelper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.dominio.Professor;

public class VhProfessorConsultar implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Professor professor = new Professor();
		return professor;
	}

	@Override
	public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		@SuppressWarnings("unchecked")
		List<EntidadeDominio> lista = (List<EntidadeDominio>) resultado;
		request.setAttribute("professores", lista);
		RequestDispatcher rd = request.getRequestDispatcher("consultar-professor.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
