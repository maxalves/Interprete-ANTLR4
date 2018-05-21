package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class VariavelRef implements ASTNode {
	private String nome;

	public VariavelRef(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		return tabelaSimbolos.get(nome);
	}

}
