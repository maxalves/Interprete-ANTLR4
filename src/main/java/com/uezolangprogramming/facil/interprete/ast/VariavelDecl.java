package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class VariavelDecl implements ASTNode {
	private String nome;

	public VariavelDecl(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		tabelaSimbolos.put(nome, new Object());
		return null;
	}

}
