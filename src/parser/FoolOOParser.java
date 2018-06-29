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
		RULE_start = 0, RULE_block = 1, RULE_prog = 2, RULE_decclass = 3, RULE_let = 4, 
		RULE_vardec = 5, RULE_varasm = 6, RULE_fun = 7, RULE_funconstructor = 8, 
		RULE_ret = 9, RULE_dec = 10, RULE_type = 11, RULE_exp = 12, RULE_term = 13, 
		RULE_factor = 14, RULE_factorRight = 15, RULE_stm = 16, RULE_funExp = 17, 
		RULE_stms = 18, RULE_value = 19;
	public static final String[] ruleNames = {
		"start", "block", "prog", "decclass", "let", "vardec", "varasm", "fun", 
		"funconstructor", "ret", "dec", "type", "exp", "term", "factor", "factorRight", 
		"stm", "funExp", "stms", "value"
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
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				block();
				}
				}
				setState(43); 
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
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case VOID:
			case ID:
				_localctx = new MainDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				type();
				setState(46);
				match(MAIN);
				setState(47);
				match(LPAR);
				setState(48);
				match(RPAR);
				setState(49);
				match(CLPAR);
				setState(50);
				prog();
				setState(51);
				match(CRPAR);
				}
				break;
			case CLASS:
				_localctx = new ClassDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
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
		enterRule(_localctx, 4, RULE_prog);
		int _la;
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CRPAR:
			case IF:
			case PRINT:
			case RETURN:
			case ID:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << ID))) != 0)) {
					{
					setState(56);
					stms();
					}
				}

				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				let();
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << ID))) != 0)) {
					{
					setState(60);
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
		enterRule(_localctx, 6, RULE_decclass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(CLASS);
			setState(66);
			match(ID);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(67);
				match(EXTENDS);
				setState(68);
				match(ID);
				}
			}

			setState(71);
			match(LPAR);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(72);
				vardec();
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(73);
					match(COMMA);
					setState(74);
					vardec();
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(82);
			match(RPAR);
			setState(83);
			match(CLPAR);
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(86);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(84);
					fun();
					}
					break;
				case 2:
					{
					setState(85);
					funconstructor();
					}
					break;
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(90);
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
			setState(92);
			match(LET);
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				dec();
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(98);
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
			setState(100);
			type();
			setState(101);
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
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new ExpDecAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				vardec();
				setState(104);
				match(ASM);
				setState(105);
				exp();
				setState(106);
				match(SEMIC);
				}
				break;
			case 2:
				_localctx = new StmDecAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				vardec();
				setState(109);
				match(ASM);
				setState(110);
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
		enterRule(_localctx, 14, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			type();
			setState(115);
			match(ID);
			setState(116);
			match(LPAR);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(117);
				vardec();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(118);
					match(COMMA);
					setState(119);
					vardec();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(127);
			match(RPAR);
			setState(128);
			match(CLPAR);
			setState(129);
			prog();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(130);
				ret();
				}
			}

			setState(133);
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

	public static class FunconstructorContext extends ParserRuleContext {
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
		enterRule(_localctx, 16, RULE_funconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(ID);
			setState(136);
			match(LPAR);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(137);
				vardec();
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(138);
					match(COMMA);
					setState(139);
					vardec();
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(147);
			match(RPAR);
			setState(148);
			match(CLPAR);
			setState(149);
			prog();
			setState(150);
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
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
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
		enterRule(_localctx, 18, RULE_ret);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new ReturnFunExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(RETURN);
				setState(153);
				exp();
				setState(154);
				match(SEMIC);
				}
				break;
			case 2:
				_localctx = new ReturnFunStmsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(RETURN);
				setState(157);
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
		enterRule(_localctx, 20, RULE_dec);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				varasm();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
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
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
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
		enterRule(_localctx, 24, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(166);
				match(MINUS);
				}
			}

			setState(169);
			((ExpContext)_localctx).left = term();
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(170);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(171);
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
		enterRule(_localctx, 26, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			((TermContext)_localctx).left = factor();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES || _la==DIV) {
				{
				setState(175);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(176);
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
		enterRule(_localctx, 28, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(179);
				match(NOT);
				}
			}

			setState(182);
			((FactorContext)_localctx).left = value();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << AND) | (1L << OR) | (1L << GTEQ) | (1L << LTEQ))) != 0)) {
				{
				setState(183);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << AND) | (1L << OR) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(184);
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
		enterRule(_localctx, 30, RULE_factorRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(187);
				match(NOT);
				}
			}

			setState(190);
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
		enterRule(_localctx, 32, RULE_stm);
		int _la;
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new StmIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(IF);
				setState(193);
				((StmIfContext)_localctx).cond = exp();
				setState(194);
				match(THEN);
				setState(195);
				match(CLPAR);
				setState(196);
				((StmIfContext)_localctx).thenBranch = stms();
				setState(197);
				match(CRPAR);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(198);
					match(ELSE);
					setState(199);
					match(CLPAR);
					setState(200);
					((StmIfContext)_localctx).elseBranch = stms();
					setState(201);
					match(CRPAR);
					}
				}

				}
				break;
			case 2:
				_localctx = new StmPrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(PRINT);
				setState(206);
				exp();
				setState(207);
				match(SEMIC);
				}
				break;
			case 3:
				_localctx = new CallFunExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				funExp();
				setState(210);
				match(SEMIC);
				}
				break;
			case 4:
				_localctx = new CallMethodContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				match(ID);
				setState(213);
				match(DOT);
				setState(214);
				funExp();
				setState(215);
				match(SEMIC);
				}
				break;
			case 5:
				_localctx = new StmAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				match(ID);
				setState(218);
				match(ASM);
				setState(219);
				stms();
				}
				break;
			case 6:
				_localctx = new StmValAsignmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
				match(ID);
				setState(221);
				match(ASM);
				setState(222);
				value();
				setState(223);
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
		enterRule(_localctx, 34, RULE_funExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(ID);
			setState(228);
			match(LPAR);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
				{
				setState(229);
				exp();
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(230);
					match(COMMA);
					setState(231);
					exp();
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(239);
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
		enterRule(_localctx, 36, RULE_stms);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(241);
					stm();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(244); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_value);
		int _la;
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
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
				setState(248);
				match(LPAR);
				setState(249);
				exp();
				setState(250);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(252);
				match(IF);
				setState(253);
				((IfExpContext)_localctx).cond = exp();
				setState(254);
				match(THEN);
				setState(255);
				match(CLPAR);
				setState(256);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(257);
				match(CRPAR);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(258);
					match(ELSE);
					setState(259);
					match(CLPAR);
					setState(260);
					((IfExpContext)_localctx).elseBranch = exp();
					setState(261);
					match(CRPAR);
					}
				}

				}
				break;
			case 5:
				_localctx = new StmsExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(265);
				stms();
				}
				break;
			case 6:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(266);
				match(ID);
				}
				break;
			case 7:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(267);
				match(NULL);
				}
				break;
			case 8:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(268);
				match(NEW);
				setState(269);
				match(ID);
				setState(270);
				match(LPAR);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(271);
					exp();
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(272);
						match(COMMA);
						setState(273);
						exp();
						}
						}
						setState(278);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(281);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u011f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\6\2,\n\2\r\2\16\2-\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\39\n\3\3\4\5\4<\n\4\3\4\3\4\5\4@\n\4\5\4B\n\4\3"+
		"\5\3\5\3\5\3\5\5\5H\n\5\3\5\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\5\5S\n"+
		"\5\3\5\3\5\3\5\3\5\6\5Y\n\5\r\5\16\5Z\3\5\3\5\3\6\3\6\6\6a\n\6\r\6\16"+
		"\6b\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bs\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\7\t{\n\t\f\t\16\t~\13\t\5\t\u0080\n\t\3\t\3\t\3"+
		"\t\3\t\5\t\u0086\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n\u008f\n\n\f\n\16"+
		"\n\u0092\13\n\5\n\u0094\n\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u00a1\n\13\3\f\3\f\5\f\u00a5\n\f\3\r\3\r\3\16\5\16\u00aa"+
		"\n\16\3\16\3\16\3\16\5\16\u00af\n\16\3\17\3\17\3\17\5\17\u00b4\n\17\3"+
		"\20\5\20\u00b7\n\20\3\20\3\20\3\20\5\20\u00bc\n\20\3\21\5\21\u00bf\n\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00ce\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00e4\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u00eb\n\23\f\23\16\23\u00ee\13\23\5\23\u00f0\n\23\3\23"+
		"\3\23\3\24\6\24\u00f5\n\24\r\24\16\24\u00f6\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u010a"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0115\n\25\f\25"+
		"\16\25\u0118\13\25\5\25\u011a\n\25\3\25\5\25\u011d\n\25\3\25\2\2\26\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\7\4\2 \"**\3\2\t\n\3\2\13"+
		"\f\4\2\7\7\r\20\3\2\22\23\2\u0136\2+\3\2\2\2\48\3\2\2\2\6A\3\2\2\2\bC"+
		"\3\2\2\2\n^\3\2\2\2\ff\3\2\2\2\16r\3\2\2\2\20t\3\2\2\2\22\u0089\3\2\2"+
		"\2\24\u00a0\3\2\2\2\26\u00a4\3\2\2\2\30\u00a6\3\2\2\2\32\u00a9\3\2\2\2"+
		"\34\u00b0\3\2\2\2\36\u00b6\3\2\2\2 \u00be\3\2\2\2\"\u00e3\3\2\2\2$\u00e5"+
		"\3\2\2\2&\u00f4\3\2\2\2(\u011c\3\2\2\2*,\5\4\3\2+*\3\2\2\2,-\3\2\2\2-"+
		"+\3\2\2\2-.\3\2\2\2.\3\3\2\2\2/\60\5\30\r\2\60\61\7(\2\2\61\62\7\24\2"+
		"\2\62\63\7\25\2\2\63\64\7\26\2\2\64\65\5\6\4\2\65\66\7\27\2\2\669\3\2"+
		"\2\2\679\5\b\5\28/\3\2\2\28\67\3\2\2\29\5\3\2\2\2:<\5&\24\2;:\3\2\2\2"+
		";<\3\2\2\2<B\3\2\2\2=?\5\n\6\2>@\5&\24\2?>\3\2\2\2?@\3\2\2\2@B\3\2\2\2"+
		"A;\3\2\2\2A=\3\2\2\2B\7\3\2\2\2CD\7$\2\2DG\7*\2\2EF\7%\2\2FH\7*\2\2GE"+
		"\3\2\2\2GH\3\2\2\2HI\3\2\2\2IR\7\24\2\2JO\5\f\7\2KL\7\6\2\2LN\5\f\7\2"+
		"MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2QO\3\2\2\2RJ\3\2\2\2"+
		"RS\3\2\2\2ST\3\2\2\2TU\7\25\2\2UX\7\26\2\2VY\5\20\t\2WY\5\22\n\2XV\3\2"+
		"\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\27\2\2]\t"+
		"\3\2\2\2^`\7\36\2\2_a\5\26\f\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2"+
		"cd\3\2\2\2de\7\37\2\2e\13\3\2\2\2fg\5\30\r\2gh\7*\2\2h\r\3\2\2\2ij\5\f"+
		"\7\2jk\7\b\2\2kl\5\32\16\2lm\7\4\2\2ms\3\2\2\2no\5\f\7\2op\7\b\2\2pq\5"+
		"&\24\2qs\3\2\2\2ri\3\2\2\2rn\3\2\2\2s\17\3\2\2\2tu\5\30\r\2uv\7*\2\2v"+
		"\177\7\24\2\2w|\5\f\7\2xy\7\6\2\2y{\5\f\7\2zx\3\2\2\2{~\3\2\2\2|z\3\2"+
		"\2\2|}\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2\177w\3\2\2\2\177\u0080\3\2\2\2"+
		"\u0080\u0081\3\2\2\2\u0081\u0082\7\25\2\2\u0082\u0083\7\26\2\2\u0083\u0085"+
		"\5\6\4\2\u0084\u0086\5\24\13\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2"+
		"\u0086\u0087\3\2\2\2\u0087\u0088\7\27\2\2\u0088\21\3\2\2\2\u0089\u008a"+
		"\7*\2\2\u008a\u0093\7\24\2\2\u008b\u0090\5\f\7\2\u008c\u008d\7\6\2\2\u008d"+
		"\u008f\5\f\7\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u008b\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\25"+
		"\2\2\u0096\u0097\7\26\2\2\u0097\u0098\5\6\4\2\u0098\u0099\7\27\2\2\u0099"+
		"\23\3\2\2\2\u009a\u009b\7#\2\2\u009b\u009c\5\32\16\2\u009c\u009d\7\4\2"+
		"\2\u009d\u00a1\3\2\2\2\u009e\u009f\7#\2\2\u009f\u00a1\5&\24\2\u00a0\u009a"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\25\3\2\2\2\u00a2\u00a5\5\16\b\2\u00a3"+
		"\u00a5\5\20\t\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\27\3\2\2"+
		"\2\u00a6\u00a7\t\2\2\2\u00a7\31\3\2\2\2\u00a8\u00aa\7\n\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\5\34\17\2"+
		"\u00ac\u00ad\t\3\2\2\u00ad\u00af\5\32\16\2\u00ae\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00b3\5\36\20\2\u00b1\u00b2\t\4\2\2\u00b2"+
		"\u00b4\5\34\17\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\35\3\2"+
		"\2\2\u00b5\u00b7\7\21\2\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00bb\5(\25\2\u00b9\u00ba\t\5\2\2\u00ba\u00bc\5 "+
		"\21\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\37\3\2\2\2\u00bd\u00bf"+
		"\7\21\2\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2"+
		"\u00c0\u00c1\5(\25\2\u00c1!\3\2\2\2\u00c2\u00c3\7\32\2\2\u00c3\u00c4\5"+
		"\32\16\2\u00c4\u00c5\7\33\2\2\u00c5\u00c6\7\26\2\2\u00c6\u00c7\5&\24\2"+
		"\u00c7\u00cd\7\27\2\2\u00c8\u00c9\7\34\2\2\u00c9\u00ca\7\26\2\2\u00ca"+
		"\u00cb\5&\24\2\u00cb\u00cc\7\27\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00c8\3"+
		"\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00e4\3\2\2\2\u00cf\u00d0\7\35\2\2\u00d0"+
		"\u00d1\5\32\16\2\u00d1\u00d2\7\4\2\2\u00d2\u00e4\3\2\2\2\u00d3\u00d4\5"+
		"$\23\2\u00d4\u00d5\7\4\2\2\u00d5\u00e4\3\2\2\2\u00d6\u00d7\7*\2\2\u00d7"+
		"\u00d8\7\3\2\2\u00d8\u00d9\5$\23\2\u00d9\u00da\7\4\2\2\u00da\u00e4\3\2"+
		"\2\2\u00db\u00dc\7*\2\2\u00dc\u00dd\7\b\2\2\u00dd\u00e4\5&\24\2\u00de"+
		"\u00df\7*\2\2\u00df\u00e0\7\b\2\2\u00e0\u00e1\5(\25\2\u00e1\u00e2\7\4"+
		"\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00c2\3\2\2\2\u00e3\u00cf\3\2\2\2\u00e3"+
		"\u00d3\3\2\2\2\u00e3\u00d6\3\2\2\2\u00e3\u00db\3\2\2\2\u00e3\u00de\3\2"+
		"\2\2\u00e4#\3\2\2\2\u00e5\u00e6\7*\2\2\u00e6\u00ef\7\24\2\2\u00e7\u00ec"+
		"\5\32\16\2\u00e8\u00e9\7\6\2\2\u00e9\u00eb\5\32\16\2\u00ea\u00e8\3\2\2"+
		"\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f0"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f2\7\25\2\2\u00f2%\3\2\2\2\u00f3\u00f5\5\"\22"+
		"\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7"+
		"\3\2\2\2\u00f7\'\3\2\2\2\u00f8\u011d\7)\2\2\u00f9\u011d\t\6\2\2\u00fa"+
		"\u00fb\7\24\2\2\u00fb\u00fc\5\32\16\2\u00fc\u00fd\7\25\2\2\u00fd\u011d"+
		"\3\2\2\2\u00fe\u00ff\7\32\2\2\u00ff\u0100\5\32\16\2\u0100\u0101\7\33\2"+
		"\2\u0101\u0102\7\26\2\2\u0102\u0103\5\32\16\2\u0103\u0109\7\27\2\2\u0104"+
		"\u0105\7\34\2\2\u0105\u0106\7\26\2\2\u0106\u0107\5\32\16\2\u0107\u0108"+
		"\7\27\2\2\u0108\u010a\3\2\2\2\u0109\u0104\3\2\2\2\u0109\u010a\3\2\2\2"+
		"\u010a\u011d\3\2\2\2\u010b\u011d\5&\24\2\u010c\u011d\7*\2\2\u010d\u011d"+
		"\7\'\2\2\u010e\u010f\7&\2\2\u010f\u0110\7*\2\2\u0110\u0119\7\24\2\2\u0111"+
		"\u0116\5\32\16\2\u0112\u0113\7\6\2\2\u0113\u0115\5\32\16\2\u0114\u0112"+
		"\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u0111\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u011b\3\2\2\2\u011b\u011d\7\25\2\2\u011c\u00f8\3\2\2\2\u011c"+
		"\u00f9\3\2\2\2\u011c\u00fa\3\2\2\2\u011c\u00fe\3\2\2\2\u011c\u010b\3\2"+
		"\2\2\u011c\u010c\3\2\2\2\u011c\u010d\3\2\2\2\u011c\u010e\3\2\2\2\u011d"+
		")\3\2\2\2$-8;?AGORXZbr|\177\u0085\u0090\u0093\u00a0\u00a4\u00a9\u00ae"+
		"\u00b3\u00b6\u00bb\u00be\u00cd\u00e3\u00ec\u00ef\u00f6\u0109\u0116\u0119"+
		"\u011c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}