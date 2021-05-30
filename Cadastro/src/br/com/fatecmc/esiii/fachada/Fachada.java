package br.com.fatecmc.esiii.fachada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fatecmc.esiii.dao.IDAO;
import br.com.fatecmc.esiii.dominio.Aluno;
import br.com.fatecmc.esiii.dominio.Curso;
import br.com.fatecmc.esiii.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.dominio.Professor;
import br.com.fatecmc.esiii.imp.AlunoDAO;
import br.com.fatecmc.esiii.imp.CursoDAO;
import br.com.fatecmc.esiii.imp.ProfessorDAO;
import br.com.fatecmc.esiii.strategy.IStrategy;

import br.com.fatecmc.esiii.strategy.*;

public class Fachada implements IFachada {
	private Map<String , IDAO> daos;
	private Map<String , List<IStrategy>> rns;
	
	public Fachada() {
		definirDAOS();
		definirRNS();
	}
	private void definirRNS() {
		rns = new HashMap<String , List<IStrategy>>();
		
		ValidadorCPF vCpf = new ValidadorCPF();
		ValidadorCurso vCurso = new ValidadorCurso();
		ValidadorDadosObrigatoriosAluno vDadosAluno = new ValidadorDadosObrigatoriosAluno();
		ValidadorDadosObrigatoriosProfessor vDadosProfessor = new ValidadorDadosObrigatoriosProfessor();
		//ValidadorEndereco vEnd = new ValidadorEndereco();
		ValidadorExistenciaAluno vExisAluno = new ValidadorExistenciaAluno();
		ValidadorExistenciaProfessor vExisProfessor = new ValidadorExistenciaProfessor();
		ValidadorRg vRg = new ValidadorRg();
		
		List<IStrategy> rnsProfessor = new ArrayList<IStrategy>();
		rnsProfessor.add(vCpf);
		rnsProfessor.add(vDadosProfessor);
		rnsProfessor.add(vExisProfessor);
		//rnsProfessor.add(vEnd);
		
		List<IStrategy> rnsAluno = new ArrayList<IStrategy>();
		rnsAluno.add(vDadosAluno);
		rnsAluno.add(vExisAluno);
		//rnsAluno.add(vEnd);
		rnsAluno.add(vRg);
		
		List<IStrategy> rnsCurso = new ArrayList<IStrategy>();
		rnsCurso.add(vCurso);
		
		rns.put(Professor.class.getName(), rnsProfessor);
		rns.put(Aluno.class.getName(), rnsAluno);
		rns.put(Curso.class.getName(), rnsCurso);
		
		
	}
	
	private void definirDAOS() {
		daos = new HashMap<String , IDAO>();
		daos.put(Professor.class.getName(),new ProfessorDAO());
		daos.put(Aluno.class.getName(), new AlunoDAO());
		daos.put(Curso.class.getName(), new CursoDAO());
	
	}

	@Override
	public String salvar(EntidadeDominio entidade) {
		String nomeClasse = entidade.getClass().getName();
		String msg = executarRegras(entidade);
		if (msg == null ) {
			IDAO dao = daos.get(nomeClasse);
			dao.salvar(entidade);
		}else {
			return msg;
		}
		return null;
	}
	private String executarRegras(EntidadeDominio entidade) {
		String nomeClasse = entidade.getClass().getName();
		StringBuilder msg = new StringBuilder();
		
		List<IStrategy> regras = rns.get(nomeClasse);
		
		if(regras != null) {
			for (IStrategy s : regras) {
				String m = s.processar(entidade);
				
				if(m != null) {
					msg.append("<br>"); 
					msg.append(m); 
				}
			}
		}
		if(msg.length()>0) {
			return msg.toString();
		}else {
			return null;
		}
	}

	@Override
	public String editar(EntidadeDominio entidade) {
		String nomeClasse = entidade.getClass().getName();
		String msg = executarRegras(entidade);
		IDAO dao = daos.get(nomeClasse);
		if (msg == null ) {
		try {
			dao.alterar(entidade);	
		} catch (Exception e) {
			msg = e.toString();
		}}
		return msg;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		String nomeClasse = entidade.getClass().getName();
		String msg = null;
		IDAO dao = daos.get(nomeClasse);
		try {
			dao.excluir(entidade);
		} catch (Exception e) {
			msg = e.toString();
			System.out.print(msg);
		}
		return msg;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		String nomeClasse = entidade.getClass().getName();

			IDAO dao = daos.get(nomeClasse);
			lista = dao.consultar(entidade);
		return lista;
	}

}
