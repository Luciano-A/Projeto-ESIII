package br.com.fatecmc.esiii.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fatecmc.esiii.dao.*;
import br.com.fatecmc.esiii.dominio.*;
import br.com.fatecmc.esiii.util.*;

public class CursoDAO   implements IDAO{

	public void salvar(EntidadeDominio entidade) {
		Curso curso =(Curso)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
			
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_curso(cur_nome,cur_descricao)");
			sql.append("VALUES (?,?)");		
						
				pst = connection.prepareStatement(sql.toString(),
						Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, curso.getNome());
				pst.setString(2, curso.getDescricao());
			
	
	
				pst.executeUpdate();
				
				ResultSet rs = pst.getGeneratedKeys();	
				
				 
				if(rs.next())
					curso.setId(rs.getInt(1));	
	
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
			List<EntidadeDominio> cursos = new ArrayList<EntidadeDominio>();
			Connection connection=null;
			PreparedStatement pst = null;
			
			try {
				connection = Conexao.getConnectionPostgres();	
				connection.setAutoCommit(false);
				
		
								
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tb_curso;");
				
				
		pst = connection.prepareStatement(sql.toString(),
				Statement.RETURN_GENERATED_KEYS);
	
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Curso curs = new Curso();
			curs.setId(rs.getInt("cur_id"));
			curs.setNome(rs.getString("cur_nome"));
			curs.setDescricao(rs.getString("cur_descricao"));
			
	
			cursos.add(curs);
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
		return cursos;	
	}
	
	
	
	@Override
	public void alterar(EntidadeDominio entidade) {
		Curso curso =(Curso)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
			
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE public.tb_curso\r\n"
					+ "	SET cur_nome=?, cur_descricao=?\r\n"
					+ "	WHERE cur_id = ?;");
					
						
				pst = connection.prepareStatement(sql.toString(),
						Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, curso.getNome());
				pst.setString(2, curso.getDescricao());
				pst.setInt(3, curso.getId());
			
	
	
				pst.executeUpdate();
				
				ResultSet rs = pst.getGeneratedKeys();	
				
				 
				if(rs.next())
					curso.setId(rs.getInt(1));	
	
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
		Curso curso =(Curso)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
				
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM tb_curso ");
			sql.append("WHERE cur_id=?");		
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,curso.getId());
	
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getResultSet();	
			System.out.println(rs);
			 
			

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
	
	


	
}

