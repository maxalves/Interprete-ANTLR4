package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class VariavelAssignacao implements ASTNode {
	private String nome;
	private ASTNode expressao;

	public VariavelAssignacao(String nome, ASTNode expressao) {
		super();
		this.nome = nome;
		this.expressao = expressao;
	}

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		tabelaSimbolos.put(nome, expressao.execute(tabelaSimbolos));
		return null;
	}

}
