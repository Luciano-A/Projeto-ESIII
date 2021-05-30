package br.com.fatecmc.esiii.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.fatecmc.esiii.dominio.*;
import br.com.fatecmc.esiii.imp.*;

public class ValidadorExistenciaProfessor implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		ProfessorDAO dao = new ProfessorDAO();
		String msg =null;
		List<EntidadeDominio> professores = new ArrayList<EntidadeDominio>();
		Professor professorTestado=new Professor();
		professorTestado=(Professor)entidade;
		
		Professor professor=new Professor();
		professores =dao.consultar(professor);
		
		
		for(EntidadeDominio ED:professores) {
			Professor p =(Professor)ED;
			String cpf1 = p.getCpf();
			String cpf2 = professorTestado.getCpf();
			
			if(p.getId() != professorTestado.getId()) {
				if(cpf1.equals(cpf2) ) {
					msg= " Ja esta cadastrado ";
					
				}
			}		
		}	
		return msg;
	}

}
