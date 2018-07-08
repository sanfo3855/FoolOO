// Generated from /home/matteo/Developments/git/FoolOO/src/parser/SVM.g4 by ANTLR 4.7
package parser;

import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, STOREW=7, LOADW=8, BRANCH=9, 
		BRANCHEQ=10, BRANCHLESSEQ=11, BRANCHGREATEREQ=12, JS=13, LOADRA=14, STORERA=15, 
		LOADRV=16, STORERV=17, LOADFP=18, STOREFP=19, COPYFP=20, COPYFPM=21, LOADHP=22, 
		STOREHP=23, PRINT=24, PUSHTOHP=25, STOREFPO=26, LOADFPO=27, COPYFPO=28, 
		COPYFPP=29, PUSHMINUS=30, LOADFP1=31, LOADPN=32, STOREPN=33, COPYFPOF=34, 
		LOADFPOF=35, HALT=36, COL=37, LABEL=38, NUMBER=39, WHITESP=40, ERR=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "STOREW", "LOADW", "BRANCH", 
		"BRANCHEQ", "BRANCHLESSEQ", "BRANCHGREATEREQ", "JS", "LOADRA", "STORERA", 
		"LOADRV", "STORERV", "LOADFP", "STOREFP", "COPYFP", "COPYFPM", "LOADHP", 
		"STOREHP", "PRINT", "PUSHTOHP", "STOREFPO", "LOADFPO", "COPYFPO", "COPYFPP", 
		"PUSHMINUS", "LOADFP1", "LOADPN", "STOREPN", "COPYFPOF", "LOADFPOF", "HALT", 
		"COL", "LABEL", "NUMBER", "WHITESP", "ERR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'sw'", 
		"'lw'", "'b'", "'beq'", "'bleq'", "'bgeq'", "'js'", "'lra'", "'sra'", 
		"'lrv'", "'srv'", "'lfp'", "'sfp'", "'cfp'", "'cfpm'", "'lhp'", "'shp'", 
		"'print'", "'pthp'", "'sfpo'", "'lfpo'", "'cfpo'", "'cfpp'", "'pushminus'", 
		"'lfp1'", "'lpn'", "'spn'", "'cfpof'", "'lfpof'", "'halt'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "STOREW", "LOADW", "BRANCH", 
		"BRANCHEQ", "BRANCHLESSEQ", "BRANCHGREATEREQ", "JS", "LOADRA", "STORERA", 
		"LOADRV", "STORERV", "LOADFP", "STOREFP", "COPYFP", "COPYFPM", "LOADHP", 
		"STOREHP", "PRINT", "PUSHTOHP", "STOREFPO", "LOADFPO", "COPYFPO", "COPYFPP", 
		"PUSHMINUS", "LOADFP1", "LOADPN", "STOREPN", "COPYFPOF", "LOADFPOF", "HALT", 
		"COL", "LABEL", "NUMBER", "WHITESP", "ERR"
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


	public int lexicalErrors=0;


	public SVMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

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
		case 40:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.err.println("Invalid char: "+ getText()); lexicalErrors++;  
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u011a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3"+
		"%\3%\3%\3&\3&\3\'\3\'\7\'\u00fd\n\'\f\'\16\'\u0100\13\'\3(\3(\5(\u0104"+
		"\n(\3(\3(\7(\u0108\n(\f(\16(\u010b\13(\5(\u010d\n(\3)\6)\u0110\n)\r)\16"+
		")\u0111\3)\3)\3*\3*\3*\3*\3*\2\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\5\4\2C"+
		"\\c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\2\u011e\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5Z\3\2\2\2\7^\3"+
		"\2\2\2\tb\3\2\2\2\13f\3\2\2\2\rk\3\2\2\2\17o\3\2\2\2\21r\3\2\2\2\23u\3"+
		"\2\2\2\25w\3\2\2\2\27{\3\2\2\2\31\u0080\3\2\2\2\33\u0085\3\2\2\2\35\u0088"+
		"\3\2\2\2\37\u008c\3\2\2\2!\u0090\3\2\2\2#\u0094\3\2\2\2%\u0098\3\2\2\2"+
		"\'\u009c\3\2\2\2)\u00a0\3\2\2\2+\u00a4\3\2\2\2-\u00a9\3\2\2\2/\u00ad\3"+
		"\2\2\2\61\u00b1\3\2\2\2\63\u00b7\3\2\2\2\65\u00bc\3\2\2\2\67\u00c1\3\2"+
		"\2\29\u00c6\3\2\2\2;\u00cb\3\2\2\2=\u00d0\3\2\2\2?\u00da\3\2\2\2A\u00df"+
		"\3\2\2\2C\u00e3\3\2\2\2E\u00e7\3\2\2\2G\u00ed\3\2\2\2I\u00f3\3\2\2\2K"+
		"\u00f8\3\2\2\2M\u00fa\3\2\2\2O\u010c\3\2\2\2Q\u010f\3\2\2\2S\u0115\3\2"+
		"\2\2UV\7r\2\2VW\7w\2\2WX\7u\2\2XY\7j\2\2Y\4\3\2\2\2Z[\7r\2\2[\\\7q\2\2"+
		"\\]\7r\2\2]\6\3\2\2\2^_\7c\2\2_`\7f\2\2`a\7f\2\2a\b\3\2\2\2bc\7u\2\2c"+
		"d\7w\2\2de\7d\2\2e\n\3\2\2\2fg\7o\2\2gh\7w\2\2hi\7n\2\2ij\7v\2\2j\f\3"+
		"\2\2\2kl\7f\2\2lm\7k\2\2mn\7x\2\2n\16\3\2\2\2op\7u\2\2pq\7y\2\2q\20\3"+
		"\2\2\2rs\7n\2\2st\7y\2\2t\22\3\2\2\2uv\7d\2\2v\24\3\2\2\2wx\7d\2\2xy\7"+
		"g\2\2yz\7s\2\2z\26\3\2\2\2{|\7d\2\2|}\7n\2\2}~\7g\2\2~\177\7s\2\2\177"+
		"\30\3\2\2\2\u0080\u0081\7d\2\2\u0081\u0082\7i\2\2\u0082\u0083\7g\2\2\u0083"+
		"\u0084\7s\2\2\u0084\32\3\2\2\2\u0085\u0086\7l\2\2\u0086\u0087\7u\2\2\u0087"+
		"\34\3\2\2\2\u0088\u0089\7n\2\2\u0089\u008a\7t\2\2\u008a\u008b\7c\2\2\u008b"+
		"\36\3\2\2\2\u008c\u008d\7u\2\2\u008d\u008e\7t\2\2\u008e\u008f\7c\2\2\u008f"+
		" \3\2\2\2\u0090\u0091\7n\2\2\u0091\u0092\7t\2\2\u0092\u0093\7x\2\2\u0093"+
		"\"\3\2\2\2\u0094\u0095\7u\2\2\u0095\u0096\7t\2\2\u0096\u0097\7x\2\2\u0097"+
		"$\3\2\2\2\u0098\u0099\7n\2\2\u0099\u009a\7h\2\2\u009a\u009b\7r\2\2\u009b"+
		"&\3\2\2\2\u009c\u009d\7u\2\2\u009d\u009e\7h\2\2\u009e\u009f\7r\2\2\u009f"+
		"(\3\2\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a2\7h\2\2\u00a2\u00a3\7r\2\2\u00a3"+
		"*\3\2\2\2\u00a4\u00a5\7e\2\2\u00a5\u00a6\7h\2\2\u00a6\u00a7\7r\2\2\u00a7"+
		"\u00a8\7o\2\2\u00a8,\3\2\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7j\2\2\u00ab"+
		"\u00ac\7r\2\2\u00ac.\3\2\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7j\2\2\u00af"+
		"\u00b0\7r\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7r\2\2\u00b2\u00b3\7t\2\2\u00b3"+
		"\u00b4\7k\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7v\2\2\u00b6\62\3\2\2\2\u00b7"+
		"\u00b8\7r\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7j\2\2\u00ba\u00bb\7r\2\2"+
		"\u00bb\64\3\2\2\2\u00bc\u00bd\7u\2\2\u00bd\u00be\7h\2\2\u00be\u00bf\7"+
		"r\2\2\u00bf\u00c0\7q\2\2\u00c0\66\3\2\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3"+
		"\7h\2\2\u00c3\u00c4\7r\2\2\u00c4\u00c5\7q\2\2\u00c58\3\2\2\2\u00c6\u00c7"+
		"\7e\2\2\u00c7\u00c8\7h\2\2\u00c8\u00c9\7r\2\2\u00c9\u00ca\7q\2\2\u00ca"+
		":\3\2\2\2\u00cb\u00cc\7e\2\2\u00cc\u00cd\7h\2\2\u00cd\u00ce\7r\2\2\u00ce"+
		"\u00cf\7r\2\2\u00cf<\3\2\2\2\u00d0\u00d1\7r\2\2\u00d1\u00d2\7w\2\2\u00d2"+
		"\u00d3\7u\2\2\u00d3\u00d4\7j\2\2\u00d4\u00d5\7o\2\2\u00d5\u00d6\7k\2\2"+
		"\u00d6\u00d7\7p\2\2\u00d7\u00d8\7w\2\2\u00d8\u00d9\7u\2\2\u00d9>\3\2\2"+
		"\2\u00da\u00db\7n\2\2\u00db\u00dc\7h\2\2\u00dc\u00dd\7r\2\2\u00dd\u00de"+
		"\7\63\2\2\u00de@\3\2\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7r\2\2\u00e1\u00e2"+
		"\7p\2\2\u00e2B\3\2\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7r\2\2\u00e5\u00e6"+
		"\7p\2\2\u00e6D\3\2\2\2\u00e7\u00e8\7e\2\2\u00e8\u00e9\7h\2\2\u00e9\u00ea"+
		"\7r\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec\7h\2\2\u00ecF\3\2\2\2\u00ed\u00ee"+
		"\7n\2\2\u00ee\u00ef\7h\2\2\u00ef\u00f0\7r\2\2\u00f0\u00f1\7q\2\2\u00f1"+
		"\u00f2\7h\2\2\u00f2H\3\2\2\2\u00f3\u00f4\7j\2\2\u00f4\u00f5\7c\2\2\u00f5"+
		"\u00f6\7n\2\2\u00f6\u00f7\7v\2\2\u00f7J\3\2\2\2\u00f8\u00f9\7<\2\2\u00f9"+
		"L\3\2\2\2\u00fa\u00fe\t\2\2\2\u00fb\u00fd\t\3\2\2\u00fc\u00fb\3\2\2\2"+
		"\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ffN\3"+
		"\2\2\2\u0100\u00fe\3\2\2\2\u0101\u010d\7\62\2\2\u0102\u0104\7/\2\2\u0103"+
		"\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0109\4\63"+
		";\2\u0106\u0108\4\62;\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010c\u0101\3\2\2\2\u010c\u0103\3\2\2\2\u010dP\3\2\2\2\u010e\u0110"+
		"\t\4\2\2\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\b)\2\2\u0114R\3\2\2\2\u0115"+
		"\u0116\13\2\2\2\u0116\u0117\b*\3\2\u0117\u0118\3\2\2\2\u0118\u0119\b*"+
		"\2\2\u0119T\3\2\2\2\b\2\u00fe\u0103\u0109\u010c\u0111\4\2\3\2\3*\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}