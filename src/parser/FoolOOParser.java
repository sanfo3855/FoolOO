// Generated from /home/andrea/IdeaProjects/compilatori/FoolOO/src/parser/FoolOO.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FoolOOParser extends Parser {
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
	public static final int
		RULE_start = 0, RULE_decclass = 1, RULE_main = 2, RULE_prog = 3, RULE_let = 4, 
		RULE_progFun = 5, RULE_letFun = 6, RULE_dec = 7, RULE_vardec = 8, RULE_varasm = 9, 
		RULE_funconstructor = 10, RULE_fun = 11, RULE_ret = 12, RULE_type = 13, 
		RULE_exp = 14, RULE_term = 15, RULE_factor = 16, RULE_factorRight = 17, 
		RULE_stm = 18, RULE_funExp = 19, RULE_stms = 20, RULE_value = 21;
	public static final String[] ruleNames = {
		"start", "decclass", "main", "prog", "let", "progFun", "letFun", "dec", 
		"vardec", "varasm", "funconstructor", "fun", "ret", "type", "exp", "term", 
		"factor", "factorRight", "stm", "funExp", "stms", "value"
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

	@Override
	public String getGrammarFileName() { return "FoolOO.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FoolOOParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<DecclassContext> decclass() {
			return getRuleContexts(DecclassContext.class);
		}
		public DecclassContext decclass(int i) {
			return getRuleContext(DecclassContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(44);
				decclass();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			main();
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

	public static class DecclassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(FoolOOParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(FoolOOParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolOOParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FoolOOParser.CLPAR, 0); }
		public TerminalNode CRPAR() { return getToken(FoolOOParser.CRPAR, 0); }
		public TerminalNode EXTENDS() { return getToken(FoolOOParser.EXTENDS, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public List<FunconstructorContext> funconstructor() {
			return getRuleContexts(FunconstructorContext.class);
		}
		public FunconstructorContext funconstructor(int i) {
			return getRuleContext(FunconstructorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolOOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolOOParser.COMMA, i);
		}
		public DecclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decclass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitDecclass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecclassContext decclass() throws RecognitionException {
		DecclassContext _localctx = new DecclassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decclass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(CLASS);
			setState(53);
			match(ID);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(54);
				match(EXTENDS);
				setState(55);
				match(ID);
				}
			}

			setState(58);
			match(LPAR);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(59);
				vardec();
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(60);
					match(COMMA);
					setState(61);
					vardec();
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(69);
			match(RPAR);
			setState(70);
			match(CLPAR);
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(73);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(71);
					fun();
					}
					break;
				case 2:
					{
					setState(72);
					funconstructor();
					}
					break;
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(77);
			match(CRPAR);
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

	public static class MainContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode MAIN() { return getToken(FoolOOParser.MAIN, 0); }
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FoolOOParser.CLPAR, 0); }
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public TerminalNode CRPAR() { return getToken(FoolOOParser.CRPAR, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			type();
			setState(80);
			match(MAIN);
			setState(81);
			match(LPAR);
			setState(82);
			match(RPAR);
			setState(83);
			match(CLPAR);
			setState(84);
			prog();
			setState(85);
			match(CRPAR);
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

	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LetInExpContext extends ProgContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
		}
		public LetInExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitLetInExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExpContext extends ProgContext {
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
		}
		public SingleExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitSingleExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_prog);
		int _la;
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CRPAR:
			case IF:
			case PRINT:
			case ID:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << ID))) != 0)) {
					{
					setState(87);
					stms();
					}
				}

				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				let();
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << ID))) != 0)) {
					{
					setState(91);
					stms();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LetContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FoolOOParser.LET, 0); }
		public TerminalNode IN() { return getToken(FoolOOParser.IN, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(LET);
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				dec();
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(102);
			match(IN);
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

	public static class ProgFunContext extends ParserRuleContext {
		public ProgFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progFun; }
	 
		public ProgFunContext() { }
		public void copyFrom(ProgFunContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LetInExpFunContext extends ProgFunContext {
		public LetFunContext letFun() {
			return getRuleContext(LetFunContext.class,0);
		}
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
		}
		public LetInExpFunContext(ProgFunContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitLetInExpFun(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExpFunContext extends ProgFunContext {
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
		}
		public SingleExpFunContext(ProgFunContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitSingleExpFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgFunContext progFun() throws RecognitionException {
		ProgFunContext _localctx = new ProgFunContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_progFun);
		int _la;
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CRPAR:
			case IF:
			case PRINT:
			case RETURN:
			case ID:
				_localctx = new SingleExpFunContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << ID))) != 0)) {
					{
					setState(104);
					stms();
					}
				}

				}
				break;
			case LET:
				_localctx = new LetInExpFunContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				letFun();
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << ID))) != 0)) {
					{
					setState(108);
					stms();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LetFunContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FoolOOParser.LET, 0); }
		public TerminalNode IN() { return getToken(FoolOOParser.IN, 0); }
		public List<VarasmContext> varasm() {
			return getRuleContexts(VarasmContext.class);
		}
		public VarasmContext varasm(int i) {
			return getRuleContext(VarasmContext.class,i);
		}
		public LetFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letFun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitLetFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetFunContext letFun() throws RecognitionException {
		LetFunContext _localctx = new LetFunContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_letFun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(LET);
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				varasm();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(119);
			match(IN);
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

	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAssignmentContext extends DecContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public VarAssignmentContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitVarAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunDeclarationContext extends DecContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FunDeclarationContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitFunDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dec);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				varasm();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				fun();
				}
				break;
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

	public static class VardecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			type();
			setState(126);
			match(ID);
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

	public static class VarasmContext extends ParserRuleContext {
		public VarasmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varasm; }
	 
		public VarasmContext() { }
		public void copyFrom(VarasmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpDecAsignmentContext extends VarasmContext {
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode ASM() { return getToken(FoolOOParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public ExpDecAsignmentContext(VarasmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitExpDecAsignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmDecAsignmentContext extends VarasmContext {
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode ASM() { return getToken(FoolOOParser.ASM, 0); }
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
		}
		public StmDecAsignmentContext(VarasmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmDecAsignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarasmContext varasm() throws RecognitionException {
		VarasmContext _localctx = new VarasmContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varasm);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new ExpDecAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				vardec();
				setState(129);
				match(ASM);
				setState(130);
				exp();
				setState(131);
				match(SEMIC);
				}
				break;
			case 2:
				_localctx = new StmDecAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				vardec();
				setState(134);
				match(ASM);
				setState(135);
				stm();
				}
				break;
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

	public static class FunconstructorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FoolOOParser.CLPAR, 0); }
		public ProgFunContext progFun() {
			return getRuleContext(ProgFunContext.class,0);
		}
		public TerminalNode CRPAR() { return getToken(FoolOOParser.CRPAR, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolOOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolOOParser.COMMA, i);
		}
		public FunconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funconstructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitFunconstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunconstructorContext funconstructor() throws RecognitionException {
		FunconstructorContext _localctx = new FunconstructorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(ID);
			setState(140);
			match(LPAR);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(141);
				vardec();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(142);
					match(COMMA);
					setState(143);
					vardec();
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(151);
			match(RPAR);
			setState(152);
			match(CLPAR);
			setState(153);
			progFun();
			setState(154);
			match(CRPAR);
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

	public static class FunContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FoolOOParser.CLPAR, 0); }
		public ProgFunContext progFun() {
			return getRuleContext(ProgFunContext.class,0);
		}
		public TerminalNode CRPAR() { return getToken(FoolOOParser.CRPAR, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolOOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolOOParser.COMMA, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			type();
			setState(157);
			match(ID);
			setState(158);
			match(LPAR);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(159);
				vardec();
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(160);
					match(COMMA);
					setState(161);
					vardec();
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(169);
			match(RPAR);
			setState(170);
			match(CLPAR);
			setState(171);
			progFun();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(172);
				ret();
				}
			}

			setState(175);
			match(CRPAR);
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

	public static class RetContext extends ParserRuleContext {
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
	 
		public RetContext() { }
		public void copyFrom(RetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnFunExpContext extends RetContext {
		public TerminalNode RETURN() { return getToken(FoolOOParser.RETURN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public ReturnFunExpContext(RetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitReturnFunExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnFunStmsContext extends RetContext {
		public TerminalNode RETURN() { return getToken(FoolOOParser.RETURN, 0); }
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
		}
		public ReturnFunStmsContext(RetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitReturnFunStms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ret);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new ReturnFunExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(RETURN);
				setState(178);
				exp();
				setState(179);
				match(SEMIC);
				}
				break;
			case 2:
				_localctx = new ReturnFunStmsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(RETURN);
				setState(182);
				stm();
				}
				break;
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FoolOOParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(FoolOOParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(FoolOOParser.VOID, 0); }
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ExpContext extends ParserRuleContext {
		public TermContext left;
		public ExpContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<TerminalNode> MINUS() { return getTokens(FoolOOParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(FoolOOParser.MINUS, i);
		}
		public TerminalNode PLUS() { return getToken(FoolOOParser.PLUS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(187);
				match(MINUS);
				}
			}

			setState(190);
			((ExpContext)_localctx).left = term();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(191);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(192);
				((ExpContext)_localctx).right = exp();
				}
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext left;
		public TermContext right;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(FoolOOParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(FoolOOParser.DIV, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			((TermContext)_localctx).left = factor();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES || _la==DIV) {
				{
				setState(196);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(197);
				((TermContext)_localctx).right = term();
				}
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

	public static class FactorContext extends ParserRuleContext {
		public ValueContext left;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FoolOOParser.NOT, 0); }
		public FactorRightContext factorRight() {
			return getRuleContext(FactorRightContext.class,0);
		}
		public TerminalNode EQ() { return getToken(FoolOOParser.EQ, 0); }
		public TerminalNode GTEQ() { return getToken(FoolOOParser.GTEQ, 0); }
		public TerminalNode LTEQ() { return getToken(FoolOOParser.LTEQ, 0); }
		public TerminalNode AND() { return getToken(FoolOOParser.AND, 0); }
		public TerminalNode OR() { return getToken(FoolOOParser.OR, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(200);
				match(NOT);
				}
			}

			setState(203);
			((FactorContext)_localctx).left = value();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << AND) | (1L << OR) | (1L << GTEQ) | (1L << LTEQ))) != 0)) {
				{
				setState(204);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << AND) | (1L << OR) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(205);
				factorRight();
				}
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

	public static class FactorRightContext extends ParserRuleContext {
		public ValueContext right;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FoolOOParser.NOT, 0); }
		public FactorRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factorRight; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitFactorRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorRightContext factorRight() throws RecognitionException {
		FactorRightContext _localctx = new FactorRightContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_factorRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(208);
				match(NOT);
				}
			}

			setState(211);
			((FactorRightContext)_localctx).right = value();
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

	public static class StmContext extends ParserRuleContext {
		public StmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm; }
	 
		public StmContext() { }
		public void copyFrom(StmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallMethodContext extends StmContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode DOT() { return getToken(FoolOOParser.DOT, 0); }
		public FunExpContext funExp() {
			return getRuleContext(FunExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public CallMethodContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitCallMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmAssignmentContext extends StmContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode ASM() { return getToken(FoolOOParser.ASM, 0); }
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
		}
		public StmAssignmentContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmIfContext extends StmContext {
		public ExpContext cond;
		public StmsContext thenBranch;
		public StmsContext elseBranch;
		public TerminalNode IF() { return getToken(FoolOOParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FoolOOParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FoolOOParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FoolOOParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FoolOOParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FoolOOParser.CRPAR, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StmsContext> stms() {
			return getRuleContexts(StmsContext.class);
		}
		public StmsContext stms(int i) {
			return getRuleContext(StmsContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(FoolOOParser.ELSE, 0); }
		public StmIfContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmPrintContext extends StmContext {
		public TerminalNode PRINT() { return getToken(FoolOOParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public StmPrintContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallFunExpContext extends StmContext {
		public FunExpContext funExp() {
			return getRuleContext(FunExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public CallFunExpContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitCallFunExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmValAssignmentContext extends StmContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode ASM() { return getToken(FoolOOParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public StmValAssignmentContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmValAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmContext stm() throws RecognitionException {
		StmContext _localctx = new StmContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stm);
		int _la;
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new StmIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(IF);
				setState(214);
				((StmIfContext)_localctx).cond = exp();
				setState(215);
				match(THEN);
				setState(216);
				match(CLPAR);
				setState(217);
				((StmIfContext)_localctx).thenBranch = stms();
				setState(218);
				match(CRPAR);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(219);
					match(ELSE);
					setState(220);
					match(CLPAR);
					setState(221);
					((StmIfContext)_localctx).elseBranch = stms();
					setState(222);
					match(CRPAR);
					}
				}

				}
				break;
			case 2:
				_localctx = new StmPrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(PRINT);
				setState(227);
				match(LPAR);
				setState(228);
				exp();
				setState(229);
				match(RPAR);
				setState(230);
				match(SEMIC);
				}
				break;
			case 3:
				_localctx = new CallFunExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				funExp();
				setState(233);
				match(SEMIC);
				}
				break;
			case 4:
				_localctx = new CallMethodContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				match(ID);
				setState(236);
				match(DOT);
				setState(237);
				funExp();
				setState(238);
				match(SEMIC);
				}
				break;
			case 5:
				_localctx = new StmAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(240);
				match(ID);
				setState(241);
				match(ASM);
				setState(242);
				stm();
				}
				break;
			case 6:
				_localctx = new StmValAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
				match(ID);
				setState(244);
				match(ASM);
				setState(245);
				exp();
				setState(246);
				match(SEMIC);
				}
				break;
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

	public static class FunExpContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolOOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolOOParser.COMMA, i);
		}
		public FunExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitFunExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunExpContext funExp() throws RecognitionException {
		FunExpContext _localctx = new FunExpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(ID);
			setState(251);
			match(LPAR);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
				{
				setState(252);
				exp();
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(253);
					match(COMMA);
					setState(254);
					exp();
					}
					}
					setState(259);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(262);
			match(RPAR);
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

	public static class StmsContext extends ParserRuleContext {
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public StmsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmsContext stms() throws RecognitionException {
		StmsContext _localctx = new StmsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(264);
				stm();
				}
				}
				setState(267); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << ID))) != 0) );
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseExpContext extends ValueContext {
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public BaseExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitBaseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public VarExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitVarExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValContext extends ValueContext {
		public TerminalNode INTEGER() { return getToken(FoolOOParser.INTEGER, 0); }
		public IntValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmsExpContext extends ValueContext {
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
		}
		public StmsExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmsExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullValContext extends ValueContext {
		public TerminalNode NULL() { return getToken(FoolOOParser.NULL, 0); }
		public NullValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitNullVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewClassContext extends ValueContext {
		public TerminalNode NEW() { return getToken(FoolOOParser.NEW, 0); }
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolOOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolOOParser.COMMA, i);
		}
		public NewClassContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitNewClass(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfExpContext extends ValueContext {
		public ExpContext cond;
		public ExpContext thenBranch;
		public ExpContext elseBranch;
		public TerminalNode IF() { return getToken(FoolOOParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FoolOOParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FoolOOParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FoolOOParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FoolOOParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FoolOOParser.CRPAR, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(FoolOOParser.ELSE, 0); }
		public IfExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitIfExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValContext extends ValueContext {
		public TerminalNode TRUE() { return getToken(FoolOOParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FoolOOParser.FALSE, 0); }
		public BoolValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitBoolVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunExpValueContext extends ValueContext {
		public FunExpContext funExp() {
			return getRuleContext(FunExpContext.class,0);
		}
		public FunExpValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitFunExpValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallMethodValueContext extends ValueContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode DOT() { return getToken(FoolOOParser.DOT, 0); }
		public FunExpContext funExp() {
			return getRuleContext(FunExpContext.class,0);
		}
		public CallMethodValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitCallMethodValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_value);
		int _la;
		try {
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new BaseExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				match(LPAR);
				setState(272);
				exp();
				setState(273);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(275);
				match(IF);
				setState(276);
				((IfExpContext)_localctx).cond = exp();
				setState(277);
				match(THEN);
				setState(278);
				match(CLPAR);
				setState(279);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(280);
				match(CRPAR);
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(281);
					match(ELSE);
					setState(282);
					match(CLPAR);
					setState(283);
					((IfExpContext)_localctx).elseBranch = exp();
					setState(284);
					match(CRPAR);
					}
				}

				}
				break;
			case 5:
				_localctx = new StmsExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(288);
				stm();
				}
				break;
			case 6:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(289);
				match(ID);
				}
				break;
			case 7:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(290);
				match(NULL);
				}
				break;
			case 8:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(291);
				match(NEW);
				setState(292);
				match(ID);
				setState(293);
				match(LPAR);
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(294);
					exp();
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(295);
						match(COMMA);
						setState(296);
						exp();
						}
						}
						setState(301);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(304);
				match(RPAR);
				}
				break;
			case 9:
				_localctx = new FunExpValueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(305);
				funExp();
				}
				break;
			case 10:
				_localctx = new CallMethodValueContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(306);
				match(ID);
				setState(307);
				match(DOT);
				setState(308);
				funExp();
				}
				break;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u013a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\7\2\60\n\2\f\2"+
		"\16\2\63\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3;\n\3\3\3\3\3\3\3\3\3\7\3A\n"+
		"\3\f\3\16\3D\13\3\5\3F\n\3\3\3\3\3\3\3\3\3\6\3L\n\3\r\3\16\3M\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\5\5[\n\5\3\5\3\5\5\5_\n\5\5\5a\n"+
		"\5\3\6\3\6\6\6e\n\6\r\6\16\6f\3\6\3\6\3\7\5\7l\n\7\3\7\3\7\5\7p\n\7\5"+
		"\7r\n\7\3\b\3\b\6\bv\n\b\r\b\16\bw\3\b\3\b\3\t\3\t\5\t~\n\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008c\n\13\3\f\3"+
		"\f\3\f\3\f\3\f\7\f\u0093\n\f\f\f\16\f\u0096\13\f\5\f\u0098\n\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00a5\n\r\f\r\16\r\u00a8\13\r"+
		"\5\r\u00aa\n\r\3\r\3\r\3\r\3\r\5\r\u00b0\n\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00ba\n\16\3\17\3\17\3\20\5\20\u00bf\n\20\3\20\3\20"+
		"\3\20\5\20\u00c4\n\20\3\21\3\21\3\21\5\21\u00c9\n\21\3\22\5\22\u00cc\n"+
		"\22\3\22\3\22\3\22\5\22\u00d1\n\22\3\23\5\23\u00d4\n\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e3\n\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00fb\n\24\3\25\3\25\3\25\3\25"+
		"\3\25\7\25\u0102\n\25\f\25\16\25\u0105\13\25\5\25\u0107\n\25\3\25\3\25"+
		"\3\26\6\26\u010c\n\26\r\26\16\26\u010d\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0121\n\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u012c\n\27\f\27\16"+
		"\27\u012f\13\27\5\27\u0131\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u0138\n"+
		"\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\7\4\2"+
		" \"**\3\2\t\n\3\2\13\f\4\2\7\7\r\20\3\2\22\23\2\u0154\2\61\3\2\2\2\4\66"+
		"\3\2\2\2\6Q\3\2\2\2\b`\3\2\2\2\nb\3\2\2\2\fq\3\2\2\2\16s\3\2\2\2\20}\3"+
		"\2\2\2\22\177\3\2\2\2\24\u008b\3\2\2\2\26\u008d\3\2\2\2\30\u009e\3\2\2"+
		"\2\32\u00b9\3\2\2\2\34\u00bb\3\2\2\2\36\u00be\3\2\2\2 \u00c5\3\2\2\2\""+
		"\u00cb\3\2\2\2$\u00d3\3\2\2\2&\u00fa\3\2\2\2(\u00fc\3\2\2\2*\u010b\3\2"+
		"\2\2,\u0137\3\2\2\2.\60\5\4\3\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61"+
		"\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\5\6\4\2\65\3\3\2\2\2\66"+
		"\67\7$\2\2\67:\7*\2\289\7%\2\29;\7*\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2"+
		"<E\7\24\2\2=B\5\22\n\2>?\7\6\2\2?A\5\22\n\2@>\3\2\2\2AD\3\2\2\2B@\3\2"+
		"\2\2BC\3\2\2\2CF\3\2\2\2DB\3\2\2\2E=\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\25"+
		"\2\2HK\7\26\2\2IL\5\30\r\2JL\5\26\f\2KI\3\2\2\2KJ\3\2\2\2LM\3\2\2\2MK"+
		"\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\27\2\2P\5\3\2\2\2QR\5\34\17\2RS\7(\2"+
		"\2ST\7\24\2\2TU\7\25\2\2UV\7\26\2\2VW\5\b\5\2WX\7\27\2\2X\7\3\2\2\2Y["+
		"\5*\26\2ZY\3\2\2\2Z[\3\2\2\2[a\3\2\2\2\\^\5\n\6\2]_\5*\26\2^]\3\2\2\2"+
		"^_\3\2\2\2_a\3\2\2\2`Z\3\2\2\2`\\\3\2\2\2a\t\3\2\2\2bd\7\36\2\2ce\5\20"+
		"\t\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\37\2\2i\13"+
		"\3\2\2\2jl\5*\26\2kj\3\2\2\2kl\3\2\2\2lr\3\2\2\2mo\5\16\b\2np\5*\26\2"+
		"on\3\2\2\2op\3\2\2\2pr\3\2\2\2qk\3\2\2\2qm\3\2\2\2r\r\3\2\2\2su\7\36\2"+
		"\2tv\5\24\13\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\37"+
		"\2\2z\17\3\2\2\2{~\5\24\13\2|~\5\30\r\2}{\3\2\2\2}|\3\2\2\2~\21\3\2\2"+
		"\2\177\u0080\5\34\17\2\u0080\u0081\7*\2\2\u0081\23\3\2\2\2\u0082\u0083"+
		"\5\22\n\2\u0083\u0084\7\b\2\2\u0084\u0085\5\36\20\2\u0085\u0086\7\4\2"+
		"\2\u0086\u008c\3\2\2\2\u0087\u0088\5\22\n\2\u0088\u0089\7\b\2\2\u0089"+
		"\u008a\5&\24\2\u008a\u008c\3\2\2\2\u008b\u0082\3\2\2\2\u008b\u0087\3\2"+
		"\2\2\u008c\25\3\2\2\2\u008d\u008e\7*\2\2\u008e\u0097\7\24\2\2\u008f\u0094"+
		"\5\22\n\2\u0090\u0091\7\6\2\2\u0091\u0093\5\22\n\2\u0092\u0090\3\2\2\2"+
		"\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0098"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u008f\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\7\25\2\2\u009a\u009b\7\26\2\2\u009b\u009c\5"+
		"\f\7\2\u009c\u009d\7\27\2\2\u009d\27\3\2\2\2\u009e\u009f\5\34\17\2\u009f"+
		"\u00a0\7*\2\2\u00a0\u00a9\7\24\2\2\u00a1\u00a6\5\22\n\2\u00a2\u00a3\7"+
		"\6\2\2\u00a3\u00a5\5\22\n\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2"+
		"\2\2\u00a9\u00a1\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ac\7\25\2\2\u00ac\u00ad\7\26\2\2\u00ad\u00af\5\f\7\2\u00ae\u00b0\5"+
		"\32\16\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b2\7\27\2\2\u00b2\31\3\2\2\2\u00b3\u00b4\7#\2\2\u00b4\u00b5\5\36\20"+
		"\2\u00b5\u00b6\7\4\2\2\u00b6\u00ba\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8\u00ba"+
		"\5&\24\2\u00b9\u00b3\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\33\3\2\2\2\u00bb"+
		"\u00bc\t\2\2\2\u00bc\35\3\2\2\2\u00bd\u00bf\7\n\2\2\u00be\u00bd\3\2\2"+
		"\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\5 \21\2\u00c1\u00c2"+
		"\t\3\2\2\u00c2\u00c4\5\36\20\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2"+
		"\u00c4\37\3\2\2\2\u00c5\u00c8\5\"\22\2\u00c6\u00c7\t\4\2\2\u00c7\u00c9"+
		"\5 \21\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9!\3\2\2\2\u00ca"+
		"\u00cc\7\21\2\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3"+
		"\2\2\2\u00cd\u00d0\5,\27\2\u00ce\u00cf\t\5\2\2\u00cf\u00d1\5$\23\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1#\3\2\2\2\u00d2\u00d4\7\21\2\2"+
		"\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6"+
		"\5,\27\2\u00d6%\3\2\2\2\u00d7\u00d8\7\32\2\2\u00d8\u00d9\5\36\20\2\u00d9"+
		"\u00da\7\33\2\2\u00da\u00db\7\26\2\2\u00db\u00dc\5*\26\2\u00dc\u00e2\7"+
		"\27\2\2\u00dd\u00de\7\34\2\2\u00de\u00df\7\26\2\2\u00df\u00e0\5*\26\2"+
		"\u00e0\u00e1\7\27\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00dd\3\2\2\2\u00e2\u00e3"+
		"\3\2\2\2\u00e3\u00fb\3\2\2\2\u00e4\u00e5\7\35\2\2\u00e5\u00e6\7\24\2\2"+
		"\u00e6\u00e7\5\36\20\2\u00e7\u00e8\7\25\2\2\u00e8\u00e9\7\4\2\2\u00e9"+
		"\u00fb\3\2\2\2\u00ea\u00eb\5(\25\2\u00eb\u00ec\7\4\2\2\u00ec\u00fb\3\2"+
		"\2\2\u00ed\u00ee\7*\2\2\u00ee\u00ef\7\3\2\2\u00ef\u00f0\5(\25\2\u00f0"+
		"\u00f1\7\4\2\2\u00f1\u00fb\3\2\2\2\u00f2\u00f3\7*\2\2\u00f3\u00f4\7\b"+
		"\2\2\u00f4\u00fb\5&\24\2\u00f5\u00f6\7*\2\2\u00f6\u00f7\7\b\2\2\u00f7"+
		"\u00f8\5\36\20\2\u00f8\u00f9\7\4\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00d7\3"+
		"\2\2\2\u00fa\u00e4\3\2\2\2\u00fa\u00ea\3\2\2\2\u00fa\u00ed\3\2\2\2\u00fa"+
		"\u00f2\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fb\'\3\2\2\2\u00fc\u00fd\7*\2\2"+
		"\u00fd\u0106\7\24\2\2\u00fe\u0103\5\36\20\2\u00ff\u0100\7\6\2\2\u0100"+
		"\u0102\5\36\20\2\u0101\u00ff\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3"+
		"\2\2\2\u0103\u0104\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0106"+
		"\u00fe\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7\25"+
		"\2\2\u0109)\3\2\2\2\u010a\u010c\5&\24\2\u010b\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e+\3\2\2\2\u010f"+
		"\u0138\7)\2\2\u0110\u0138\t\6\2\2\u0111\u0112\7\24\2\2\u0112\u0113\5\36"+
		"\20\2\u0113\u0114\7\25\2\2\u0114\u0138\3\2\2\2\u0115\u0116\7\32\2\2\u0116"+
		"\u0117\5\36\20\2\u0117\u0118\7\33\2\2\u0118\u0119\7\26\2\2\u0119\u011a"+
		"\5\36\20\2\u011a\u0120\7\27\2\2\u011b\u011c\7\34\2\2\u011c\u011d\7\26"+
		"\2\2\u011d\u011e\5\36\20\2\u011e\u011f\7\27\2\2\u011f\u0121\3\2\2\2\u0120"+
		"\u011b\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0138\3\2\2\2\u0122\u0138\5&"+
		"\24\2\u0123\u0138\7*\2\2\u0124\u0138\7\'\2\2\u0125\u0126\7&\2\2\u0126"+
		"\u0127\7*\2\2\u0127\u0130\7\24\2\2\u0128\u012d\5\36\20\2\u0129\u012a\7"+
		"\6\2\2\u012a\u012c\5\36\20\2\u012b\u0129\3\2\2\2\u012c\u012f\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u0130\u0128\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0138\7\25\2\2\u0133\u0138\5(\25\2\u0134\u0135\7*\2\2\u0135\u0136\7\3"+
		"\2\2\u0136\u0138\5(\25\2\u0137\u010f\3\2\2\2\u0137\u0110\3\2\2\2\u0137"+
		"\u0111\3\2\2\2\u0137\u0115\3\2\2\2\u0137\u0122\3\2\2\2\u0137\u0123\3\2"+
		"\2\2\u0137\u0124\3\2\2\2\u0137\u0125\3\2\2\2\u0137\u0133\3\2\2\2\u0137"+
		"\u0134\3\2\2\2\u0138-\3\2\2\2\'\61:BEKMZ^`fkoqw}\u008b\u0094\u0097\u00a6"+
		"\u00a9\u00af\u00b9\u00be\u00c3\u00c8\u00cb\u00d0\u00d3\u00e2\u00fa\u0103"+
		"\u0106\u010d\u0120\u012d\u0130\u0137";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}