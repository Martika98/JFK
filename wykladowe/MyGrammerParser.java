// Generated from MyGrammer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyGrammerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, HELLO=7, BYE=8, ASSIGN=9, 
		COMMA=10, BO=11, BC=12, SBO=13, SBC=14, INT=15, REAL=16, STRING=17, ID=18, 
		WS=19;
	public static final int
		RULE_commandx = 0, RULE_commands = 1, RULE_hello = 2, RULE_bye = 3, RULE_command = 4, 
		RULE_table = 5, RULE_table_content = 6, RULE_expr = 7, RULE_funct_value = 8, 
		RULE_value = 9, RULE_table_val = 10, RULE_numbers = 11, RULE_id_ = 12, 
		RULE_string = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"commandx", "commands", "hello", "bye", "command", "table", "table_content", 
			"expr", "funct_value", "value", "table_val", "numbers", "id_", "string"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'write'", "'read'", "'*'", "'/'", "'-'", "'+'", null, null, "'='", 
			"','", "'('", "')'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "HELLO", "BYE", "ASSIGN", "COMMA", 
			"BO", "BC", "SBO", "SBC", "INT", "REAL", "STRING", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "MyGrammer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyGrammerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CommandxContext extends ParserRuleContext {
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public CommandxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandx; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterCommandx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitCommandx(this);
		}
	}

	public final CommandxContext commandx() throws RecognitionException {
		CommandxContext _localctx = new CommandxContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_commandx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			commands();
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

	public static class CommandsContext extends ParserRuleContext {
		public HelloContext hello() {
			return getRuleContext(HelloContext.class,0);
		}
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public ByeContext bye() {
			return getRuleContext(ByeContext.class,0);
		}
		public CommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterCommands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitCommands(this);
		}
	}

	public final CommandsContext commands() throws RecognitionException {
		CommandsContext _localctx = new CommandsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_commands);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HELLO:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				hello();
				setState(31);
				commands();
				}
				break;
			case T__0:
			case T__1:
			case SBO:
			case INT:
			case REAL:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				command();
				setState(34);
				commands();
				}
				break;
			case BYE:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				bye();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 4);
				{
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

	public static class HelloContext extends ParserRuleContext {
		public HelloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hello; }
	 
		public HelloContext() { }
		public void copyFrom(HelloContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StartCommContext extends HelloContext {
		public TerminalNode HELLO() { return getToken(MyGrammerParser.HELLO, 0); }
		public StartCommContext(HelloContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterStartComm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitStartComm(this);
		}
	}

	public final HelloContext hello() throws RecognitionException {
		HelloContext _localctx = new HelloContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_hello);
		try {
			_localctx = new StartCommContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(HELLO);
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

	public static class ByeContext extends ParserRuleContext {
		public ByeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bye; }
	 
		public ByeContext() { }
		public void copyFrom(ByeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EndCommContext extends ByeContext {
		public TerminalNode BYE() { return getToken(MyGrammerParser.BYE, 0); }
		public EndCommContext(ByeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterEndComm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitEndComm(this);
		}
	}

	public final ByeContext bye() throws RecognitionException {
		ByeContext _localctx = new ByeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bye);
		try {
			_localctx = new EndCommContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(BYE);
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

	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignCommContext extends CommandContext {
		public Id_Context id_() {
			return getRuleContext(Id_Context.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MyGrammerParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignCommContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterAssignComm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitAssignComm(this);
		}
	}
	public static class ExprCommContext extends CommandContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprCommContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterExprComm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitExprComm(this);
		}
	}
	public static class FunctExprContext extends CommandContext {
		public Token function;
		public Funct_valueContext arg;
		public TerminalNode BO() { return getToken(MyGrammerParser.BO, 0); }
		public TerminalNode BC() { return getToken(MyGrammerParser.BC, 0); }
		public Funct_valueContext funct_value() {
			return getRuleContext(Funct_valueContext.class,0);
		}
		public Id_Context id_() {
			return getRuleContext(Id_Context.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MyGrammerParser.ASSIGN, 0); }
		public FunctExprContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterFunctExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitFunctExpr(this);
		}
	}
	public static class TableCommContext extends CommandContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TableCommContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterTableComm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitTableComm(this);
		}
	}
	public static class AssignTableCommContext extends CommandContext {
		public Id_Context id_() {
			return getRuleContext(Id_Context.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MyGrammerParser.ASSIGN, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public AssignTableCommContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterAssignTableComm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitAssignTableComm(this);
		}
	}
	public static class TableChangeCommContext extends CommandContext {
		public ValueContext i;
		public ExprContext val;
		public Id_Context id_() {
			return getRuleContext(Id_Context.class,0);
		}
		public TerminalNode SBO() { return getToken(MyGrammerParser.SBO, 0); }
		public TerminalNode SBC() { return getToken(MyGrammerParser.SBC, 0); }
		public TerminalNode ASSIGN() { return getToken(MyGrammerParser.ASSIGN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TableChangeCommContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterTableChangeComm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitTableChangeComm(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_command);
		int _la;
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new TableChangeCommContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				id_();
				setState(45);
				match(SBO);
				setState(46);
				((TableChangeCommContext)_localctx).i = value();
				setState(47);
				match(SBC);
				setState(48);
				match(ASSIGN);
				setState(49);
				((TableChangeCommContext)_localctx).val = expr(0);
				}
				break;
			case 2:
				_localctx = new ExprCommContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				expr(0);
				}
				break;
			case 3:
				_localctx = new FunctExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(52);
					id_();
					setState(53);
					match(ASSIGN);
					}
				}

				setState(57);
				((FunctExprContext)_localctx).function = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
					((FunctExprContext)_localctx).function = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(58);
				match(BO);
				setState(59);
				((FunctExprContext)_localctx).arg = funct_value();
				setState(60);
				match(BC);
				}
				break;
			case 4:
				_localctx = new AssignCommContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				id_();
				setState(63);
				match(ASSIGN);
				setState(64);
				expr(0);
				}
				break;
			case 5:
				_localctx = new AssignTableCommContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				id_();
				setState(67);
				match(ASSIGN);
				setState(68);
				table();
				}
				break;
			case 6:
				_localctx = new TableCommContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				table();
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

	public static class TableContext extends ParserRuleContext {
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
	 
		public TableContext() { }
		public void copyFrom(TableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TableBodyContext extends TableContext {
		public ExprContext val;
		public TerminalNode SBO() { return getToken(MyGrammerParser.SBO, 0); }
		public Table_contentContext table_content() {
			return getRuleContext(Table_contentContext.class,0);
		}
		public TerminalNode SBC() { return getToken(MyGrammerParser.SBC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TableBodyContext(TableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterTableBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitTableBody(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_table);
		try {
			_localctx = new TableBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(SBO);
			setState(74);
			((TableBodyContext)_localctx).val = expr(0);
			setState(75);
			table_content();
			setState(76);
			match(SBC);
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

	public static class Table_contentContext extends ParserRuleContext {
		public ExprContext val;
		public TerminalNode COMMA() { return getToken(MyGrammerParser.COMMA, 0); }
		public Table_contentContext table_content() {
			return getRuleContext(Table_contentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Table_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterTable_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitTable_content(this);
		}
	}

	public final Table_contentContext table_content() throws RecognitionException {
		Table_contentContext _localctx = new Table_contentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_table_content);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(COMMA);
				setState(79);
				((Table_contentContext)_localctx).val = expr(0);
				setState(80);
				table_content();
				}
				break;
			case SBC:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValExprContext extends ExprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterValExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitValExpr(this);
		}
	}
	public static class StrExprContext extends ExprContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterStrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitStrExpr(this);
		}
	}
	public static class InfixExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterInfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitInfixExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case REAL:
			case ID:
				{
				_localctx = new ValExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(86);
				value();
				}
				break;
			case STRING:
				{
				_localctx = new StrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(96);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(90);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(91);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(92);
						((InfixExprContext)_localctx).right = expr(5);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(93);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(94);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(95);
						((InfixExprContext)_localctx).right = expr(4);
						}
						break;
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Funct_valueContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Funct_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funct_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterFunct_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitFunct_value(this);
		}
	}

	public final Funct_valueContext funct_value() throws RecognitionException {
		Funct_valueContext _localctx = new Funct_valueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funct_value);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case REAL:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				expr(0);
				}
				break;
			case BC:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ValueContext extends ParserRuleContext {
		public Table_valContext table_val() {
			return getRuleContext(Table_valContext.class,0);
		}
		public Id_Context id_() {
			return getRuleContext(Id_Context.class,0);
		}
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				table_val();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				id_();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				numbers();
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

	public static class Table_valContext extends ParserRuleContext {
		public Table_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_val; }
	 
		public Table_valContext() { }
		public void copyFrom(Table_valContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TableValValContext extends Table_valContext {
		public ValueContext i;
		public Id_Context id_() {
			return getRuleContext(Id_Context.class,0);
		}
		public TerminalNode SBO() { return getToken(MyGrammerParser.SBO, 0); }
		public TerminalNode SBC() { return getToken(MyGrammerParser.SBC, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TableValValContext(Table_valContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterTableValVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitTableValVal(this);
		}
	}

	public final Table_valContext table_val() throws RecognitionException {
		Table_valContext _localctx = new Table_valContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_table_val);
		try {
			_localctx = new TableValValContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			id_();
			setState(111);
			match(SBO);
			setState(112);
			((TableValValContext)_localctx).i = value();
			setState(113);
			match(SBC);
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

	public static class NumbersContext extends ParserRuleContext {
		public NumbersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numbers; }
	 
		public NumbersContext() { }
		public void copyFrom(NumbersContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RealValContext extends NumbersContext {
		public TerminalNode REAL() { return getToken(MyGrammerParser.REAL, 0); }
		public RealValContext(NumbersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterRealVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitRealVal(this);
		}
	}
	public static class IntValContext extends NumbersContext {
		public TerminalNode INT() { return getToken(MyGrammerParser.INT, 0); }
		public IntValContext(NumbersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterIntVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitIntVal(this);
		}
	}

	public final NumbersContext numbers() throws RecognitionException {
		NumbersContext _localctx = new NumbersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_numbers);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(INT);
				}
				break;
			case REAL:
				_localctx = new RealValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(REAL);
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

	public static class Id_Context extends ParserRuleContext {
		public Id_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_; }
	 
		public Id_Context() { }
		public void copyFrom(Id_Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdValContext extends Id_Context {
		public TerminalNode ID() { return getToken(MyGrammerParser.ID, 0); }
		public IdValContext(Id_Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterIdVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitIdVal(this);
		}
	}

	public final Id_Context id_() throws RecognitionException {
		Id_Context _localctx = new Id_Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_id_);
		try {
			_localctx = new IdValContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
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

	public static class StringContext extends ParserRuleContext {
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	 
		public StringContext() { }
		public void copyFrom(StringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrValContext extends StringContext {
		public TerminalNode STRING() { return getToken(MyGrammerParser.STRING, 0); }
		public StrValContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).enterStrVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammerListener ) ((MyGrammerListener)listener).exitStrVal(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_string);
		try {
			_localctx = new StrValContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(STRING);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25~\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3)\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6:\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6J\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bV\n\b\3\t\3\t\3\t"+
		"\5\t[\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tc\n\t\f\t\16\tf\13\t\3\n\3\n\5\n"+
		"j\n\n\3\13\3\13\3\13\5\13o\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\5\rx\n\r\3"+
		"\16\3\16\3\17\3\17\3\17\2\3\20\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\2\5\3\2\3\4\3\2\5\6\3\2\7\b\2\u0080\2\36\3\2\2\2\4(\3\2\2\2\6*\3\2\2"+
		"\2\b,\3\2\2\2\nI\3\2\2\2\fK\3\2\2\2\16U\3\2\2\2\20Z\3\2\2\2\22i\3\2\2"+
		"\2\24n\3\2\2\2\26p\3\2\2\2\30w\3\2\2\2\32y\3\2\2\2\34{\3\2\2\2\36\37\5"+
		"\4\3\2\37\3\3\2\2\2 !\5\6\4\2!\"\5\4\3\2\")\3\2\2\2#$\5\n\6\2$%\5\4\3"+
		"\2%)\3\2\2\2&)\5\b\5\2\')\3\2\2\2( \3\2\2\2(#\3\2\2\2(&\3\2\2\2(\'\3\2"+
		"\2\2)\5\3\2\2\2*+\7\t\2\2+\7\3\2\2\2,-\7\n\2\2-\t\3\2\2\2./\5\32\16\2"+
		"/\60\7\17\2\2\60\61\5\24\13\2\61\62\7\20\2\2\62\63\7\13\2\2\63\64\5\20"+
		"\t\2\64J\3\2\2\2\65J\5\20\t\2\66\67\5\32\16\2\678\7\13\2\28:\3\2\2\29"+
		"\66\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\t\2\2\2<=\7\r\2\2=>\5\22\n\2>?\7\16"+
		"\2\2?J\3\2\2\2@A\5\32\16\2AB\7\13\2\2BC\5\20\t\2CJ\3\2\2\2DE\5\32\16\2"+
		"EF\7\13\2\2FG\5\f\7\2GJ\3\2\2\2HJ\5\f\7\2I.\3\2\2\2I\65\3\2\2\2I9\3\2"+
		"\2\2I@\3\2\2\2ID\3\2\2\2IH\3\2\2\2J\13\3\2\2\2KL\7\17\2\2LM\5\20\t\2M"+
		"N\5\16\b\2NO\7\20\2\2O\r\3\2\2\2PQ\7\f\2\2QR\5\20\t\2RS\5\16\b\2SV\3\2"+
		"\2\2TV\3\2\2\2UP\3\2\2\2UT\3\2\2\2V\17\3\2\2\2WX\b\t\1\2X[\5\24\13\2Y"+
		"[\5\34\17\2ZW\3\2\2\2ZY\3\2\2\2[d\3\2\2\2\\]\f\6\2\2]^\t\3\2\2^c\5\20"+
		"\t\7_`\f\5\2\2`a\t\4\2\2ac\5\20\t\6b\\\3\2\2\2b_\3\2\2\2cf\3\2\2\2db\3"+
		"\2\2\2de\3\2\2\2e\21\3\2\2\2fd\3\2\2\2gj\5\20\t\2hj\3\2\2\2ig\3\2\2\2"+
		"ih\3\2\2\2j\23\3\2\2\2ko\5\26\f\2lo\5\32\16\2mo\5\30\r\2nk\3\2\2\2nl\3"+
		"\2\2\2nm\3\2\2\2o\25\3\2\2\2pq\5\32\16\2qr\7\17\2\2rs\5\24\13\2st\7\20"+
		"\2\2t\27\3\2\2\2ux\7\21\2\2vx\7\22\2\2wu\3\2\2\2wv\3\2\2\2x\31\3\2\2\2"+
		"yz\7\24\2\2z\33\3\2\2\2{|\7\23\2\2|\35\3\2\2\2\f(9IUZbdinw";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}