package br.com.agendaContatoRest.jdbcinterface;

import java.util.List;

import br.com.agendaContatoRest.objetos.Contato;

public interface ContatoDAO {
	
	public boolean inserir(Contato contato);
	
}