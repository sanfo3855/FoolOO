// Generated from /home/matteo/Developments/git/FoolOO/src/parser/FoolOO.g4 by ANTLR 4.7
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
		NULL=35, INTEGER=36, ID=37, WS=38, LINECOMENTS=39, BLOCKCOMENTS=40, ERR=41;
	public static final int
		RULE_start = 0, RULE_block = 1, RULE_prog = 2, RULE_decclass = 3, RULE_eextends = 4, 
		RULE_let = 5, RULE_vardec = 6, RULE_varasm = 7, RULE_fun = 8, RULE_dec = 9, 
		RULE_type = 10, RULE_exp = 11, RULE_term = 12, RULE_factor = 13, RULE_stm = 14, 
		RULE_stms = 15, RULE_value = 16;
	public static final String[] ruleNames = {
		"start", "block", "prog", "decclass", "eextends", "let", "vardec", "varasm", 
		"fun", "dec", "type", "exp", "term", "factor", "stm", "stms", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "';'", "':'", "','", "'=='", "'='", "'+'", "'-'", "'*'", 
		"'/'", "'&&'", "'||'", "'>='", "'<='", "'!'", "'true'", "'false'", "'('", 
		"')'", "'{'", "'}'", "'if'", "'then'", "'else'", "'print'", "'let'", "'in'", 
		"'int'", "'bool'", "'void'", "'return'", "'class'", "'extends'", "'new'", 
		"'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOT", "SEMIC", "COLON", "COMMA", "EQ", "ASM", "PLUS", "MINUS", 
		"TIMES", "DIV", "AND", "OR", "GTEQ", "LTEQ", "NOT", "TRUE", "FALSE", "LPAR", 
		"RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", "PRINT", "LET", "IN", 
		"INT", "BOOL", "VOID", "RETURN", "CLASS", "EXTENDS", "NEW", "NULL", "INTEGER", 
		"ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
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
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				block();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << LET) | (1L << RETURN) | (1L << CLASS) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0) );
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
	public static class ProgDeclarationContext extends BlockContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public ProgDeclarationContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitProgDeclaration(this);
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
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case PRINT:
			case LET:
			case RETURN:
			case NEW:
			case NULL:
			case INTEGER:
			case ID:
				_localctx = new ProgDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				prog();
				}
				break;
			case CLASS:
				_localctx = new ClassDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
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
			setState(47);
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
				setState(43);
				exp();
				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				let();
				setState(45);
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
		public EextendsContext eextends() {
			return getRuleContext(EextendsContext.class,0);
		}
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
			setState(49);
			match(CLASS);
			setState(50);
			match(ID);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(51);
				eextends();
				}
			}

			setState(54);
			match(LPAR);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID))) != 0)) {
				{
				setState(55);
				vardec();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(56);
					match(COMMA);
					setState(57);
					vardec();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(65);
			match(RPAR);
			setState(66);
			match(CLPAR);
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				fun();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID))) != 0) );
			setState(72);
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

	public static class EextendsContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(FoolOOParser.EXTENDS, 0); }
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public EextendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eextends; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitEextends(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EextendsContext eextends() throws RecognitionException {
		EextendsContext _localctx = new EextendsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_eextends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(EXTENDS);
			setState(75);
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
		enterRule(_localctx, 10, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(LET);
			setState(79); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				dec();
				}
				}
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID))) != 0) );
			setState(83);
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
		enterRule(_localctx, 12, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			type();
			setState(86);
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
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode ASM() { return getToken(FoolOOParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public VarasmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varasm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitVarasm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarasmContext varasm() throws RecognitionException {
		VarasmContext _localctx = new VarasmContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varasm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			vardec();
			setState(89);
			match(ASM);
			setState(90);
			exp();
			setState(91);
			match(SEMIC);
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
		enterRule(_localctx, 16, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			type();
			setState(94);
			match(ID);
			setState(95);
			match(LPAR);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID))) != 0)) {
				{
				setState(96);
				vardec();
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(97);
					match(COMMA);
					setState(98);
					vardec();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(106);
			match(RPAR);
			setState(107);
			match(CLPAR);
			setState(108);
			prog();
			setState(109);
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
		enterRule(_localctx, 18, RULE_dec);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				varasm();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
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
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID))) != 0)) ) {
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
		enterRule(_localctx, 22, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(117);
				match(MINUS);
				}
			}

			setState(120);
			((ExpContext)_localctx).left = term();
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(121);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(122);
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
		enterRule(_localctx, 24, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			((TermContext)_localctx).left = factor();
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(126);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(127);
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
		enterRule(_localctx, 26, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(130);
				match(NOT);
				}
			}

			setState(133);
			((FactorContext)_localctx).left = value();
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(134);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << AND) | (1L << OR) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(135);
					match(NOT);
					}
				}

				setState(138);
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
		public TerminalNode DOT() { return getToken(FoolOOParser.DOT, 0); }
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
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
		public CallMethodContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitCallMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmExpAsignmentContext extends StmContext {
		public TerminalNode ID() { return getToken(FoolOOParser.ID, 0); }
		public TerminalNode ASM() { return getToken(FoolOOParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
		public StmExpAsignmentContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolOOVisitor ) return ((FoolOOVisitor<? extends T>)visitor).visitStmExpAsignment(this);
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
		public TerminalNode SEMIC() { return getToken(FoolOOParser.SEMIC, 0); }
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
		enterRule(_localctx, 28, RULE_stm);
		int _la;
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new StmExpAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(ID);
				setState(142);
				match(ASM);
				setState(143);
				exp();
				setState(144);
				match(SEMIC);
				}
				break;
			case 2:
				_localctx = new StmAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(ID);
				setState(147);
				match(ASM);
				setState(148);
				stms();
				}
				break;
			case 3:
				_localctx = new StmValAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(ID);
				setState(150);
				match(ASM);
				setState(151);
				value();
				setState(152);
				match(SEMIC);
				}
				break;
			case 4:
				_localctx = new StmIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(IF);
				setState(155);
				((StmIfContext)_localctx).cond = exp();
				setState(156);
				match(THEN);
				setState(157);
				match(CLPAR);
				setState(158);
				((StmIfContext)_localctx).thenBranch = stms();
				setState(159);
				match(CRPAR);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(160);
					match(ELSE);
					setState(161);
					match(CLPAR);
					setState(162);
					((StmIfContext)_localctx).elseBranch = stms();
					setState(163);
					match(CRPAR);
					}
				}

				}
				break;
			case 5:
				_localctx = new StmPrintContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(167);
				match(PRINT);
				setState(168);
				exp();
				setState(169);
				match(SEMIC);
				}
				break;
			case 6:
				_localctx = new FunExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(171);
				match(ID);
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(172);
					match(LPAR);
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << RETURN) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(173);
						exp();
						setState(178);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(174);
							match(COMMA);
							setState(175);
							exp();
							}
							}
							setState(180);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(183);
					match(RPAR);
					}
				}

				setState(186);
				match(SEMIC);
				}
				break;
			case 7:
				_localctx = new CallMethodContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				match(ID);
				setState(188);
				match(DOT);
				setState(189);
				match(ID);
				{
				setState(190);
				match(LPAR);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << RETURN) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(191);
					exp();
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(192);
						match(COMMA);
						setState(193);
						exp();
						}
						}
						setState(198);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(201);
				match(RPAR);
				}
				setState(203);
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
		enterRule(_localctx, 30, RULE_stms);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(206);
					stm();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(209); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 32, RULE_value);
		int _la;
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
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
				setState(213);
				match(RETURN);
				setState(214);
				exp();
				}
				break;
			case 4:
				_localctx = new BaseExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				match(LPAR);
				setState(216);
				exp();
				setState(217);
				match(RPAR);
				}
				break;
			case 5:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(219);
				match(IF);
				setState(220);
				((IfExpContext)_localctx).cond = exp();
				setState(221);
				match(THEN);
				setState(222);
				match(CLPAR);
				setState(223);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(224);
				match(CRPAR);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(225);
					match(ELSE);
					setState(226);
					match(CLPAR);
					setState(227);
					((IfExpContext)_localctx).elseBranch = exp();
					setState(228);
					match(CRPAR);
					}
				}

				}
				break;
			case 6:
				_localctx = new StmsExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(232);
				stms();
				}
				break;
			case 7:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(233);
				match(ID);
				}
				break;
			case 8:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(234);
				match(NULL);
				}
				break;
			case 9:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(235);
				match(NEW);
				setState(236);
				match(ID);
				setState(237);
				match(LPAR);
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(238);
					match(ID);
					setState(241); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(239);
						match(COMMA);
						setState(240);
						match(ID);
						}
						}
						setState(243); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==COMMA );
					}
				}

				setState(247);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00fd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\5\4\62\n\4\3"+
		"\5\3\5\3\5\5\5\67\n\5\3\5\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\5\5B\n\5"+
		"\3\5\3\5\3\5\6\5G\n\5\r\5\16\5H\3\5\3\5\3\6\3\6\3\6\3\7\3\7\6\7R\n\7\r"+
		"\7\16\7S\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\7\nf\n\n\f\n\16\ni\13\n\5\nk\n\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\5\13"+
		"t\n\13\3\f\3\f\3\r\5\ry\n\r\3\r\3\r\3\r\5\r~\n\r\3\16\3\16\3\16\5\16\u0083"+
		"\n\16\3\17\5\17\u0086\n\17\3\17\3\17\3\17\5\17\u008b\n\17\3\17\5\17\u008e"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a8\n\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00b3\n\20\f\20\16"+
		"\20\u00b6\13\20\5\20\u00b8\n\20\3\20\5\20\u00bb\n\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\7\20\u00c5\n\20\f\20\16\20\u00c8\13\20\5\20\u00ca"+
		"\n\20\3\20\3\20\3\20\5\20\u00cf\n\20\3\21\6\21\u00d2\n\21\r\21\16\21\u00d3"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00e9\n\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\6\22\u00f4\n\22\r\22\16\22\u00f5\5\22\u00f8\n\22\3\22"+
		"\5\22\u00fb\n\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"\2\7\3\2\36 \3\2\t\n\3\2\13\f\4\2\7\7\r\20\3\2\22\23\2\u0114\2%\3\2\2"+
		"\2\4+\3\2\2\2\6\61\3\2\2\2\b\63\3\2\2\2\nL\3\2\2\2\fO\3\2\2\2\16W\3\2"+
		"\2\2\20Z\3\2\2\2\22_\3\2\2\2\24s\3\2\2\2\26u\3\2\2\2\30x\3\2\2\2\32\177"+
		"\3\2\2\2\34\u0085\3\2\2\2\36\u00ce\3\2\2\2 \u00d1\3\2\2\2\"\u00fa\3\2"+
		"\2\2$&\5\4\3\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)"+
		",\5\6\4\2*,\5\b\5\2+)\3\2\2\2+*\3\2\2\2,\5\3\2\2\2-\62\5\30\r\2./\5\f"+
		"\7\2/\60\5\30\r\2\60\62\3\2\2\2\61-\3\2\2\2\61.\3\2\2\2\62\7\3\2\2\2\63"+
		"\64\7\"\2\2\64\66\7\'\2\2\65\67\5\n\6\2\66\65\3\2\2\2\66\67\3\2\2\2\67"+
		"8\3\2\2\28A\7\24\2\29>\5\16\b\2:;\7\6\2\2;=\5\16\b\2<:\3\2\2\2=@\3\2\2"+
		"\2><\3\2\2\2>?\3\2\2\2?B\3\2\2\2@>\3\2\2\2A9\3\2\2\2AB\3\2\2\2BC\3\2\2"+
		"\2CD\7\25\2\2DF\7\26\2\2EG\5\22\n\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3"+
		"\2\2\2IJ\3\2\2\2JK\7\27\2\2K\t\3\2\2\2LM\7#\2\2MN\7\'\2\2N\13\3\2\2\2"+
		"OQ\7\34\2\2PR\5\24\13\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2"+
		"\2\2UV\7\35\2\2V\r\3\2\2\2WX\5\26\f\2XY\7\'\2\2Y\17\3\2\2\2Z[\5\16\b\2"+
		"[\\\7\b\2\2\\]\5\30\r\2]^\7\4\2\2^\21\3\2\2\2_`\5\26\f\2`a\7\'\2\2aj\7"+
		"\24\2\2bg\5\16\b\2cd\7\6\2\2df\5\16\b\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2jb\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\25\2"+
		"\2mn\7\26\2\2no\5\6\4\2op\7\27\2\2p\23\3\2\2\2qt\5\20\t\2rt\5\22\n\2s"+
		"q\3\2\2\2sr\3\2\2\2t\25\3\2\2\2uv\t\2\2\2v\27\3\2\2\2wy\7\n\2\2xw\3\2"+
		"\2\2xy\3\2\2\2yz\3\2\2\2z}\5\32\16\2{|\t\3\2\2|~\5\30\r\2}{\3\2\2\2}~"+
		"\3\2\2\2~\31\3\2\2\2\177\u0082\5\34\17\2\u0080\u0081\t\4\2\2\u0081\u0083"+
		"\5\32\16\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\33\3\2\2\2\u0084"+
		"\u0086\7\21\2\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3"+
		"\2\2\2\u0087\u008d\5\"\22\2\u0088\u008a\t\5\2\2\u0089\u008b\7\21\2\2\u008a"+
		"\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\5\""+
		"\22\2\u008d\u0088\3\2\2\2\u008d\u008e\3\2\2\2\u008e\35\3\2\2\2\u008f\u0090"+
		"\7\'\2\2\u0090\u0091\7\b\2\2\u0091\u0092\5\30\r\2\u0092\u0093\7\4\2\2"+
		"\u0093\u00cf\3\2\2\2\u0094\u0095\7\'\2\2\u0095\u0096\7\b\2\2\u0096\u00cf"+
		"\5 \21\2\u0097\u0098\7\'\2\2\u0098\u0099\7\b\2\2\u0099\u009a\5\"\22\2"+
		"\u009a\u009b\7\4\2\2\u009b\u00cf\3\2\2\2\u009c\u009d\7\30\2\2\u009d\u009e"+
		"\5\30\r\2\u009e\u009f\7\31\2\2\u009f\u00a0\7\26\2\2\u00a0\u00a1\5 \21"+
		"\2\u00a1\u00a7\7\27\2\2\u00a2\u00a3\7\32\2\2\u00a3\u00a4\7\26\2\2\u00a4"+
		"\u00a5\5 \21\2\u00a5\u00a6\7\27\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a2\3"+
		"\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00cf\3\2\2\2\u00a9\u00aa\7\33\2\2\u00aa"+
		"\u00ab\5\30\r\2\u00ab\u00ac\7\4\2\2\u00ac\u00cf\3\2\2\2\u00ad\u00ba\7"+
		"\'\2\2\u00ae\u00b7\7\24\2\2\u00af\u00b4\5\30\r\2\u00b0\u00b1\7\6\2\2\u00b1"+
		"\u00b3\5\30\r\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00af\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\7\25"+
		"\2\2\u00ba\u00ae\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00cf\7\4\2\2\u00bd\u00be\7\'\2\2\u00be\u00bf\7\3\2\2\u00bf\u00c0\7\'"+
		"\2\2\u00c0\u00c9\7\24\2\2\u00c1\u00c6\5\30\r\2\u00c2\u00c3\7\6\2\2\u00c3"+
		"\u00c5\5\30\r\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3"+
		"\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00c1\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\7\25"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\7\4\2\2\u00ce\u008f\3\2\2\2\u00ce"+
		"\u0094\3\2\2\2\u00ce\u0097\3\2\2\2\u00ce\u009c\3\2\2\2\u00ce\u00a9\3\2"+
		"\2\2\u00ce\u00ad\3\2\2\2\u00ce\u00bd\3\2\2\2\u00cf\37\3\2\2\2\u00d0\u00d2"+
		"\5\36\20\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2"+
		"\u00d3\u00d4\3\2\2\2\u00d4!\3\2\2\2\u00d5\u00fb\7&\2\2\u00d6\u00fb\t\6"+
		"\2\2\u00d7\u00d8\7!\2\2\u00d8\u00fb\5\30\r\2\u00d9\u00da\7\24\2\2\u00da"+
		"\u00db\5\30\r\2\u00db\u00dc\7\25\2\2\u00dc\u00fb\3\2\2\2\u00dd\u00de\7"+
		"\30\2\2\u00de\u00df\5\30\r\2\u00df\u00e0\7\31\2\2\u00e0\u00e1\7\26\2\2"+
		"\u00e1\u00e2\5\30\r\2\u00e2\u00e8\7\27\2\2\u00e3\u00e4\7\32\2\2\u00e4"+
		"\u00e5\7\26\2\2\u00e5\u00e6\5\30\r\2\u00e6\u00e7\7\27\2\2\u00e7\u00e9"+
		"\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00fb\3\2\2\2\u00ea"+
		"\u00fb\5 \21\2\u00eb\u00fb\7\'\2\2\u00ec\u00fb\7%\2\2\u00ed\u00ee\7$\2"+
		"\2\u00ee\u00ef\7\'\2\2\u00ef\u00f7\7\24\2\2\u00f0\u00f3\7\'\2\2\u00f1"+
		"\u00f2\7\6\2\2\u00f2\u00f4\7\'\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7"+
		"\u00f0\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb\7\25"+
		"\2\2\u00fa\u00d5\3\2\2\2\u00fa\u00d6\3\2\2\2\u00fa\u00d7\3\2\2\2\u00fa"+
		"\u00d9\3\2\2\2\u00fa\u00dd\3\2\2\2\u00fa\u00ea\3\2\2\2\u00fa\u00eb\3\2"+
		"\2\2\u00fa\u00ec\3\2\2\2\u00fa\u00ed\3\2\2\2\u00fb#\3\2\2\2\37\'+\61\66"+
		">AHSgjsx}\u0082\u0085\u008a\u008d\u00a7\u00b4\u00b7\u00ba\u00c6\u00c9"+
		"\u00ce\u00d3\u00e8\u00f5\u00f7\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}