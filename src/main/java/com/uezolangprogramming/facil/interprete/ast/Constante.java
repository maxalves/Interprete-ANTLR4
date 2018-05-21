package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class Constante implements ASTNode {
	private Object value;

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		return value;
	}

	public Constante(Object value) {
		super();
		this.value = value;
	}

}
