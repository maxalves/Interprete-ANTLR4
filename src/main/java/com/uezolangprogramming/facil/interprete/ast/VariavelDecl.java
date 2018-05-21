package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class VariavelDecl implements ASTNode {
	private String nome;

	public VariavelDecl(String name) {
		super();
		this.nome = name;
	}

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		tabelaSimbolos.put(nome, new Object());
		return null;
	}

}
