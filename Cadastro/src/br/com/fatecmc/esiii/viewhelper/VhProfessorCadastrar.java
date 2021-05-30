package br.com.fatecmc.esiii.viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.dominio.Curso;
import br.com.fatecmc.esiii.dominio.Endereco;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.dominio.Professor;

public class VhProfessorCadastrar implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Professor professor = new Professor();
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
		professor.setCurso(curso);
		professor.setEmail(request.getParameter("email"));
		professor.setEndereco(endereco);
		professor.setMnome(request.getParameter("mnome"));
		professor.setPnome(request.getParameter("pnome"));
		String cpf = request.getParameter("cpf");
		professor.setCpf(cpf.replaceAll("[^0-9.]", ""));
		professor.setFormacao(request.getParameter("formacao"));
		professor.setUnome(request.getParameter("unome") );
		return professor;
	}

	@Override
	public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		String msg =null;

		if (resultado != null) {
			msg ="Professor nao cadastrado!"+resultado;
		} else {
			msg ="Professor cadastrado!";
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
