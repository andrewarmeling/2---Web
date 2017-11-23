package br.com.agendaContato.jdbc;

import br.com.agendaContato.objetos.Contato;
import br.com.agendaContato.jdbcinterface.ContatoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCContatoDAO {

	private Connection conexao;

	public JDBCContatoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean inserir(Contato contato) {
		String comando = "insert into contato " + "(nome, endereco, telefone) " + "values(?,?,?)";
		
		PreparedStatement p;
		
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, contato.getNome());
			p.setString(2, contato.getEndereco());
			p.setString(3, contato.getTelefone());
			p.execute();
			
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
