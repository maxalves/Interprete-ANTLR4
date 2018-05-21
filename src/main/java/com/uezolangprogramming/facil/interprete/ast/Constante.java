package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class Constante implements ASTNode {
	private Object valor;

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		return valor;
	}

	public Constante(Object value) {
		super();
		this.valor = value;
	}

}
