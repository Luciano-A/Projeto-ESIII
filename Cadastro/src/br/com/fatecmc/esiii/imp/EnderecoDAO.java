package br.com.fatecmc.esiii.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.fatecmc.esiii.dominio.*;
import br.com.fatecmc.esiii.util.Conexao;



public class EnderecoDAO extends AbstractDAO{
	
	public EnderecoDAO() {
		
	}
	
	public EnderecoDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(EntidadeDominio entidade) {		
		Endereco endereco = (Endereco)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		try {
			
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);	
						
					
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_endereco ( end_cidade, end_estado, end_logradouro, end_numero, end_cep) ");
			sql.append(" VALUES ( ?, ?, ?, ?, ?)");		
					
			pst = connection.prepareStatement(sql.toString(),
			Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, endereco.getCidade());
			pst.setString(2, endereco.getEstado());	
			pst.setString(3, endereco.getLogradouro());
			pst.setString(4, endereco.getNumero());
			pst.setString(5, endereco.getCep());
			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();			
			if(rs.next())
				endereco.setId(rs.getInt(1));		
			
			
			connection.commit();	
							
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}
		
		
		finally{
			try {
				pst.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco)entidade;
		Connection connection=null;
		PreparedStatement pst = null;
		try {
			
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);	
						
					
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_endereco " );
			sql.append(" SET  end_cidade=?, end_estado=?, end_logradouro=?, end_numero=?, end_cep=? ");
			sql.append(" WHERE ( end_id = ?) ");		
					
			pst = connection.prepareStatement(sql.toString(),
			Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, endereco.getCidade());
			pst.setString(2, endereco.getEstado());	
			pst.setString(3, endereco.getLogradouro());
			pst.setString(4, endereco.getNumero());
			pst.setString(5, endereco.getCep());
			pst.setInt(6, endereco.getId());
			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();			
			if(rs.next())
				endereco.setId(rs.getInt(1));		
			
			
			connection.commit();	
							
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}
		
		
		finally{
			try {
				pst.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		Endereco endereco =(Endereco)entidade;

		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
				
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM tb_endereco ");
			sql.append("WHERE end_id=?");		
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,endereco.getId());
	
			
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

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		List<EntidadeDominio> enderecos = new ArrayList<EntidadeDominio>();
		Connection connection=null;
		PreparedStatement pst = null;
		
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);
			
	
							
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tb_endereco;");
			
			
		pst = connection.prepareStatement(sql.toString(),
				Statement.RETURN_GENERATED_KEYS);
	
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Endereco ende = new Endereco();
			ende.setId(rs.getInt("end_id"));
			ende.setCep(rs.getString("end_cep"));
			ende.setCidade(rs.getString("end_cidade"));
			ende.setEstado(rs.getString("end_estado"));
			ende.setLogradouro(rs.getString("end_logradouro"));
			ende.setNumero(rs.getString("end_numero"));
			
			enderecos.add(ende);
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
		return enderecos;	
		
	}

	
	
}
