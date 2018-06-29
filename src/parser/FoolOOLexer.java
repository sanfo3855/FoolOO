// Generated from /home/andrea/IdeaProjects/compilatori/FoolOO/src/parser/FoolOO.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FoolOOLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, SEMIC=2, COLON=3, COMMA=4, EQ=5, ASM=6, PLUS=7, MINUS=8, TIMES=9, 
		DIV=10, AND=11, OR=12, GTEQ=13, LTEQ=14, NOT=15, TRUE=16, FALSE=17, LPAR=18, 
		RPAR=19, CLPAR=20, CRPAR=21, QLPAR=22, QRPAR=23, IF=24, THEN=25, ELSE=26, 
		PRINT=27, LET=28, IN=29, INT=30, BOOL=31, VOID=32, RETURN=33, CLASS=34, 
		EXTENDS=35, NEW=36, NULL=37, MAIN=38, INTEGER=39, ID=40, WS=41, LINECOMENTS=42, 
		BLOCKCOMENTS=43, ERR=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DOT", "SEMIC", "COLON", "COMMA", "EQ", "ASM", "PLUS", "MINUS", "TIMES", 
		"DIV", "AND", "OR", "GTEQ", "LTEQ", "NOT", "TRUE", "FALSE", "LPAR", "RPAR", 
		"CLPAR", "CRPAR", "QLPAR", "QRPAR", "IF", "THEN", "ELSE", "PRINT", "LET", 
		"IN", "INT", "BOOL", "VOID", "RETURN", "CLASS", "EXTENDS", "NEW", "NULL", 
		"MAIN", "DIGIT", "INTEGER", "CHAR", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", 
		"ERR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "';'", "':'", "','", "'=='", "'='", "'+'", "'-'", "'*'", 
		"'/'", "'&&'", "'||'", "'>='", "'<='", "'!'", "'true'", "'false'", "'('", 
		"')'", "'{'", "'}'", "'['", "']'", "'if'", "'then'", "'else'", "'print'", 
		"'let'", "'in'", "'int'", "'bool'", "'void'", "'return'", "'class'", "'extends'", 
		"'new'", "'null'", "'main'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOT", "SEMIC", "COLON", "COMMA", "EQ", "ASM", "PLUS", "MINUS", 
		"TIMES", "DIV", "AND", "OR", "GTEQ", "LTEQ", "NOT", "TRUE", "FALSE", "LPAR", 
		"RPAR", "CLPAR", "CRPAR", "QLPAR", "QRPAR", "IF", "THEN", "ELSE", "PRINT", 
		"LET", "IN", "INT", "BOOL", "VOID", "RETURN", "CLASS", "EXTENDS", "NEW", 
		"NULL", "MAIN", "INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", 
		"ERR"
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


	   //there is a much better way to do this, check the ANTLR guide
	   //I will leave it like this for now just becasue it is quick
	   //but it doesn't work well
	   public int lexicalErrors=0;


	public FoolOOLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FoolOO.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 45:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.err.println("Invalid char: "+ getText()); lexicalErrors++;System.exit(1); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u011c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&"+
		"\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3)\6)\u00e8\n)\r)\16)\u00e9\3*\3*\3+"+
		"\3+\3+\7+\u00f1\n+\f+\16+\u00f4\13+\3,\3,\3,\3,\3-\3-\3-\3-\7-\u00fe\n"+
		"-\f-\16-\u0101\13-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\7.\u010e\n.\f.\16"+
		".\u0111\13.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\2\2\60\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		"\2Q)S\2U*W+Y,[-].\3\2\b\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2"+
		",,\61\61\3\2,,\3\2\61\61\2\u0121\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2Q"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2"+
		"\2\2\5a\3\2\2\2\7c\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\rj\3\2\2\2\17l\3\2\2"+
		"\2\21n\3\2\2\2\23p\3\2\2\2\25r\3\2\2\2\27t\3\2\2\2\31w\3\2\2\2\33z\3\2"+
		"\2\2\35}\3\2\2\2\37\u0080\3\2\2\2!\u0082\3\2\2\2#\u0087\3\2\2\2%\u008d"+
		"\3\2\2\2\'\u008f\3\2\2\2)\u0091\3\2\2\2+\u0093\3\2\2\2-\u0095\3\2\2\2"+
		"/\u0097\3\2\2\2\61\u0099\3\2\2\2\63\u009c\3\2\2\2\65\u00a1\3\2\2\2\67"+
		"\u00a6\3\2\2\29\u00ac\3\2\2\2;\u00b0\3\2\2\2=\u00b3\3\2\2\2?\u00b7\3\2"+
		"\2\2A\u00bc\3\2\2\2C\u00c1\3\2\2\2E\u00c8\3\2\2\2G\u00ce\3\2\2\2I\u00d6"+
		"\3\2\2\2K\u00da\3\2\2\2M\u00df\3\2\2\2O\u00e4\3\2\2\2Q\u00e7\3\2\2\2S"+
		"\u00eb\3\2\2\2U\u00ed\3\2\2\2W\u00f5\3\2\2\2Y\u00f9\3\2\2\2[\u0104\3\2"+
		"\2\2]\u0117\3\2\2\2_`\7\60\2\2`\4\3\2\2\2ab\7=\2\2b\6\3\2\2\2cd\7<\2\2"+
		"d\b\3\2\2\2ef\7.\2\2f\n\3\2\2\2gh\7?\2\2hi\7?\2\2i\f\3\2\2\2jk\7?\2\2"+
		"k\16\3\2\2\2lm\7-\2\2m\20\3\2\2\2no\7/\2\2o\22\3\2\2\2pq\7,\2\2q\24\3"+
		"\2\2\2rs\7\61\2\2s\26\3\2\2\2tu\7(\2\2uv\7(\2\2v\30\3\2\2\2wx\7~\2\2x"+
		"y\7~\2\2y\32\3\2\2\2z{\7@\2\2{|\7?\2\2|\34\3\2\2\2}~\7>\2\2~\177\7?\2"+
		"\2\177\36\3\2\2\2\u0080\u0081\7#\2\2\u0081 \3\2\2\2\u0082\u0083\7v\2\2"+
		"\u0083\u0084\7t\2\2\u0084\u0085\7w\2\2\u0085\u0086\7g\2\2\u0086\"\3\2"+
		"\2\2\u0087\u0088\7h\2\2\u0088\u0089\7c\2\2\u0089\u008a\7n\2\2\u008a\u008b"+
		"\7u\2\2\u008b\u008c\7g\2\2\u008c$\3\2\2\2\u008d\u008e\7*\2\2\u008e&\3"+
		"\2\2\2\u008f\u0090\7+\2\2\u0090(\3\2\2\2\u0091\u0092\7}\2\2\u0092*\3\2"+
		"\2\2\u0093\u0094\7\177\2\2\u0094,\3\2\2\2\u0095\u0096\7]\2\2\u0096.\3"+
		"\2\2\2\u0097\u0098\7_\2\2\u0098\60\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b"+
		"\7h\2\2\u009b\62\3\2\2\2\u009c\u009d\7v\2\2\u009d\u009e\7j\2\2\u009e\u009f"+
		"\7g\2\2\u009f\u00a0\7p\2\2\u00a0\64\3\2\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3"+
		"\7n\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7g\2\2\u00a5\66\3\2\2\2\u00a6\u00a7"+
		"\7r\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7p\2\2\u00aa"+
		"\u00ab\7v\2\2\u00ab8\3\2\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7g\2\2\u00ae"+
		"\u00af\7v\2\2\u00af:\3\2\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7p\2\2\u00b2"+
		"<\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7v\2\2\u00b6"+
		">\3\2\2\2\u00b7\u00b8\7d\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7q\2\2\u00ba"+
		"\u00bb\7n\2\2\u00bb@\3\2\2\2\u00bc\u00bd\7x\2\2\u00bd\u00be\7q\2\2\u00be"+
		"\u00bf\7k\2\2\u00bf\u00c0\7f\2\2\u00c0B\3\2\2\2\u00c1\u00c2\7t\2\2\u00c2"+
		"\u00c3\7g\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7t\2\2"+
		"\u00c6\u00c7\7p\2\2\u00c7D\3\2\2\2\u00c8\u00c9\7e\2\2\u00c9\u00ca\7n\2"+
		"\2\u00ca\u00cb\7c\2\2\u00cb\u00cc\7u\2\2\u00cc\u00cd\7u\2\2\u00cdF\3\2"+
		"\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7z\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2"+
		"\7g\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7f\2\2\u00d4\u00d5\7u\2\2\u00d5"+
		"H\3\2\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7y\2\2\u00d9"+
		"J\3\2\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7w\2\2\u00dc\u00dd\7n\2\2\u00dd"+
		"\u00de\7n\2\2\u00deL\3\2\2\2\u00df\u00e0\7o\2\2\u00e0\u00e1\7c\2\2\u00e1"+
		"\u00e2\7k\2\2\u00e2\u00e3\7p\2\2\u00e3N\3\2\2\2\u00e4\u00e5\4\62;\2\u00e5"+
		"P\3\2\2\2\u00e6\u00e8\5O(\2\u00e7\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00eaR\3\2\2\2\u00eb\u00ec\t\2\2\2"+
		"\u00ecT\3\2\2\2\u00ed\u00f2\5S*\2\u00ee\u00f1\5S*\2\u00ef\u00f1\5O(\2"+
		"\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3V\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\u00f6\t\3\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\b,\2\2\u00f8X\3\2\2\2\u00f9"+
		"\u00fa\7\61\2\2\u00fa\u00fb\7\61\2\2\u00fb\u00ff\3\2\2\2\u00fc\u00fe\n"+
		"\4\2\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\b-"+
		"\2\2\u0103Z\3\2\2\2\u0104\u0105\7\61\2\2\u0105\u0106\7,\2\2\u0106\u010f"+
		"\3\2\2\2\u0107\u010e\n\5\2\2\u0108\u0109\7\61\2\2\u0109\u010e\n\6\2\2"+
		"\u010a\u010b\7,\2\2\u010b\u010e\n\7\2\2\u010c\u010e\5[.\2\u010d\u0107"+
		"\3\2\2\2\u010d\u0108\3\2\2\2\u010d\u010a\3\2\2\2\u010d\u010c\3\2\2\2\u010e"+
		"\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7,\2\2\u0113\u0114\7\61\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0116\b.\2\2\u0116\\\3\2\2\2\u0117\u0118\13\2\2\2"+
		"\u0118\u0119\b/\3\2\u0119\u011a\3\2\2\2\u011a\u011b\b/\4\2\u011b^\3\2"+
		"\2\2\t\2\u00e9\u00f0\u00f2\u00ff\u010d\u010f\5\b\2\2\3/\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}