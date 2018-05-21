package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class VariavelAssignacao implements ASTNode {
	private String nome;
	private ASTNode expressao;

	public VariavelAssignacao(String name, ASTNode expressao) {
		super();
		this.nome = name;
		this.expressao = expressao;
	}

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		tabelaSimbolos.put(nome, expressao.execute(tabelaSimbolos));
		return null;
	}

}
