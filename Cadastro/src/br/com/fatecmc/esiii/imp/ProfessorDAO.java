package br.com.fatecmc.esiii.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import br.com.fatecmc.esiii.dao.*;
import br.com.fatecmc.esiii.dominio.*;
import br.com.fatecmc.esiii.util.*;

public class ProfessorDAO implements IDAO{
	
	public void salvar(EntidadeDominio entidade) {
		Professor professor =(Professor)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
			
			//Salvando endereco correspondente
			EnderecoDAO enderecodao = new EnderecoDAO();
			enderecodao.salvar(professor.getEndereco());
				
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_professor(pro_pnome,pro_mnome,pro_unome,pro_email,pro_cadastro,pro_cpf,pro_formacao ,pro_cur_id , pro_end_id) ");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			
	
			java.util.Date data = new java.util.Date();  
			java.sql.Date dataSql = new java.sql.Date(data.getTime());
			
			pst.setString(1, professor.getPnome());
			pst.setString(2, professor.getMnome());
			pst.setString(3, professor.getUnome());
			pst.setString(4, professor.getEmail());
			pst.setDate(5, dataSql);
			pst.setString(6, professor.getCpf());
			pst.setString(7, professor.getFormacao());
			pst.setInt(8, professor.getCurso().getId());
			pst.setInt(9, professor.getEndereco().getId());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();	
			
			 
			if(rs.next())
				 professor.setId(rs.getInt(1));	

			connection.commit();	
				
		} catch (SQLException | ClassNotFoundException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			

		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
		}
			
}



	@Override
	public List<EntidadeDominio> consultar (EntidadeDominio entidade) {
		List<EntidadeDominio> professores = new ArrayList<EntidadeDominio>();
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
			
	
							
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT\r\n"
				+ "   *\r\n"
				+ "FROM\r\n"
				+ "    tb_professor\r\n"
				+ "INNER JOIN tb_curso\r\n"
				+ "    ON pro_cur_id = cur_id\r\n"
				+ "	INNER JOIN tb_endereco\r\n"
				+ "    ON pro_end_id = end_id;");
				
				
		pst = connection.prepareStatement(sql.toString(),
				Statement.RETURN_GENERATED_KEYS);
	
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Professor prof = new Professor();
			prof.setId(rs.getInt("pro_id"));
			prof.setPnome(rs.getString("pro_pnome"));
			prof.setMnome(rs.getString("pro_mnome"));
			prof.setUnome(rs.getString("pro_unome"));
			prof.setEmail(rs.getString("pro_email"));
			prof.setCadastro(rs.getDate("pro_cadastro").toString());
			prof.setCpf(rs.getString("pro_cpf"));
			prof.setFormacao(rs.getString("pro_formacao"));
			Curso cur = new Curso();
			cur.setDescricao(rs.getString("cur_descricao"));
			cur.setNome(rs.getString("cur_nome"));
			cur.setId(rs.getInt("cur_id"));
			prof.setCurso(cur);
			
			Endereco end = new Endereco();
			end.setCep(rs.getString("end_cep"));
			end.setCidade(rs.getString("end_cidade"));
			end.setEstado(rs.getString("end_estado"));
			end.setId(rs.getInt("end_id"));
			end.setLogradouro(rs.getString("end_logradouro"));
			end.setNumero(rs.getString("end_numero"));
			prof.setEndereco(end);
			
			professores.add(prof);
		}
				
		} catch (SQLException | ClassNotFoundException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return professores;	
	}



	@Override
	public void alterar(EntidadeDominio entidade) {
		Professor professor =(Professor)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
			
			//Editando endereco correspondente
			EnderecoDAO enderecodao = new EnderecoDAO();
			enderecodao.alterar(professor.getEndereco());
				
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE public.tb_professor\r\n"
					+ "	SET pro_pnome=?, pro_mnome=?, pro_unome=?, pro_email=?, pro_cadastro=?, pro_cpf=?, pro_formacao=?, pro_cur_id=?, pro_end_id=?\r\n"
					+ "	WHERE pro_id = ?;");
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			
			Date no = new Date(0);
			
			pst.setString(1, professor.getPnome());
			pst.setString(2, professor.getMnome());
			pst.setString(3, professor.getUnome());
			pst.setString(4, professor.getEmail());
			pst.setDate(5, no);
			pst.setString(6, professor.getCpf());
			pst.setString(7, professor.getFormacao());
			pst.setInt(8,professor.getCurso().getId());
			pst.setInt(9,professor.getEndereco().getId());
			pst.setInt(10,professor.getId());
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();	
			
			 
			if(rs.next())
				 professor.setId(rs.getInt(1));	

			connection.commit();	
				
		} catch (SQLException | ClassNotFoundException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			

		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
		}
		
	}



	@Override
	public void excluir(EntidadeDominio entidade) {
		Professor professor =(Professor)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
				
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM tb_professor ");
			sql.append("WHERE pro_id=?");		
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,professor.getId());
	
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getResultSet();	
			System.out.println(rs);
			 
			

			connection.commit();
			//Excluindo endereco correspondente
			EnderecoDAO enderecodao = new EnderecoDAO();
			enderecodao.excluir(professor.getEndereco());
				
		} catch (SQLException | ClassNotFoundException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			

		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
		}
		
	}




	
}
