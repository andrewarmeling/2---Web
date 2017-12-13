package br.com.agendaContato.jdbcinterface;

import br.com.agendaContato.objetos.Contato;
import java.util.List;

public interface ContatoDAO {

	public boolean inserir(Contato contato);
	public List<Contato> buscarPorNome(String nome);
	public Contato buscarPorId(int cod);
	public boolean atualizar (Contato contato);
	public boolean deletarContato(int id);

}