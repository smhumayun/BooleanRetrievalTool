// Generated from BooleanRetrievalQueryLanguage.g4 by ANTLR 4.5.3

package com.smhumayun.datascience.ire.booleanretrieval.query.parser.antlr4.generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BooleanRetrievalQueryLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, AND=3, OR=4, NOT=5, LPAR=6, RPAR=7, TERM=8, WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TRUE", "FALSE", "AND", "OR", "NOT", "LPAR", "RPAR", "TERM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'true'", "'false'", "'and'", "'or'", "'not'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "AND", "OR", "NOT", "LPAR", "RPAR", "TERM", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public BooleanRetrievalQueryLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BooleanRetrievalQueryLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13A\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\7\t\62\n\t\f\t\16\t\65\13\t\3\n\7\n"+
		"8\n\n\f\n\16\n;\13\n\3\n\5\n>\n\n\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\3\2\5\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\16\17\""+
		"\"C\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\32\3\2\2"+
		"\2\7 \3\2\2\2\t$\3\2\2\2\13\'\3\2\2\2\r+\3\2\2\2\17-\3\2\2\2\21/\3\2\2"+
		"\2\23=\3\2\2\2\25\26\7v\2\2\26\27\7t\2\2\27\30\7w\2\2\30\31\7g\2\2\31"+
		"\4\3\2\2\2\32\33\7h\2\2\33\34\7c\2\2\34\35\7n\2\2\35\36\7u\2\2\36\37\7"+
		"g\2\2\37\6\3\2\2\2 !\7c\2\2!\"\7p\2\2\"#\7f\2\2#\b\3\2\2\2$%\7q\2\2%&"+
		"\7t\2\2&\n\3\2\2\2\'(\7p\2\2()\7q\2\2)*\7v\2\2*\f\3\2\2\2+,\7*\2\2,\16"+
		"\3\2\2\2-.\7+\2\2.\20\3\2\2\2/\63\t\2\2\2\60\62\t\3\2\2\61\60\3\2\2\2"+
		"\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\22\3\2\2\2\65\63\3\2\2\2"+
		"\668\t\4\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:>\3\2\2\2;"+
		"9\3\2\2\2<>\7\2\2\3=9\3\2\2\2=<\3\2\2\2>?\3\2\2\2?@\b\n\2\2@\24\3\2\2"+
		"\2\6\2\639=\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}