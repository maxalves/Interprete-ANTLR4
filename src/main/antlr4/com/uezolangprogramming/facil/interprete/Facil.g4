//CABEÇALHO
grammar Facil;
@parser::header {
	import java.util.Map;
	import java.util.HashMap;
}
@parser::members {
	Map<String, Object> tabelaSimbolos = new HashMap<String,Object>(); 
}

//GRAMATICA LIVRE DE CONTEXTO
programa: 
		PROGRAMA IDENTIFICADOR ABRE_CHAVES
		sentenca*
		FECHA_CHAVES;

sentenca: variavel_decl | variavel_assignacao | botanatela;

variavel_decl: VARIAVEL IDENTIFICADOR PONTO_VIRGULA
				{tabelaSimbolos.put($IDENTIFICADOR.text, null);};
variavel_assignacao: IDENTIFICADOR ASSIGNACAO expressao PONTO_VIRGULA
				{tabelaSimbolos.put($IDENTIFICADOR.text, $expressao.valor);};
botanatela: BOTANATELA expressao PONTO_VIRGULA
				{System.out.println($expressao.valor);};

expressao returns [Object valor]: 
				CONSTANTE {$valor = Integer.parseInt($CONSTANTE.text);}
				| 
				IDENTIFICADOR {$valor = tabelaSimbolos.get($IDENTIFICADOR.text);} ;

//GRAMATICA REGULAR
//PALAVRAS RESERVADAS
PROGRAMA: 'facil';
VARIAVEL: 'variavel';
BOTANATELA: 'botanatela';

//ARITMETICOS
SOMA: '+';
SUBTRACAO: '-';
MULTIPLICACAO: '*';
DIVISAO: '/';

//ASSIGNACAO 
ASSIGNACAO: '=';

//PARENTESES E PONTUACAO
ABRE_CHAVES: '{';
FECHA_CHAVES: '}';
ABRE_PARENTESES: '(';
FECHA_PARENTESES: ')';
PONTO_VIRGULA: ';';

//IDENTIFICADORES (Nome do programa ou nome de variaveis)
IDENTIFICADOR: [a-zA-Z_][a-zA-Z0-9_]*;
CONSTANTE: [0-9]+;

//PULAR QUEBRAS DE LINHA, ESPAÇOS E TABULACOES 
WS: [ \t\r\n]+ -> skip;