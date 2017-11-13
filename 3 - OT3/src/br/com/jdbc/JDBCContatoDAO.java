package br.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.jdbcinterface.ContatoDAO;
import br.com.armcontato.ArmazenaDadosContato;

public class JDBCContatoDAO implements ContatoDAO {

	private Connection conexao;
	
	public JDBCContatoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public boolean inserir(ArmazenaDadosContato armdcontato) {
		String comando = "insert into contato (nome, endereco, telefone) values (?,?,?)";
	
		PreparedStatement p;
		
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, armdcontato.getNome());
			p.setString(2, armdcontato.getEndereco());
			p.setString(3, armdcontato.getTelefone());
			p.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		
		return true;
	
	}
	
}
