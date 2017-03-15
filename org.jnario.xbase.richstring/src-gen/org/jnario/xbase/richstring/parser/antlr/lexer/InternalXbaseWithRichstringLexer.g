
/*
 * generated by Xtext
 */
lexer grammar InternalXbaseWithRichstringLexer;


@header {
package org.jnario.xbase.richstring.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}




Synchronized : 'synchronized';

Instanceof : 'instanceof';

Extension : 'extension';

Default : 'default';

Extends : 'extends';

Finally : 'finally';

Import : 'import';

Return : 'return';

Static : 'static';

Switch : 'switch';

Typeof : 'typeof';

Catch : 'catch';

False : 'false';

Super : 'super';

Throw : 'throw';

While : 'while';

Case : 'case';

Else : 'else';

Null : 'null';

True : 'true';

ExclamationMarkEqualsSignEqualsSign : '!==';

FullStopFullStopLessThanSign : '..<';

EqualsSignEqualsSignEqualsSign : '===';

For : 'for';

New : 'new';

Try : 'try';

Val : 'val';

Var : 'var';

ExclamationMarkEqualsSign : '!=';

PercentSignEqualsSign : '%=';

AmpersandAmpersand : '&&';

AsteriskAsterisk : '**';

AsteriskEqualsSign : '*=';

PlusSignPlusSign : '++';

PlusSignEqualsSign : '+=';

HyphenMinusHyphenMinus : '--';

HyphenMinusEqualsSign : '-=';

HyphenMinusGreaterThanSign : '->';

FullStopFullStop : '..';

SolidusEqualsSign : '/=';

ColonColon : '::';

LessThanSignGreaterThanSign : '<>';

EqualsSignEqualsSign : '==';

EqualsSignGreaterThanSign : '=>';

GreaterThanSignEqualsSign : '>=';

QuestionMarkFullStop : '?.';

QuestionMarkColon : '?:';

As : 'as';

Do : 'do';

If : 'if';

VerticalLineVerticalLine : '||';

ExclamationMark : '!';

NumberSign : '#';

PercentSign : '%';

Ampersand : '&';

LeftParenthesis : '(';

RightParenthesis : ')';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Solidus : '/';

Colon : ':';

Semicolon : ';';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

QuestionMark : '?';

CommercialAt : '@';

LeftSquareBracket : '[';

RightSquareBracket : ']';

LeftCurlyBracket : '{';

VerticalLine : '|';

RightCurlyBracket : '}';



RULE_RICH_TEXT : '\'\'\'' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF);

RULE_RICH_TEXT_START : '\'\'\'' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB';

RULE_RICH_TEXT_END : '\u00BB' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF);

RULE_RICH_TEXT_INBETWEEN : '\u00BB' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB';

fragment RULE_IN_RICH_STRING : ('\'\'' ~(('\u00AB'|'\''))|'\'' ~(('\u00AB'|'\''))|~(('\u00AB'|'\'')));

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+ ('#' (('b'|'B') ('i'|'I')|('l'|'L')))?;

RULE_INT : '0'..'9' ('0'..'9'|'_')*;

RULE_DECIMAL : RULE_INT (('e'|'E') ('+'|'-')? RULE_INT)? (('b'|'B') ('i'|'I'|'d'|'D')|('l'|'L'|'d'|'D'|'f'|'F'))?;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



