package br.com.andre.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		//Driver Manager é nativo do Java e escolhe a conexão com DB
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/AplicacaoDeTestes", "root", "as");
		
		//Aqui indicamos que "serão dadas instruções SQL"
		//criando um Statement
		Statement stat = conexao.createStatement();
		
		//Aqui é dado o comando, na linguagem SQL do DB
		stat.execute("select * from tabela");
		
		//Array de Resultados
		ResultSet resultSet = stat.getResultSet();
		
		//Lembrar de estudar o formato e manipulação do ResultSet
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("nome"));
			System.out.println("");
		}
		
		//Lembrar que é sempre importante fechar conexões
		conexao.close();
	}

}


//?autoReconnect=true&useSSL=false