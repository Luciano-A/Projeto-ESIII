package br.com.fatecmc.esiii.viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.fatecmc.esiii.dominio.Endereco;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.dominio.Professor;

public class VhProfessorExcluir implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Professor professor = new Professor();
		professor.setId(Integer.parseInt(request.getParameter("id")));
		Endereco end = new Endereco();
		end.setId(Integer.parseInt(request.getParameter("idend")));
		
		professor.setEndereco(end);
		
		return professor;
	}

	@Override
	public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		String msg =null;

		if (resultado != null) {
			msg ="Professor nao Excluido!"+resultado;
		} else {
			msg ="Professor Excluido!";
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
