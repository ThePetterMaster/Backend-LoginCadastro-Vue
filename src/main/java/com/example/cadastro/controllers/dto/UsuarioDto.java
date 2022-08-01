package com.example.cadastro.controllers.dto;

import com.example.cadastro.modelo.Usuario;

public class UsuarioDto {

	private String nome;
	private String sobrenome;
	
	public UsuarioDto(Usuario usuario) {
		this.nome = usuario.getNome();

		this.sobrenome = usuario.getSobrenome();
	}

	public String getNome() {
		return this.nome;
	}

	
	public String getSobrenome() {
		return this.sobrenome;
	}
	
}