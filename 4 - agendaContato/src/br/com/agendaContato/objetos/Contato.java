package br.com.agendaContato.objetos;

import java.io.Serializable;

public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String endereco;
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
