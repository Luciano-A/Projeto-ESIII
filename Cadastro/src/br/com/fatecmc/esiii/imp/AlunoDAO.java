package br.com.fatecmc.esiii.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fatecmc.esiii.dao.IDAO;
import br.com.fatecmc.esiii.dominio.*;
import br.com.fatecmc.esiii.conexao.Conexao;

public class AlunoDAO  implements IDAO{
	
	public void salvar(EntidadeDominio entidade) {
		Aluno aluno =(Aluno)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
			
			//Salvando endereco correspondente
			EnderecoDAO enderecodao = new EnderecoDAO();
			enderecodao.salvar(aluno.getEndereco());
				
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_aluno(alu_pnome, alu_mnome, alu_unome, alu_email, alu_cadastro, alu_rg, alu_cur_id, alu_end_id)");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");		
					
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			
		
			java.util.Date data = new java.util.Date();  
			java.sql.Date dataSql = new java.sql.Date(data.getTime());
			
			pst.setString(1, aluno.getPnome());
			pst.setString(2, aluno.getMnome());
			pst.setString(3, aluno.getUnome());
			pst.setString(4, aluno.getEmail());
			pst.setDate(5, dataSql);
			pst.setString(6, aluno.getRg());
			pst.setInt(7,aluno.getCurso().getId());
			pst.setInt(8, aluno.getEndereco().getId());

			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();	
			
			 
			if(rs.next())
				aluno.setId(rs.getInt(1));	

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
		List<EntidadeDominio> alunos = new ArrayList<EntidadeDominio>();
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
			
	
							
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT\r\n"
				+ "	*\r\n"
				+ "FROM tb_aluno\r\n"
				+ "INNER JOIN tb_curso\r\n"
				+ "	ON alu_cur_id = cur_id\r\n"
				+ "INNER JOIN tb_endereco\r\n"
				+ "	ON alu_end_id = end_id;");
				
				
		pst = connection.prepareStatement(sql.toString(),
				Statement.RETURN_GENERATED_KEYS);

		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Aluno alun = new Aluno();
			
			alun.setId(rs.getInt("alu_id"));
			alun.setPnome(rs.getString("alu_pnome"));
			alun.setMnome(rs.getString("alu_mnome"));
			alun.setUnome(rs.getString("alu_unome"));
			alun.setEmail(rs.getString("alu_email"));
			alun.setCadastro( rs.getDate("alu_cadastro").toString());
			alun.setRg(rs.getString("alu_rg"));
			
			Curso cur = new Curso();
			cur.setDescricao(rs.getString("cur_descricao"));
			cur.setNome(rs.getString("cur_nome"));
			cur.setId(rs.getInt("cur_id"));
			alun.setCurso(cur);
			
			Endereco end = new Endereco();
			end.setCep(rs.getString("end_cep"));
			end.setCidade(rs.getString("end_cidade"));
			end.setEstado(rs.getString("end_estado"));
			end.setId(rs.getInt("end_id"));
			end.setLogradouro(rs.getString("end_logradouro"));
			end.setNumero(rs.getString("end_numero"));
			alun.setEndereco(end);
			alunos.add(alun);
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
		return alunos;	
	}



	@Override
	public void alterar(EntidadeDominio entidade) {
		Aluno aluno =(Aluno)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
			
			//Editando endereco correspondente
			EnderecoDAO enderecodao = new EnderecoDAO();
			enderecodao.alterar(aluno.getEndereco());
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_aluno ");
			sql.append("SET alu_pnome=?, alu_mnome=?, alu_unome=?, alu_email=?, alu_rg=?, alu_cur_id=?, alu_end_id=? ");		
			sql.append("WHERE alu_id=?");
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			
		
			
			pst.setString(1, aluno.getPnome());
			pst.setString(2, aluno.getMnome());
			pst.setString(3, aluno.getUnome());
			pst.setString(4, aluno.getEmail());
			pst.setString(5, aluno.getRg());
			pst.setInt(6,aluno.getCurso().getId());
			pst.setInt(7,aluno.getEndereco().getId());
			pst.setInt(8, aluno.getId());
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();	
			
			 
			if(rs.next())
				 aluno.setId(rs.getInt(1));	

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
		Aluno aluno =(Aluno)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
				
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM tb_aluno ");
			sql.append("WHERE alu_id=?");		
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,aluno.getId());
	
			
			pst.executeUpdate();
			
			//ResultSet rs = pst.getResultSet();	

			 
			

			connection.commit();
			//Excluindo endereco correspondente
			EnderecoDAO enderecodao = new EnderecoDAO();
			enderecodao.excluir(aluno.getEndereco());
				
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
