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
		RPAR=19, CLPAR=20, CRPAR=21, IF=22, THEN=23, ELSE=24, PRINT=25, LET=26, 
		IN=27, INT=28, BOOL=29, VOID=30, RETURN=31, CLASS=32, EXTENDS=33, NEW=34, 
		NULL=35, MAIN=36, INTEGER=37, ID=38, IDEXTENDS=39, WS=40, LINECOMENTS=41, 
		BLOCKCOMENTS=42, ERR=43;
	public static final int
		RULE_start = 0, RULE_block = 1, RULE_prog = 2, RULE_decclass = 3, RULE_let = 4, 
		RULE_vardec = 5, RULE_varasm = 6, RULE_fun = 7, RULE_dec = 8, RULE_type = 9, 
		RULE_exp = 10, RULE_term = 11, RULE_factor = 12, RULE_stm = 13, RULE_stms = 14, 
		RULE_value = 15;
	public static final String[] ruleNames = {
		"start", "block", "prog", "decclass", "let", "vardec", "varasm", "fun", 
		"dec", "type", "exp", "term", "factor", "stm", "stms", "value"
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
		"INTEGER", "ID", "IDEXTENDS", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
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
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				block();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << CLASS) | (1L << ID))) != 0) );
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

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MainDeclarationContext extends BlockContext {
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
		public MainDeclarationContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitMainDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassDeclarationContext extends BlockContext {
		public DecclassContext decclass() {
			return getRuleContext(DecclassContext.class,0);
		}
		public ClassDeclarationContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case VOID:
			case ID:
				_localctx = new MainDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				type();
				setState(38);
				match(MAIN);
				setState(39);
				match(LPAR);
				setState(40);
				match(RPAR);
				setState(41);
				match(CLPAR);
				setState(42);
				prog();
				setState(43);
				match(CRPAR);
				}
				break;
			case CLASS:
				_localctx = new ClassDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				decclass();
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LetInExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitLetInExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExpContext extends ProgContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
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
		enterRule(_localctx, 4, RULE_prog);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case PRINT:
			case RETURN:
			case NEW:
			case NULL:
			case INTEGER:
			case ID:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				exp();
				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				let();
				setState(50);
				exp();
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

	public static class DecclassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(FoolOOParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FoolOOParser.CLPAR, 0); }
		public TerminalNode CRPAR() { return getToken(FoolOOParser.CRPAR, 0); }
		public TerminalNode EXTENDS() { return getToken(FoolOOParser.EXTENDS, 0); }
		public TerminalNode IDEXTENDS() { return getToken(FoolOOParser.IDEXTENDS, 0); }
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
		enterRule(_localctx, 6, RULE_decclass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(CLASS);
			setState(55);
			match(ID);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(56);
				match(EXTENDS);
				setState(57);
				match(IDEXTENDS);
				}
			}

			setState(60);
			match(LPAR);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(61);
				vardec();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(62);
					match(COMMA);
					setState(63);
					vardec();
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(71);
			match(RPAR);
			setState(72);
			match(CLPAR);
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73);
				fun();
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(78);
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
			setState(80);
			match(LET);
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				dec();
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(86);
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
		enterRule(_localctx, 10, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			type();
			setState(89);
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
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
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
		enterRule(_localctx, 12, RULE_varasm);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new ExpDecAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				vardec();
				setState(92);
				match(ASM);
				setState(93);
				exp();
				setState(94);
				match(SEMIC);
				}
				break;
			case 2:
				_localctx = new StmDecAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				vardec();
				setState(97);
				match(ASM);
				setState(98);
				stms();
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

	public static class FunContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FoolOOParser.CLPAR, 0); }
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
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
		enterRule(_localctx, 14, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			type();
			setState(103);
			match(ID);
			setState(104);
			match(LPAR);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(105);
				vardec();
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(106);
					match(COMMA);
					setState(107);
					vardec();
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(115);
			match(RPAR);
			setState(116);
			match(CLPAR);
			setState(117);
			prog();
			setState(118);
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
		enterRule(_localctx, 16, RULE_dec);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				varasm();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
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
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
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
		enterRule(_localctx, 20, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(126);
				match(MINUS);
				}
			}

			setState(129);
			((ExpContext)_localctx).left = term();
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(130);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(131);
				((ExpContext)_localctx).right = exp();
				}
				break;
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
		enterRule(_localctx, 22, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			((TermContext)_localctx).left = factor();
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(135);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(136);
				((TermContext)_localctx).right = term();
				}
				break;
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
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> NOT() { return getTokens(FoolOOParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(FoolOOParser.NOT, i);
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
		enterRule(_localctx, 24, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(139);
				match(NOT);
				}
			}

			setState(142);
			((FactorContext)_localctx).left = value();
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(143);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << AND) | (1L << OR) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(144);
					match(NOT);
					}
				}

				setState(147);
				((FactorContext)_localctx).right = value();
				}
				break;
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
		public List<TerminalNode> ID() { return getTokens(FoolOOParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolOOParser.ID, i);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public List<TerminalNode> DOT() { return getTokens(FoolOOParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(FoolOOParser.DOT, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(FoolOOParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FoolOOParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FoolOOParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(FoolOOParser.RPAR, i);
		}
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
		public CallMethodContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitCallMethod(this);
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
	public static class StmValAsignmentContext extends StmContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode ASM() { return getToken(FoolOOParser.ASM, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public StmValAsignmentContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmValAsignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmPrintContext extends StmContext {
		public TerminalNode PRINT() { return getToken(FoolOOParser.PRINT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public StmPrintContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunExpContext extends StmContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
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
		public FunExpContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitFunExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmAsignmentContext extends StmContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode ASM() { return getToken(FoolOOParser.ASM, 0); }
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
		}
		public StmAsignmentContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmAsignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmContext stm() throws RecognitionException {
		StmContext _localctx = new StmContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stm);
		int _la;
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new StmIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(IF);
				setState(151);
				((StmIfContext)_localctx).cond = exp();
				setState(152);
				match(THEN);
				setState(153);
				match(CLPAR);
				setState(154);
				((StmIfContext)_localctx).thenBranch = stms();
				setState(155);
				match(CRPAR);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(156);
					match(ELSE);
					setState(157);
					match(CLPAR);
					setState(158);
					((StmIfContext)_localctx).elseBranch = stms();
					setState(159);
					match(CRPAR);
					}
				}

				}
				break;
			case 2:
				_localctx = new StmPrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(PRINT);
				setState(164);
				exp();
				setState(165);
				match(SEMIC);
				}
				break;
			case 3:
				_localctx = new FunExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				match(ID);
				setState(168);
				match(LPAR);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << RETURN) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(169);
					exp();
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(170);
						match(COMMA);
						setState(171);
						exp();
						}
						}
						setState(176);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(179);
				match(RPAR);
				setState(180);
				match(SEMIC);
				}
				break;
			case 4:
				_localctx = new CallMethodContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				match(ID);
				setState(196); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(182);
					match(DOT);
					setState(183);
					match(ID);
					{
					setState(184);
					match(LPAR);
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << RETURN) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(185);
						exp();
						setState(190);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(186);
							match(COMMA);
							setState(187);
							exp();
							}
							}
							setState(192);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(195);
					match(RPAR);
					}
					}
					}
					setState(198); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOT );
				setState(200);
				match(SEMIC);
				}
				break;
			case 5:
				_localctx = new StmAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				match(ID);
				setState(202);
				match(ASM);
				setState(203);
				stms();
				}
				break;
			case 6:
				_localctx = new StmValAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(204);
				match(ID);
				setState(205);
				match(ASM);
				setState(206);
				value();
				setState(207);
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
		enterRule(_localctx, 28, RULE_stms);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(212); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(211);
					stm();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(214); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
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
		public List<TerminalNode> ID() { return getTokens(FoolOOParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolOOParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(FoolOOParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolOOParser.RPAR, 0); }
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
	public static class ReturnFunContext extends ValueContext {
		public TerminalNode RETURN() { return getToken(FoolOOParser.RETURN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ReturnFunContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitReturnFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);
		int _la;
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
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
				_localctx = new ReturnFunContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				match(RETURN);
				setState(219);
				exp();
				}
				break;
			case 4:
				_localctx = new BaseExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				match(LPAR);
				setState(221);
				exp();
				setState(222);
				match(RPAR);
				}
				break;
			case 5:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(224);
				match(IF);
				setState(225);
				((IfExpContext)_localctx).cond = exp();
				setState(226);
				match(THEN);
				setState(227);
				match(CLPAR);
				setState(228);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(229);
				match(CRPAR);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(230);
					match(ELSE);
					setState(231);
					match(CLPAR);
					setState(232);
					((IfExpContext)_localctx).elseBranch = exp();
					setState(233);
					match(CRPAR);
					}
				}

				}
				break;
			case 6:
				_localctx = new StmsExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(237);
				stms();
				}
				break;
			case 7:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(238);
				match(ID);
				}
				break;
			case 8:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(239);
				match(NULL);
				}
				break;
			case 9:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(240);
				match(NEW);
				setState(241);
				match(ID);
				setState(242);
				match(LPAR);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(243);
					match(ID);
					setState(246); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(244);
						match(COMMA);
						setState(245);
						match(ID);
						}
						}
						setState(248); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==COMMA );
					}
				}

				setState(252);
				match(RPAR);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0102\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\6\2$\n"+
		"\2\r\2\16\2%\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3\4\3"+
		"\4\3\4\5\4\67\n\4\3\5\3\5\3\5\3\5\5\5=\n\5\3\5\3\5\3\5\3\5\7\5C\n\5\f"+
		"\5\16\5F\13\5\5\5H\n\5\3\5\3\5\3\5\6\5M\n\5\r\5\16\5N\3\5\3\5\3\6\3\6"+
		"\6\6U\n\6\r\6\16\6V\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\bg\n\b\3\t\3\t\3\t\3\t\3\t\3\t\7\to\n\t\f\t\16\tr\13\t\5\tt\n"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\5\n}\n\n\3\13\3\13\3\f\5\f\u0082\n\f\3"+
		"\f\3\f\3\f\5\f\u0087\n\f\3\r\3\r\3\r\5\r\u008c\n\r\3\16\5\16\u008f\n\16"+
		"\3\16\3\16\3\16\5\16\u0094\n\16\3\16\5\16\u0097\n\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a4\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00af\n\17\f\17\16\17\u00b2\13\17"+
		"\5\17\u00b4\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00bf"+
		"\n\17\f\17\16\17\u00c2\13\17\5\17\u00c4\n\17\3\17\6\17\u00c7\n\17\r\17"+
		"\16\17\u00c8\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d4\n"+
		"\17\3\20\6\20\u00d7\n\20\r\20\16\20\u00d8\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00ee\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u00f9\n"+
		"\21\r\21\16\21\u00fa\5\21\u00fd\n\21\3\21\5\21\u0100\n\21\3\21\2\2\22"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\7\4\2\36 ((\3\2\t\n\3\2\13"+
		"\f\4\2\7\7\r\20\3\2\22\23\2\u011a\2#\3\2\2\2\4\60\3\2\2\2\6\66\3\2\2\2"+
		"\b8\3\2\2\2\nR\3\2\2\2\fZ\3\2\2\2\16f\3\2\2\2\20h\3\2\2\2\22|\3\2\2\2"+
		"\24~\3\2\2\2\26\u0081\3\2\2\2\30\u0088\3\2\2\2\32\u008e\3\2\2\2\34\u00d3"+
		"\3\2\2\2\36\u00d6\3\2\2\2 \u00ff\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2$%\3\2\2"+
		"\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'(\5\24\13\2()\7&\2\2)*\7\24\2\2*+\7"+
		"\25\2\2+,\7\26\2\2,-\5\6\4\2-.\7\27\2\2.\61\3\2\2\2/\61\5\b\5\2\60\'\3"+
		"\2\2\2\60/\3\2\2\2\61\5\3\2\2\2\62\67\5\26\f\2\63\64\5\n\6\2\64\65\5\26"+
		"\f\2\65\67\3\2\2\2\66\62\3\2\2\2\66\63\3\2\2\2\67\7\3\2\2\289\7\"\2\2"+
		"9<\7(\2\2:;\7#\2\2;=\7)\2\2<:\3\2\2\2<=\3\2\2\2=>\3\2\2\2>G\7\24\2\2?"+
		"D\5\f\7\2@A\7\6\2\2AC\5\f\7\2B@\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2"+
		"EH\3\2\2\2FD\3\2\2\2G?\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\25\2\2JL\7\26\2"+
		"\2KM\5\20\t\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3\2\2\2PQ\7\27"+
		"\2\2Q\t\3\2\2\2RT\7\34\2\2SU\5\22\n\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW"+
		"\3\2\2\2WX\3\2\2\2XY\7\35\2\2Y\13\3\2\2\2Z[\5\24\13\2[\\\7(\2\2\\\r\3"+
		"\2\2\2]^\5\f\7\2^_\7\b\2\2_`\5\26\f\2`a\7\4\2\2ag\3\2\2\2bc\5\f\7\2cd"+
		"\7\b\2\2de\5\36\20\2eg\3\2\2\2f]\3\2\2\2fb\3\2\2\2g\17\3\2\2\2hi\5\24"+
		"\13\2ij\7(\2\2js\7\24\2\2kp\5\f\7\2lm\7\6\2\2mo\5\f\7\2nl\3\2\2\2or\3"+
		"\2\2\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2sk\3\2\2\2st\3\2\2\2tu\3"+
		"\2\2\2uv\7\25\2\2vw\7\26\2\2wx\5\6\4\2xy\7\27\2\2y\21\3\2\2\2z}\5\16\b"+
		"\2{}\5\20\t\2|z\3\2\2\2|{\3\2\2\2}\23\3\2\2\2~\177\t\2\2\2\177\25\3\2"+
		"\2\2\u0080\u0082\7\n\2\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0086\5\30\r\2\u0084\u0085\t\3\2\2\u0085\u0087\5"+
		"\26\f\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\27\3\2\2\2\u0088"+
		"\u008b\5\32\16\2\u0089\u008a\t\4\2\2\u008a\u008c\5\30\r\2\u008b\u0089"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\31\3\2\2\2\u008d\u008f\7\21\2\2\u008e"+
		"\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0096\5 "+
		"\21\2\u0091\u0093\t\5\2\2\u0092\u0094\7\21\2\2\u0093\u0092\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\5 \21\2\u0096\u0091\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\33\3\2\2\2\u0098\u0099\7\30\2\2\u0099\u009a"+
		"\5\26\f\2\u009a\u009b\7\31\2\2\u009b\u009c\7\26\2\2\u009c\u009d\5\36\20"+
		"\2\u009d\u00a3\7\27\2\2\u009e\u009f\7\32\2\2\u009f\u00a0\7\26\2\2\u00a0"+
		"\u00a1\5\36\20\2\u00a1\u00a2\7\27\2\2\u00a2\u00a4\3\2\2\2\u00a3\u009e"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00d4\3\2\2\2\u00a5\u00a6\7\33\2\2"+
		"\u00a6\u00a7\5\26\f\2\u00a7\u00a8\7\4\2\2\u00a8\u00d4\3\2\2\2\u00a9\u00aa"+
		"\7(\2\2\u00aa\u00b3\7\24\2\2\u00ab\u00b0\5\26\f\2\u00ac\u00ad\7\6\2\2"+
		"\u00ad\u00af\5\26\f\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00ab\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7\25"+
		"\2\2\u00b6\u00d4\7\4\2\2\u00b7\u00c6\7(\2\2\u00b8\u00b9\7\3\2\2\u00b9"+
		"\u00ba\7(\2\2\u00ba\u00c3\7\24\2\2\u00bb\u00c0\5\26\f\2\u00bc\u00bd\7"+
		"\6\2\2\u00bd\u00bf\5\26\f\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c7\7\25\2\2\u00c6\u00b8\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3"+
		"\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00d4\7\4\2\2\u00cb"+
		"\u00cc\7(\2\2\u00cc\u00cd\7\b\2\2\u00cd\u00d4\5\36\20\2\u00ce\u00cf\7"+
		"(\2\2\u00cf\u00d0\7\b\2\2\u00d0\u00d1\5 \21\2\u00d1\u00d2\7\4\2\2\u00d2"+
		"\u00d4\3\2\2\2\u00d3\u0098\3\2\2\2\u00d3\u00a5\3\2\2\2\u00d3\u00a9\3\2"+
		"\2\2\u00d3\u00b7\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d4"+
		"\35\3\2\2\2\u00d5\u00d7\5\34\17\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\37\3\2\2\2\u00da\u0100"+
		"\7\'\2\2\u00db\u0100\t\6\2\2\u00dc\u00dd\7!\2\2\u00dd\u0100\5\26\f\2\u00de"+
		"\u00df\7\24\2\2\u00df\u00e0\5\26\f\2\u00e0\u00e1\7\25\2\2\u00e1\u0100"+
		"\3\2\2\2\u00e2\u00e3\7\30\2\2\u00e3\u00e4\5\26\f\2\u00e4\u00e5\7\31\2"+
		"\2\u00e5\u00e6\7\26\2\2\u00e6\u00e7\5\26\f\2\u00e7\u00ed\7\27\2\2\u00e8"+
		"\u00e9\7\32\2\2\u00e9\u00ea\7\26\2\2\u00ea\u00eb\5\26\f\2\u00eb\u00ec"+
		"\7\27\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00e8\3\2\2\2\u00ed\u00ee\3\2\2\2"+
		"\u00ee\u0100\3\2\2\2\u00ef\u0100\5\36\20\2\u00f0\u0100\7(\2\2\u00f1\u0100"+
		"\7%\2\2\u00f2\u00f3\7$\2\2\u00f3\u00f4\7(\2\2\u00f4\u00fc\7\24\2\2\u00f5"+
		"\u00f8\7(\2\2\u00f6\u00f7\7\6\2\2\u00f7\u00f9\7(\2\2\u00f8\u00f6\3\2\2"+
		"\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd"+
		"\3\2\2\2\u00fc\u00f5\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u0100\7\25\2\2\u00ff\u00da\3\2\2\2\u00ff\u00db\3\2\2\2\u00ff\u00dc\3"+
		"\2\2\2\u00ff\u00de\3\2\2\2\u00ff\u00e2\3\2\2\2\u00ff\u00ef\3\2\2\2\u00ff"+
		"\u00f0\3\2\2\2\u00ff\u00f1\3\2\2\2\u00ff\u00f2\3\2\2\2\u0100!\3\2\2\2"+
		" %\60\66<DGNVfps|\u0081\u0086\u008b\u008e\u0093\u0096\u00a3\u00b0\u00b3"+
		"\u00c0\u00c3\u00c8\u00d3\u00d8\u00ed\u00fa\u00fc\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}