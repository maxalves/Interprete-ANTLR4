package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class Igual implements ASTNode {
	private ASTNode operador1;
	private ASTNode operador2;

	public Igual(ASTNode operador1, ASTNode operador2) {
		super();
		this.operador1 = operador1;
		this.operador2 = operador2;
	}

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		return ((boolean)((int)operador1.execute(tabelaSimbolos) == (int) operador2.execute(tabelaSimbolos)));
	}
}
