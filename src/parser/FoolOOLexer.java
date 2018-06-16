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
		RPAR=19, CLPAR=20, CRPAR=21, IF=22, THEN=23, ELSE=24, PRINT=25, LET=26, 
		IN=27, INT=28, BOOL=29, VOID=30, RETURN=31, CLASS=32, EXTENDS=33, NEW=34, 
		NULL=35, MAIN=36, INTEGER=37, ID=38, WS=39, LINECOMENTS=40, BLOCKCOMENTS=41, 
		ERR=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DOT", "SEMIC", "COLON", "COMMA", "EQ", "ASM", "PLUS", "MINUS", "TIMES", 
		"DIV", "AND", "OR", "GTEQ", "LTEQ", "NOT", "TRUE", "FALSE", "LPAR", "RPAR", 
		"CLPAR", "CRPAR", "IF", "THEN", "ELSE", "PRINT", "LET", "IN", "INT", "BOOL", 
		"VOID", "RETURN", "CLASS", "EXTENDS", "NEW", "NULL", "MAIN", "DIGIT", 
		"INTEGER", "CHAR", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "';'", "':'", "','", "'=='", "'='", "'+'", "'-'", "'*'", 
		"'/'", "'&&'", "'||'", "'>='", "'<='", "'!'", "'true'", "'false'", "'('", 
		"')'", "'{'", "'}'", "'if'", "'then'", "'else'", "'print'", "'let'", "'in'", 
		"'int'", "'bool'", "'void'", "'return'", "'class'", "'extends'", "'new'", 
		"'null'", "'main'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOT", "SEMIC", "COLON", "COMMA", "EQ", "ASM", "PLUS", "MINUS", 
		"TIMES", "DIV", "AND", "OR", "GTEQ", "LTEQ", "NOT", "TRUE", "FALSE", "LPAR", 
		"RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", "PRINT", "LET", "IN", 
		"INT", "BOOL", "VOID", "RETURN", "CLASS", "EXTENDS", "NEW", "NULL", "MAIN", 
		"INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
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
		case 43:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.out.println("Invalid char: "+ getText()); lexicalErrors++; 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0114\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%"+
		"\3%\3%\3%\3&\3&\3\'\6\'\u00e0\n\'\r\'\16\'\u00e1\3(\3(\3)\3)\3)\7)\u00e9"+
		"\n)\f)\16)\u00ec\13)\3*\3*\3*\3*\3+\3+\3+\3+\7+\u00f6\n+\f+\16+\u00f9"+
		"\13+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u0106\n,\f,\16,\u0109\13,\3,"+
		"\3,\3,\3,\3,\3-\3-\3-\3-\3-\2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\2M\'O\2Q(S)U*W+Y,\3\2"+
		"\b\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2,,\61\61\3\2,,\3\2\61"+
		"\61\2\u0119\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2M\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3"+
		"\2\2\2\rf\3\2\2\2\17h\3\2\2\2\21j\3\2\2\2\23l\3\2\2\2\25n\3\2\2\2\27p"+
		"\3\2\2\2\31s\3\2\2\2\33v\3\2\2\2\35y\3\2\2\2\37|\3\2\2\2!~\3\2\2\2#\u0083"+
		"\3\2\2\2%\u0089\3\2\2\2\'\u008b\3\2\2\2)\u008d\3\2\2\2+\u008f\3\2\2\2"+
		"-\u0091\3\2\2\2/\u0094\3\2\2\2\61\u0099\3\2\2\2\63\u009e\3\2\2\2\65\u00a4"+
		"\3\2\2\2\67\u00a8\3\2\2\29\u00ab\3\2\2\2;\u00af\3\2\2\2=\u00b4\3\2\2\2"+
		"?\u00b9\3\2\2\2A\u00c0\3\2\2\2C\u00c6\3\2\2\2E\u00ce\3\2\2\2G\u00d2\3"+
		"\2\2\2I\u00d7\3\2\2\2K\u00dc\3\2\2\2M\u00df\3\2\2\2O\u00e3\3\2\2\2Q\u00e5"+
		"\3\2\2\2S\u00ed\3\2\2\2U\u00f1\3\2\2\2W\u00fc\3\2\2\2Y\u010f\3\2\2\2["+
		"\\\7\60\2\2\\\4\3\2\2\2]^\7=\2\2^\6\3\2\2\2_`\7<\2\2`\b\3\2\2\2ab\7.\2"+
		"\2b\n\3\2\2\2cd\7?\2\2de\7?\2\2e\f\3\2\2\2fg\7?\2\2g\16\3\2\2\2hi\7-\2"+
		"\2i\20\3\2\2\2jk\7/\2\2k\22\3\2\2\2lm\7,\2\2m\24\3\2\2\2no\7\61\2\2o\26"+
		"\3\2\2\2pq\7(\2\2qr\7(\2\2r\30\3\2\2\2st\7~\2\2tu\7~\2\2u\32\3\2\2\2v"+
		"w\7@\2\2wx\7?\2\2x\34\3\2\2\2yz\7>\2\2z{\7?\2\2{\36\3\2\2\2|}\7#\2\2}"+
		" \3\2\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080\u0081\7w\2\2\u0081\u0082"+
		"\7g\2\2\u0082\"\3\2\2\2\u0083\u0084\7h\2\2\u0084\u0085\7c\2\2\u0085\u0086"+
		"\7n\2\2\u0086\u0087\7u\2\2\u0087\u0088\7g\2\2\u0088$\3\2\2\2\u0089\u008a"+
		"\7*\2\2\u008a&\3\2\2\2\u008b\u008c\7+\2\2\u008c(\3\2\2\2\u008d\u008e\7"+
		"}\2\2\u008e*\3\2\2\2\u008f\u0090\7\177\2\2\u0090,\3\2\2\2\u0091\u0092"+
		"\7k\2\2\u0092\u0093\7h\2\2\u0093.\3\2\2\2\u0094\u0095\7v\2\2\u0095\u0096"+
		"\7j\2\2\u0096\u0097\7g\2\2\u0097\u0098\7p\2\2\u0098\60\3\2\2\2\u0099\u009a"+
		"\7g\2\2\u009a\u009b\7n\2\2\u009b\u009c\7u\2\2\u009c\u009d\7g\2\2\u009d"+
		"\62\3\2\2\2\u009e\u009f\7r\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1\7k\2\2\u00a1"+
		"\u00a2\7p\2\2\u00a2\u00a3\7v\2\2\u00a3\64\3\2\2\2\u00a4\u00a5\7n\2\2\u00a5"+
		"\u00a6\7g\2\2\u00a6\u00a7\7v\2\2\u00a7\66\3\2\2\2\u00a8\u00a9\7k\2\2\u00a9"+
		"\u00aa\7p\2\2\u00aa8\3\2\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7p\2\2\u00ad"+
		"\u00ae\7v\2\2\u00ae:\3\2\2\2\u00af\u00b0\7d\2\2\u00b0\u00b1\7q\2\2\u00b1"+
		"\u00b2\7q\2\2\u00b2\u00b3\7n\2\2\u00b3<\3\2\2\2\u00b4\u00b5\7x\2\2\u00b5"+
		"\u00b6\7q\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7f\2\2\u00b8>\3\2\2\2\u00b9"+
		"\u00ba\7t\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7w\2\2"+
		"\u00bd\u00be\7t\2\2\u00be\u00bf\7p\2\2\u00bf@\3\2\2\2\u00c0\u00c1\7e\2"+
		"\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c5"+
		"\7u\2\2\u00c5B\3\2\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7z\2\2\u00c8\u00c9"+
		"\7v\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc\7f\2\2\u00cc"+
		"\u00cd\7u\2\2\u00cdD\3\2\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7g\2\2\u00d0"+
		"\u00d1\7y\2\2\u00d1F\3\2\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7w\2\2\u00d4"+
		"\u00d5\7n\2\2\u00d5\u00d6\7n\2\2\u00d6H\3\2\2\2\u00d7\u00d8\7o\2\2\u00d8"+
		"\u00d9\7c\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7p\2\2\u00dbJ\3\2\2\2\u00dc"+
		"\u00dd\4\62;\2\u00ddL\3\2\2\2\u00de\u00e0\5K&\2\u00df\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2N\3\2\2\2"+
		"\u00e3\u00e4\t\2\2\2\u00e4P\3\2\2\2\u00e5\u00ea\5O(\2\u00e6\u00e9\5O("+
		"\2\u00e7\u00e9\5K&\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec"+
		"\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00ebR\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ed\u00ee\t\3\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b*"+
		"\2\2\u00f0T\3\2\2\2\u00f1\u00f2\7\61\2\2\u00f2\u00f3\7\61\2\2\u00f3\u00f7"+
		"\3\2\2\2\u00f4\u00f6\n\4\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00fa\u00fb\b+\2\2\u00fbV\3\2\2\2\u00fc\u00fd\7\61\2\2\u00fd\u00fe"+
		"\7,\2\2\u00fe\u0107\3\2\2\2\u00ff\u0106\n\5\2\2\u0100\u0101\7\61\2\2\u0101"+
		"\u0106\n\6\2\2\u0102\u0103\7,\2\2\u0103\u0106\n\7\2\2\u0104\u0106\5W,"+
		"\2\u0105\u00ff\3\2\2\2\u0105\u0100\3\2\2\2\u0105\u0102\3\2\2\2\u0105\u0104"+
		"\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\7,\2\2\u010b\u010c\7\61"+
		"\2\2\u010c\u010d\3\2\2\2\u010d\u010e\b,\2\2\u010eX\3\2\2\2\u010f\u0110"+
		"\13\2\2\2\u0110\u0111\b-\3\2\u0111\u0112\3\2\2\2\u0112\u0113\b-\4\2\u0113"+
		"Z\3\2\2\2\t\2\u00e1\u00e8\u00ea\u00f7\u0105\u0107\5\b\2\2\3-\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}