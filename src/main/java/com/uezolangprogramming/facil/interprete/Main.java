
package com.uezolangprogramming.facil.interprete;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

	private static final String EXTENSION = "fcl";

	public static void main(String[] args) throws IOException {
		String program = args.length > 1 ? args[1] : "test/test." + EXTENSION;

		System.out.println("Interpreting file " + program);

		FacilLexer lexer = new FacilLexer(new ANTLRFileStream(program));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FacilParser parser = new FacilParser(tokens);

		FacilParser.StartContext tree = parser.start();

		FacilCustomVisitor visitor = new FacilCustomVisitor();
		visitor.visit(tree);

		System.out.println("Interpretation finished");

	}

}
