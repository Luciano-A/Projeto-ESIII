package br.com.fatecmc.esiii.controle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.command.*;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;

import br.com.fatecmc.esiii.viewhelper.*;

/**
 * Servlet implementation class controle
 */
@WebServlet({"/controle","/cdCurso","/csCurso","/edCurso","/exCurso","/cdAluno","/csAluno","/edAluno","/exAluno","/cdProfessor","/csProfessor","/edProfessor","/exProfessor","/ccAluno","/ccProfessor"})
public class controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String operacao = null;
	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controle() {
        super();
        commands = new HashMap<String, ICommand>();
		commands.put("SALVAR", new SalvarCommand());
		commands.put("EXCLUIR", new ExcluirCommand());
		commands.put("CONSULTAR", new ConsultarCommand());
		commands.put("EDITAR", new EditarCommand());
		commands.put("CADASTRAR", new ConsultarCommand());
		
		
		vhs = new HashMap<String, IViewHelper>();
		vhs.put("/Cadastro/cdCurso", new VhCursoCadastrar());
		vhs.put("/Cadastro/csCurso", new VhCursoConsultar());
		vhs.put("/Cadastro/edCurso", new VhCursoEditar());
		vhs.put("/Cadastro/exCurso", new VhCursoExcluir());
		vhs.put("/Cadastro/cdAluno", new VhAlunoCadastrar());
		vhs.put("/Cadastro/csAluno", new VhAlunoConsultar());
		vhs.put("/Cadastro/edAluno", new VhAlunoEditar());
		vhs.put("/Cadastro/exAluno", new VhAlunoExcluir());
		vhs.put("/Cadastro/cdProfessor", new VhProfessorCadastrar());
		vhs.put("/Cadastro/csProfessor", new VhProfessorConsultar());
		vhs.put("/Cadastro/edProfessor", new VhProfessorEditar());
		vhs.put("/Cadastro/exProfessor", new VhProfessorExcluir());
		vhs.put("/Cadastro/ccAluno", new VhAlunoCadastrarRedirecionamento());
		vhs.put("/Cadastro/ccProfessor", new VhProfessorCadastrarRedirecionamento());
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operacao = request.getParameter("operacao");
		String uri = request.getRequestURI();
		System.out.print(uri +"---------"+operacao);
		
		IViewHelper vh = vhs.get(uri);
		EntidadeDominio entidade = vh.getEntidade(request);
		
		ICommand cmd = commands.get(operacao);

		Object msg = cmd.execute(entidade);
		
		

		vh.setView(msg, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
