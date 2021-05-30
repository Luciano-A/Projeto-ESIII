package br.com.fatecmc.esiii.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.fatecmc.esiii.dominio.*;
import br.com.fatecmc.esiii.imp.*;

public class ValidadorExistenciaAluno implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		AlunoDAO dao = new AlunoDAO();
		String msg =null;
		List<EntidadeDominio> alunos = new ArrayList<EntidadeDominio>();
		Aluno alunoTestado=new Aluno();
		alunoTestado=(Aluno)entidade;
		
		Aluno aluno=new Aluno();
		alunos =dao.consultar(aluno);
		
		
		for(EntidadeDominio ED:alunos) {
			Aluno p =(Aluno)ED;
			String rg1 = p.getRg();
			String rg2 = alunoTestado.getRg();
			
			if(p.getId() != alunoTestado.getId()) {
				if(rg1.equals(rg2) ) {
					msg= " Ja esta cadastrado ";
					
				}
			}
					
		}	
		return msg;
	}

}
