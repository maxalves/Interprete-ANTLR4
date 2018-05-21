package com.uezolangprogramming.facil.interprete.ast;

import java.util.Map;

public class Botanatela implements ASTNode {

	private ASTNode conteudo;

	public Botanatela(ASTNode conteudo) {
		super();
		this.conteudo = conteudo;
	}

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		System.out.println(conteudo.execute(tabelaSimbolos));
		return null;
	}

}
