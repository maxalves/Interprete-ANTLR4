
package com.uezolangprogramming.facil.interprete;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

	private static final String EXTENSION = "fcl";

	public static void main(String[] args) throws IOException {
		String programa = args.length > 1 ? args[1] : "test/test." + EXTENSION;

		System.out.println("Interpretando Arquivo -> " + programa);

		// Analisador Lexico
		FacilLexer lexer = new FacilLexer(new ANTLRFileStream(programa));
		// Saida do Analisador Lexico sendo preparada para o sintatico
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Analisador Sintatico
		FacilParser parser = new FacilParser(tokens);

		// Executa Analisador Sintatico para gerar uma arvode de sintaxe
		FacilParser.StartContext tree = parser.start();

		// Cria um visitante para visitar cada nodulo e realizar a analise semantica
		FacilCustomVisitor visitor = new FacilCustomVisitor();
		visitor.visit(tree);

		System.out.println("Final da Interpretacao");

	}

}
