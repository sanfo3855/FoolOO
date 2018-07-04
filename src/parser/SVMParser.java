// Generated from /home/andrea/IdeaProjects/compilatori/FoolOO/src/parser/SVM.g4 by ANTLR 4.7
package parser;

import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, STOREW=7, LOADW=8, BRANCH=9, 
		BRANCHEQ=10, BRANCHLESSEQ=11, BRANCHGREATEREQ=12, JS=13, LOADRA=14, STORERA=15, 
		LOADRV=16, STORERV=17, LOADFP=18, STOREFP=19, COPYFP=20, COPYFPM=21, LOADHP=22, 
		STOREHP=23, PRINT=24, PUSHTOHP=25, STOREFPO=26, LOADFPO=27, COPYFPO=28, 
		COPYFPP=29, HALT=30, COL=31, LABEL=32, NUMBER=33, WHITESP=34, ERR=35;
	public static final int
		RULE_assembly = 0;
	public static final String[] ruleNames = {
		"assembly"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'sw'", 
		"'lw'", "'b'", "'beq'", "'bleq'", "'bgeq'", "'js'", "'lra'", "'sra'", 
		"'lrv'", "'srv'", "'lfp'", "'sfp'", "'cfp'", "'cfpm'", "'lhp'", "'shp'", 
		"'print'", "'pthp'", "'sfpo'", "'lfpo'", "'cfpo'", "'cfpp'", "'halt'", 
		"':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "STOREW", "LOADW", "BRANCH", 
		"BRANCHEQ", "BRANCHLESSEQ", "BRANCHGREATEREQ", "JS", "LOADRA", "STORERA", 
		"LOADRV", "STORERV", "LOADFP", "STOREFP", "COPYFP", "COPYFPM", "LOADHP", 
		"STOREHP", "PRINT", "PUSHTOHP", "STOREFPO", "LOADFPO", "COPYFPO", "COPYFPP", 
		"HALT", "COL", "LABEL", "NUMBER", "WHITESP", "ERR"
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

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	      
	    public int[] code = new int[ExecuteVM.CODESIZE];    
	    private int i = 0;
	    private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
	    private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();
	        

	public SVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AssemblyContext extends ParserRuleContext {
		public Token n;
		public Token l;
		public List<TerminalNode> PUSH() { return getTokens(SVMParser.PUSH); }
		public TerminalNode PUSH(int i) {
			return getToken(SVMParser.PUSH, i);
		}
		public List<TerminalNode> POP() { return getTokens(SVMParser.POP); }
		public TerminalNode POP(int i) {
			return getToken(SVMParser.POP, i);
		}
		public List<TerminalNode> ADD() { return getTokens(SVMParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(SVMParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(SVMParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(SVMParser.SUB, i);
		}
		public List<TerminalNode> MULT() { return getTokens(SVMParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(SVMParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(SVMParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(SVMParser.DIV, i);
		}
		public List<TerminalNode> STOREW() { return getTokens(SVMParser.STOREW); }
		public TerminalNode STOREW(int i) {
			return getToken(SVMParser.STOREW, i);
		}
		public List<TerminalNode> LOADW() { return getTokens(SVMParser.LOADW); }
		public TerminalNode LOADW(int i) {
			return getToken(SVMParser.LOADW, i);
		}
		public List<TerminalNode> COL() { return getTokens(SVMParser.COL); }
		public TerminalNode COL(int i) {
			return getToken(SVMParser.COL, i);
		}
		public List<TerminalNode> BRANCH() { return getTokens(SVMParser.BRANCH); }
		public TerminalNode BRANCH(int i) {
			return getToken(SVMParser.BRANCH, i);
		}
		public List<TerminalNode> BRANCHEQ() { return getTokens(SVMParser.BRANCHEQ); }
		public TerminalNode BRANCHEQ(int i) {
			return getToken(SVMParser.BRANCHEQ, i);
		}
		public List<TerminalNode> BRANCHLESSEQ() { return getTokens(SVMParser.BRANCHLESSEQ); }
		public TerminalNode BRANCHLESSEQ(int i) {
			return getToken(SVMParser.BRANCHLESSEQ, i);
		}
		public List<TerminalNode> BRANCHGREATEREQ() { return getTokens(SVMParser.BRANCHGREATEREQ); }
		public TerminalNode BRANCHGREATEREQ(int i) {
			return getToken(SVMParser.BRANCHGREATEREQ, i);
		}
		public List<TerminalNode> JS() { return getTokens(SVMParser.JS); }
		public TerminalNode JS(int i) {
			return getToken(SVMParser.JS, i);
		}
		public List<TerminalNode> LOADRA() { return getTokens(SVMParser.LOADRA); }
		public TerminalNode LOADRA(int i) {
			return getToken(SVMParser.LOADRA, i);
		}
		public List<TerminalNode> STORERA() { return getTokens(SVMParser.STORERA); }
		public TerminalNode STORERA(int i) {
			return getToken(SVMParser.STORERA, i);
		}
		public List<TerminalNode> LOADRV() { return getTokens(SVMParser.LOADRV); }
		public TerminalNode LOADRV(int i) {
			return getToken(SVMParser.LOADRV, i);
		}
		public List<TerminalNode> STORERV() { return getTokens(SVMParser.STORERV); }
		public TerminalNode STORERV(int i) {
			return getToken(SVMParser.STORERV, i);
		}
		public List<TerminalNode> LOADFP() { return getTokens(SVMParser.LOADFP); }
		public TerminalNode LOADFP(int i) {
			return getToken(SVMParser.LOADFP, i);
		}
		public List<TerminalNode> STOREFP() { return getTokens(SVMParser.STOREFP); }
		public TerminalNode STOREFP(int i) {
			return getToken(SVMParser.STOREFP, i);
		}
		public List<TerminalNode> COPYFP() { return getTokens(SVMParser.COPYFP); }
		public TerminalNode COPYFP(int i) {
			return getToken(SVMParser.COPYFP, i);
		}
		public List<TerminalNode> COPYFPM() { return getTokens(SVMParser.COPYFPM); }
		public TerminalNode COPYFPM(int i) {
			return getToken(SVMParser.COPYFPM, i);
		}
		public List<TerminalNode> LOADHP() { return getTokens(SVMParser.LOADHP); }
		public TerminalNode LOADHP(int i) {
			return getToken(SVMParser.LOADHP, i);
		}
		public List<TerminalNode> STOREHP() { return getTokens(SVMParser.STOREHP); }
		public TerminalNode STOREHP(int i) {
			return getToken(SVMParser.STOREHP, i);
		}
		public List<TerminalNode> PRINT() { return getTokens(SVMParser.PRINT); }
		public TerminalNode PRINT(int i) {
			return getToken(SVMParser.PRINT, i);
		}
		public List<TerminalNode> HALT() { return getTokens(SVMParser.HALT); }
		public TerminalNode HALT(int i) {
			return getToken(SVMParser.HALT, i);
		}
		public List<TerminalNode> PUSHTOHP() { return getTokens(SVMParser.PUSHTOHP); }
		public TerminalNode PUSHTOHP(int i) {
			return getToken(SVMParser.PUSHTOHP, i);
		}
		public List<TerminalNode> LOADFPO() { return getTokens(SVMParser.LOADFPO); }
		public TerminalNode LOADFPO(int i) {
			return getToken(SVMParser.LOADFPO, i);
		}
		public List<TerminalNode> STOREFPO() { return getTokens(SVMParser.STOREFPO); }
		public TerminalNode STOREFPO(int i) {
			return getToken(SVMParser.STOREFPO, i);
		}
		public List<TerminalNode> COPYFPO() { return getTokens(SVMParser.COPYFPO); }
		public TerminalNode COPYFPO(int i) {
			return getToken(SVMParser.COPYFPO, i);
		}
		public List<TerminalNode> COPYFPP() { return getTokens(SVMParser.COPYFPP); }
		public TerminalNode COPYFPP(int i) {
			return getToken(SVMParser.COPYFPP, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SVMParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SVMParser.NUMBER, i);
		}
		public List<TerminalNode> LABEL() { return getTokens(SVMParser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(SVMParser.LABEL, i);
		}
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_assembly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSH) | (1L << POP) | (1L << ADD) | (1L << SUB) | (1L << MULT) | (1L << DIV) | (1L << STOREW) | (1L << LOADW) | (1L << BRANCH) | (1L << BRANCHEQ) | (1L << BRANCHLESSEQ) | (1L << BRANCHGREATEREQ) | (1L << JS) | (1L << LOADRA) | (1L << STORERA) | (1L << LOADRV) | (1L << STORERV) | (1L << LOADFP) | (1L << STOREFP) | (1L << COPYFP) | (1L << COPYFPM) | (1L << LOADHP) | (1L << STOREHP) | (1L << PRINT) | (1L << PUSHTOHP) | (1L << STOREFPO) | (1L << LOADFPO) | (1L << COPYFPO) | (1L << COPYFPP) | (1L << HALT) | (1L << LABEL))) != 0)) {
				{
				setState(73);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(2);
					match(PUSH);
					setState(3);
					((AssemblyContext)_localctx).n = match(NUMBER);
					code[i++] = PUSH;
								                    code[i++] = Integer.parseInt((((AssemblyContext)_localctx).n!=null?((AssemblyContext)_localctx).n.getText():null));
					}
					break;
				case 2:
					{
					setState(5);
					match(PUSH);
					setState(6);
					((AssemblyContext)_localctx).l = match(LABEL);
					code[i++] = PUSH;
					                                labelRef.put(i++,(((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
					}
					break;
				case 3:
					{
					setState(8);
					match(POP);
					code[i++] = POP;
					}
					break;
				case 4:
					{
					setState(10);
					match(ADD);
					code[i++] = ADD;
					}
					break;
				case 5:
					{
					setState(12);
					match(SUB);
					code[i++] = SUB;
					}
					break;
				case 6:
					{
					setState(14);
					match(MULT);
					code[i++] = MULT;
					}
					break;
				case 7:
					{
					setState(16);
					match(DIV);
					code[i++] = DIV;
					}
					break;
				case 8:
					{
					setState(18);
					match(STOREW);
					code[i++] = STOREW;
					}
					break;
				case 9:
					{
					setState(20);
					match(LOADW);
					code[i++] = LOADW;
					}
					break;
				case 10:
					{
					setState(22);
					((AssemblyContext)_localctx).l = match(LABEL);
					setState(23);
					match(COL);
					labelAdd.put((((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null),i);
					}
					break;
				case 11:
					{
					setState(25);
					match(BRANCH);
					setState(26);
					((AssemblyContext)_localctx).l = match(LABEL);
					code[i++] = BRANCH;
					                                labelRef.put(i++,(((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
					}
					break;
				case 12:
					{
					setState(28);
					match(BRANCHEQ);
					setState(29);
					((AssemblyContext)_localctx).l = match(LABEL);
					code[i++] = BRANCHEQ;
					                                labelRef.put(i++,(((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
					}
					break;
				case 13:
					{
					setState(31);
					match(BRANCHLESSEQ);
					setState(32);
					((AssemblyContext)_localctx).l = match(LABEL);
					code[i++] = BRANCHLESSEQ;
					                                labelRef.put(i++,(((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
					}
					break;
				case 14:
					{
					setState(34);
					match(BRANCHGREATEREQ);
					setState(35);
					((AssemblyContext)_localctx).l = match(LABEL);
					code[i++] = BRANCHGREATEREQ;
					                                        labelRef.put(i++,(((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
					}
					break;
				case 15:
					{
					setState(37);
					match(JS);
					code[i++] = JS;
					}
					break;
				case 16:
					{
					setState(39);
					match(LOADRA);
					code[i++] = LOADRA;
					}
					break;
				case 17:
					{
					setState(41);
					match(STORERA);
					code[i++] = STORERA;
					}
					break;
				case 18:
					{
					setState(43);
					match(LOADRV);
					code[i++] = LOADRV;
					}
					break;
				case 19:
					{
					setState(45);
					match(STORERV);
					code[i++] = STORERV;
					}
					break;
				case 20:
					{
					setState(47);
					match(LOADFP);
					code[i++] = LOADFP;
					}
					break;
				case 21:
					{
					setState(49);
					match(STOREFP);
					code[i++] = STOREFP;
					}
					break;
				case 22:
					{
					setState(51);
					match(COPYFP);
					code[i++] = COPYFP;
					}
					break;
				case 23:
					{
					setState(53);
					match(COPYFPM);
					code[i++] = COPYFPM;
					}
					break;
				case 24:
					{
					setState(55);
					match(LOADHP);
					code[i++] = LOADHP;
					}
					break;
				case 25:
					{
					setState(57);
					match(STOREHP);
					code[i++] = STOREHP;
					}
					break;
				case 26:
					{
					setState(59);
					match(PRINT);
					code[i++] = PRINT;
					}
					break;
				case 27:
					{
					setState(61);
					match(HALT);
					code[i++] = HALT;
					}
					break;
				case 28:
					{
					setState(63);
					match(PUSHTOHP);
					code[i++] = PUSHTOHP;
					}
					break;
				case 29:
					{
					setState(65);
					match(LOADFPO);
					code[i++] = LOADFPO;
					}
					break;
				case 30:
					{
					setState(67);
					match(STOREFPO);
					code[i++] = STOREFPO;
					}
					break;
				case 31:
					{
					setState(69);
					match(COPYFPO);
					code[i++] = COPYFPO;
					}
					break;
				case 32:
					{
					setState(71);
					match(COPYFPP);
					code[i++] = COPYFPP;
					}
					break;
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			            for (Integer refAdd: labelRef.keySet() ) {
			                      code[refAdd]=labelAdd.get(labelRef.get(refAdd));
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%S\4\2\t\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2"+
		"L\n\2\f\2\16\2O\13\2\3\2\3\2\3\2\2\2\3\2\2\2\2q\2M\3\2\2\2\4\5\7\3\2\2"+
		"\5\6\7#\2\2\6L\b\2\1\2\7\b\7\3\2\2\b\t\7\"\2\2\tL\b\2\1\2\n\13\7\4\2\2"+
		"\13L\b\2\1\2\f\r\7\5\2\2\rL\b\2\1\2\16\17\7\6\2\2\17L\b\2\1\2\20\21\7"+
		"\7\2\2\21L\b\2\1\2\22\23\7\b\2\2\23L\b\2\1\2\24\25\7\t\2\2\25L\b\2\1\2"+
		"\26\27\7\n\2\2\27L\b\2\1\2\30\31\7\"\2\2\31\32\7!\2\2\32L\b\2\1\2\33\34"+
		"\7\13\2\2\34\35\7\"\2\2\35L\b\2\1\2\36\37\7\f\2\2\37 \7\"\2\2 L\b\2\1"+
		"\2!\"\7\r\2\2\"#\7\"\2\2#L\b\2\1\2$%\7\16\2\2%&\7\"\2\2&L\b\2\1\2\'(\7"+
		"\17\2\2(L\b\2\1\2)*\7\20\2\2*L\b\2\1\2+,\7\21\2\2,L\b\2\1\2-.\7\22\2\2"+
		".L\b\2\1\2/\60\7\23\2\2\60L\b\2\1\2\61\62\7\24\2\2\62L\b\2\1\2\63\64\7"+
		"\25\2\2\64L\b\2\1\2\65\66\7\26\2\2\66L\b\2\1\2\678\7\27\2\28L\b\2\1\2"+
		"9:\7\30\2\2:L\b\2\1\2;<\7\31\2\2<L\b\2\1\2=>\7\32\2\2>L\b\2\1\2?@\7 \2"+
		"\2@L\b\2\1\2AB\7\33\2\2BL\b\2\1\2CD\7\35\2\2DL\b\2\1\2EF\7\34\2\2FL\b"+
		"\2\1\2GH\7\36\2\2HL\b\2\1\2IJ\7\37\2\2JL\b\2\1\2K\4\3\2\2\2K\7\3\2\2\2"+
		"K\n\3\2\2\2K\f\3\2\2\2K\16\3\2\2\2K\20\3\2\2\2K\22\3\2\2\2K\24\3\2\2\2"+
		"K\26\3\2\2\2K\30\3\2\2\2K\33\3\2\2\2K\36\3\2\2\2K!\3\2\2\2K$\3\2\2\2K"+
		"\'\3\2\2\2K)\3\2\2\2K+\3\2\2\2K-\3\2\2\2K/\3\2\2\2K\61\3\2\2\2K\63\3\2"+
		"\2\2K\65\3\2\2\2K\67\3\2\2\2K9\3\2\2\2K;\3\2\2\2K=\3\2\2\2K?\3\2\2\2K"+
		"A\3\2\2\2KC\3\2\2\2KE\3\2\2\2KG\3\2\2\2KI\3\2\2\2LO\3\2\2\2MK\3\2\2\2"+
		"MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\b\2\1\2Q\3\3\2\2\2\4KM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}