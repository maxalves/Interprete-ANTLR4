package com.uezolangprogramming.facil.interprete.ast;

import java.util.List;
import java.util.Map;

public class Condicional implements ASTNode {
	private ASTNode condition;

	public Condicional(ASTNode condition, List<ASTNode> conteudo1, List<ASTNode> conteudo2) {
		super();
		this.condition = condition;
		this.conteudo1 = conteudo1;
		this.conteudo2 = conteudo2;
	}

	private List<ASTNode> conteudo1;
	private List<ASTNode> conteudo2;

	@Override
	public Object execute(Map<String, Object> tabelaSimbolos) {
		if ((boolean)condition.execute(tabelaSimbolos)) {
			for (ASTNode n : conteudo1) {
				n.execute(tabelaSimbolos);
			}
		} else {
			for (ASTNode n : conteudo2) {
				n.execute(tabelaSimbolos);
			}
		}
		return null;
	}

}
