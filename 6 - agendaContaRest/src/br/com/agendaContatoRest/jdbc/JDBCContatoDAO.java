package br.com.agendaContatoRest.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.agendaContatoRest.jdbcinterface.ContatoDAO;
import br.com.agendaContatoRest.objetos.Contato;

public class JDBCContatoDAO implements ContatoDAO {

	private Connection conexao;

	public JDBCContatoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean inserir(Contato contato) {
		String comando = "INSERT INTO contato " + "(nome,endereco,telefone,senha,email) " + "VALUES(?,?,?,?,?)";

		PreparedStatement p;

		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, contato.getNome());
			p.setString(2, contato.getEndereco());
			p.setString(3, contato.getTelefone());
			p.setString(4, contato.getSenha());
			p.setString(5, contato.getEmail());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
}
