package br.com.agendaContatoRest.rest;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.agendaContatoRest.bd.conexao.Conexao;
import br.com.agendaContatoRest.jdbc.JDBCContatoDAO;
import br.com.agendaContatoRest.objetos.Contato;

@Path("contatoRest")
public class ContatoRest extends UtilRest {

	public ContatoRest() {}
	
	@POST
	@Path("/addContato")
	@Consumes("application/*")
	public Response addContato(String contatoParam) {
		try {
			Contato contato = new ObjectMapper().readValue(contatoParam, Contato.class);
			
			Conexao conec = new Conexao();
			Connection conexao = conec.abrirConexao();
			JDBCContatoDAO jdbcContato = new JDBCContatoDAO(conexao);
			jdbcContato.inserir(contato);
			conec.fecharConexao();
			
			return this.buildResponse("Contato cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
}
