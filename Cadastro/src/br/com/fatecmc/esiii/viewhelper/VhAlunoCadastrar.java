package br.com.fatecmc.esiii.viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.dominio.*;


public class VhAlunoCadastrar implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Aluno aluno = new Aluno();
		Curso curso = new Curso();
		Endereco endereco = new Endereco();
		String cep = request.getParameter("cep");
		endereco.setCep(cep.replaceAll("[^0-9.]", ""));
		endereco.setCidade(request.getParameter("cidade"));
		endereco.setEstado(request.getParameter("estado"));
		String numero =request.getParameter("numero");
		endereco.setNumero(numero.replaceAll("[^0-9.]", ""));
		endereco.setLogradouro(request.getParameter("longradouro"));
		curso.setId(Integer.parseInt((request.getParameter("select"))));
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
			msg ="Aluno nao cadastrado!"+resultado;
		} else {
			msg ="Aluno cadastrado!";
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
