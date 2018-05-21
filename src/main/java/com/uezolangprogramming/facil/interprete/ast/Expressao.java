package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class Expressao implements ASTNode {
	private Object string;

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		return string;
	}

	public Expressao(String expressao) {
		super();
		this.string = expressao;
	}

}
