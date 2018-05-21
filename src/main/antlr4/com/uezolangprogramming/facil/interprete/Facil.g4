grammar Facil;
@parser::header {
	import java.util.Map;
	import java.util.HashMap;
	import java.util.List;
	import java.util.ArrayList;
	import com.uezolangprogramming.facil.interprete.ast.*;
}
@parser::members {
	Map<String, Object> tabelaSimbolos = new HashMap<String,Object>(); 
}

programa:  PROGRAMA IDENTIFICADOR ABRE_CHAVES
		{
		List<ASTNode> conteudo = new ArrayList<ASTNode>();
		Map<String, Object> tabelaSimbolos = new HashMap<String, Object>();
		}
			(sentenca {conteudo.add($sentenca.node);})*
		FECHA_CHAVES
		{
			for(ASTNode n: conteudo) {
			n.execute(tabelaSimbolos);
		}
	}
;

sentenca returns [ASTNode node]: 
			botanatela {$node = $botanatela.node;} 
			| condicional {$node = $condicional.node;}
			| variavel_decl {$node = $variavel_decl.node;}
			| variavel_assignacao {$node = $variavel_assignacao.node;};

botanatela returns [ASTNode node]: BOTANATELA expressao PONTO_VIRGULA
			{$node = new Botanatela($expressao.node);};

condicional returns [ASTNode node]: 
			SE ABRE_PARENTESES expressao FECHA_PARENTESES
			{
				List<ASTNode> conteudo1 = new ArrayList<ASTNode>();
			}
			ABRE_CHAVES (s1=sentenca {conteudo1.add($s1.node);})* FECHA_CHAVES
			SENAO
			{
				List<ASTNode> conteudo2 = new ArrayList<ASTNode>();
			}
			ABRE_CHAVES (s2=sentenca {conteudo2.add($s2.node);})* FECHA_CHAVES
			{
				$node = new Condicional($expressao.node, conteudo1, conteudo2);
			};

expressao returns [ASTNode node]:
			t1=fator {$node = $t1.node;}
			((SOMA t2=fator {$node = new Soma($node, $t2.node);}) |
			(SUBTRACAO t3=fator {$node = new Subtracao($node, $t3.node);}))*;
				
fator returns [ASTNode node]: 
			t1=termo {$node = $t1.node;}
			((MULTIPLICACAO  t2=termo {$node = new Multiplicacao($node, $t2.node);}) |
			(DIVISAO t3=fator {$node = new Divisao($node, $t3.node);}))*
			| ((t4=termo {$node = $t4.node;} MAIOR t5=termo {$node = new Maior($node, $t5.node);})
			| (t4=termo {$node = $t4.node;} MENOR t5=termo {$node = new Menor($node, $t5.node);})
			| (t4=termo {$node = $t4.node;} IGUAL t5=termo {$node = new Maior($node, $t5.node);}))*;

termo returns [ASTNode node]: 
			CONSTANTE {$node = new Constante(Integer.parseInt($CONSTANTE.text));}
			| RET IDENTIFICADOR {$node = new Expressao($IDENTIFICADOR.text);} RET
			| BOOLEANO {$node = new Constante(Boolean.parseBoolean($BOOLEANO.text));}
			| ABRE_PARENTESES expressao {$node = $expressao.node;} FECHA_PARENTESES
			| IDENTIFICADOR {$node = new VariavelRef($IDENTIFICADOR.text);};				

variavel_decl returns [ASTNode node]: 
			VARIAVEL IDENTIFICADOR PONTO_VIRGULA {$node = new VariavelDecl($IDENTIFICADOR.text);};

variavel_assignacao returns [ASTNode node]: 
			IDENTIFICADOR ASSIGNACAO expressao PONTO_VIRGULA {$node = new VariavelAssignacao($IDENTIFICADOR.text, $expressao.node);};

PROGRAMA: 'facil';
VARIAVEL: 'variavel';
BOTANATELA: 'botanatela';

SE: 'se';
SENAO: 'senao';
BOOLEANO: 'true' | 'false';

SOMA: '+';
SUBTRACAO: '-';
MULTIPLICACAO: '*';
DIVISAO: '/';

MAIOR: '>';
MENOR: '<';
IGUAL: '==';

ASSIGNACAO: '=';

ABRE_CHAVES: '{';
FECHA_CHAVES: '}';
ABRE_PARENTESES: '(';
FECHA_PARENTESES: ')';
PONTO_VIRGULA: ';';
RET: '"';

IDENTIFICADOR: [a-zA-Z_][a-zA-Z0-9_]*;
CONSTANTE: [0-9]+;

WS: [ \t\r\n]+ -> skip;