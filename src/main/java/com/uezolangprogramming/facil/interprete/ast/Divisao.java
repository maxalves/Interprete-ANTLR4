package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class Divisao implements ASTNode {

	private ASTNode operador1;
	private ASTNode operador2;

	public Divisao(ASTNode operador1, ASTNode operador2) {
		super();
		this.operador1 = operador1;
		this.operador2 = operador2;
	}

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		try {
			return (int) operador1.execute(tabelaSimbolos) / (int) operador2.execute(tabelaSimbolos);
		} catch (ArithmeticException ae) {
			System.out.println("ArithmeticException occured!");
		}
		return null;
	}

}
