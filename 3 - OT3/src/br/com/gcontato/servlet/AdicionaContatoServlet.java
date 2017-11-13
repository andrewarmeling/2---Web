package br.com.gcontato.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import br.com.armcontato.ArmazenaDadosContato;
import java.sql.Connection;
import br.com.bd.conexao.Conexao;
import br.com.jdbc.JDBCContatoDAO;

public class AdicionaContatoServlet extends HttpServlet {
	
	private static final long serialVersionUID=1L;
	
	public AdicionaContatoServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		ArmazenaDadosContato armdcontato = new ArmazenaDadosContato();
		armdcontato.setNome(request.getParameter("nome"));
		armdcontato.setEndereco(request.getParameter("endereco"));
		armdcontato.setTelefone(request.getParameter("telefone"));
		
		Conexao conec = new Conexao();
		Connection conexao = conec.abrirConexao();
		JDBCContatoDAO jdbcContato = new JDBCContatoDAO(conexao);
		
		boolean retorno = jdbcContato.inserir(armdcontato);
		conec.fecharConexao();
		
		if (retorno) {
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Contato cadastrado com sucesso!</h1>");
			out.println("</body>");
			out.println("</html>");
		
		} else {
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Erro no cadastramento da pessoa de contato!</h1>");
			out.println("</body>");
			out.println("</html>");
		}
		
		
		
	}

}
