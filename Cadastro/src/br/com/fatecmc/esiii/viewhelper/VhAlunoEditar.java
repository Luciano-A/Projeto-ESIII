package br.com.fatecmc.esiii.viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.dominio.Aluno;
import br.com.fatecmc.esiii.dominio.Curso;
import br.com.fatecmc.esiii.dominio.Endereco;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;

public class VhAlunoEditar implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Aluno aluno = new Aluno();
		Curso curso = new Curso();
		Endereco endereco = new Endereco();
		curso.setId(Integer.parseInt(request.getParameter("curso")));
		endereco.setId(Integer.parseInt(request.getParameter("endereco")));
		String cep = request.getParameter("cep");
		endereco.setCep(cep.replaceAll("[^0-9.]", ""));
		endereco.setCidade(request.getParameter("cidade"));
		endereco.setEstado(request.getParameter("estado"));
		String numero =request.getParameter("numero");
		endereco.setNumero(numero.replaceAll("[^0-9.]", ""));
		endereco.setLogradouro(request.getParameter("logradouro"));
		aluno.setId(Integer.parseInt(request.getParameter("id")));
		aluno.setCurso(curso);
		aluno.setEmail(request.getParameter("email"));
		aluno.setEndereco(endereco);
		aluno.setMnome(request.getParameter("mnome"));
		aluno.setPnome(request.getParameter("pnome"));
		String rg =request.getParameter("rg");
		aluno.setRg(rg.replaceAll("[^0-9.]", ""));
		aluno.setUnome(request.getParameter("unome") );
		
		return aluno;
	}

	@Override
	public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		String msg =null;

		if (resultado != null) {
			msg ="Aluno nao Editado!"+resultado;
		} else {
			msg ="Aluno Editado!";
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
