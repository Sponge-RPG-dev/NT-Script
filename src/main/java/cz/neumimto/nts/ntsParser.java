// Generated from nts.g4 by ANTLR 4.9.2
package cz.neumimto.nts;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ntsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LITERAL=4, WS=5, SL_COMMENT=6, ASSIGN=7, CRLF=8, 
		RETURN=9, TRUE=10, FALSE=11, PLUS=12, MINUS=13, MUL=14, DIV=15, MOD=16, 
		EXP=17, EQUAL=18, NOT_EQUAL=19, LESS_EQUAL=20, GREATER_EQUAL=21, GREATER=22, 
		LESS=23, IF=24, ELSE=25, END=26, FOREACH=27, IN=28, FUNCTION=29, IDENTIFIER=30, 
		VARIABLE_IDENTIFIER=31, INT=32, DOT=33, PT=34;
	public static final int
		RULE_script = 0, RULE_statement_list = 1, RULE_statement = 2, RULE_condition_expression = 3, 
		RULE_type_comparison = 4, RULE_comparable_expr = 5, RULE_variable_reference = 6, 
		RULE_assignment_statement = 7, RULE_return_statement = 8, RULE_lambda = 9, 
		RULE_assignment_values = 10, RULE_rval = 11, RULE_iterable = 12, RULE_type_enum = 13, 
		RULE_function_call = 14, RULE_if_statement = 15, RULE_foreach_statement = 16, 
		RULE_argument = 17, RULE_newline = 18, RULE_type_literal = 19, RULE_type_double = 20, 
		RULE_type_bool = 21, RULE_terminator = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "statement_list", "statement", "condition_expression", "type_comparison", 
			"comparable_expr", "variable_reference", "assignment_statement", "return_statement", 
			"lambda", "assignment_values", "rval", "iterable", "type_enum", "function_call", 
			"if_statement", "foreach_statement", "argument", "newline", "type_literal", 
			"type_double", "type_bool", "terminator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "','", "'}'", null, null, null, "'='", null, null, null, 
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", "'!='", null, 
			null, "'>'", "'<'", null, null, null, null, null, null, null, null, null, 
			"'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "LITERAL", "WS", "SL_COMMENT", "ASSIGN", "CRLF", 
			"RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", "EXP", 
			"EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", "GREATER", "LESS", 
			"IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", "IDENTIFIER", "VARIABLE_IDENTIFIER", 
			"INT", "DOT", "PT"
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
	public String getGrammarFileName() { return "nts.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ntsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ScriptContext extends ParserRuleContext {
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ntsParser.EOF, 0); }
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitScript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			statement_list(0);
			setState(47);
			match(EOF);
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

	public static class Statement_listContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminatorContext terminator() {
			return getRuleContext(TerminatorContext.class,0);
		}
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public Statement_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterStatement_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitStatement_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitStatement_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_listContext statement_list() throws RecognitionException {
		return statement_list(0);
	}

	private Statement_listContext statement_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Statement_listContext _localctx = new Statement_listContext(_ctx, _parentState);
		Statement_listContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_statement_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case IF:
			case FOREACH:
			case IDENTIFIER:
			case VARIABLE_IDENTIFIER:
				{
				setState(50);
				statement();
				setState(51);
				terminator(0);
				}
				break;
			case CRLF:
				{
				setState(53);
				terminator(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Statement_listContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_statement_list);
					setState(56);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(57);
					statement();
					setState(58);
					terminator(0);
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Foreach_statementContext foreach_statement() {
			return getRuleContext(Foreach_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				assignment_statement();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				function_call();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				return_statement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				if_statement();
				}
				break;
			case FOREACH:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				foreach_statement();
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

	public static class Condition_expressionContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Type_boolContext type_bool() {
			return getRuleContext(Type_boolContext.class,0);
		}
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public Type_comparisonContext type_comparison() {
			return getRuleContext(Type_comparisonContext.class,0);
		}
		public Condition_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterCondition_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitCondition_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitCondition_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_expressionContext condition_expression() throws RecognitionException {
		Condition_expressionContext _localctx = new Condition_expressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_condition_expression);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				type_bool();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				variable_reference();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				type_comparison();
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

	public static class Type_comparisonContext extends ParserRuleContext {
		public Comparable_exprContext left;
		public Token op;
		public Comparable_exprContext right;
		public List<Comparable_exprContext> comparable_expr() {
			return getRuleContexts(Comparable_exprContext.class);
		}
		public Comparable_exprContext comparable_expr(int i) {
			return getRuleContext(Comparable_exprContext.class,i);
		}
		public TerminalNode LESS() { return getToken(ntsParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(ntsParser.GREATER, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(ntsParser.LESS_EQUAL, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(ntsParser.GREATER_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(ntsParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(ntsParser.NOT_EQUAL, 0); }
		public Type_comparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterType_comparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitType_comparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitType_comparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_comparisonContext type_comparison() throws RecognitionException {
		Type_comparisonContext _localctx = new Type_comparisonContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type_comparison);
		int _la;
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				((Type_comparisonContext)_localctx).left = comparable_expr();
				setState(79);
				((Type_comparisonContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS_EQUAL) | (1L << GREATER_EQUAL) | (1L << GREATER) | (1L << LESS))) != 0)) ) {
					((Type_comparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(80);
				((Type_comparisonContext)_localctx).right = comparable_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((Type_comparisonContext)_localctx).left = comparable_expr();
				setState(83);
				((Type_comparisonContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
					((Type_comparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(84);
				((Type_comparisonContext)_localctx).right = comparable_expr();
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

	public static class Comparable_exprContext extends ParserRuleContext {
		public Type_boolContext type_bool() {
			return getRuleContext(Type_boolContext.class,0);
		}
		public Type_doubleContext type_double() {
			return getRuleContext(Type_doubleContext.class,0);
		}
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Comparable_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparable_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterComparable_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitComparable_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitComparable_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparable_exprContext comparable_expr() throws RecognitionException {
		Comparable_exprContext _localctx = new Comparable_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comparable_expr);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				type_bool();
				}
				break;
			case INT:
			case PT:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				type_double();
				}
				break;
			case VARIABLE_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				variable_reference();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				function_call();
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

	public static class Variable_referenceContext extends ParserRuleContext {
		public Token variable;
		public TerminalNode VARIABLE_IDENTIFIER() { return getToken(ntsParser.VARIABLE_IDENTIFIER, 0); }
		public Variable_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterVariable_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitVariable_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitVariable_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_referenceContext variable_reference() throws RecognitionException {
		Variable_referenceContext _localctx = new Variable_referenceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			((Variable_referenceContext)_localctx).variable = match(VARIABLE_IDENTIFIER);
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

	public static class Assignment_statementContext extends ParserRuleContext {
		public Token name;
		public Assignment_valuesContext value;
		public TerminalNode ASSIGN() { return getToken(ntsParser.ASSIGN, 0); }
		public TerminalNode VARIABLE_IDENTIFIER() { return getToken(ntsParser.VARIABLE_IDENTIFIER, 0); }
		public Assignment_valuesContext assignment_values() {
			return getRuleContext(Assignment_valuesContext.class,0);
		}
		public Assignment_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterAssignment_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitAssignment_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitAssignment_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_statementContext assignment_statement() throws RecognitionException {
		Assignment_statementContext _localctx = new Assignment_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((Assignment_statementContext)_localctx).name = match(VARIABLE_IDENTIFIER);
			setState(97);
			match(ASSIGN);
			setState(98);
			((Assignment_statementContext)_localctx).value = assignment_values();
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

	public static class Return_statementContext extends ParserRuleContext {
		public RvalContext value;
		public TerminalNode RETURN() { return getToken(ntsParser.RETURN, 0); }
		public RvalContext rval() {
			return getRuleContext(RvalContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitReturn_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_return_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(RETURN);
			setState(101);
			((Return_statementContext)_localctx).value = rval();
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

	public static class LambdaContext extends ParserRuleContext {
		public Variable_referenceContext vars;
		public TerminalNode FUNCTION() { return getToken(ntsParser.FUNCTION, 0); }
		public TerminatorContext terminator() {
			return getRuleContext(TerminatorContext.class,0);
		}
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode END() { return getToken(ntsParser.END, 0); }
		public List<Variable_referenceContext> variable_reference() {
			return getRuleContexts(Variable_referenceContext.class);
		}
		public Variable_referenceContext variable_reference(int i) {
			return getRuleContext(Variable_referenceContext.class,i);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitLambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(FUNCTION);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VARIABLE_IDENTIFIER) {
				{
				{
				setState(104);
				((LambdaContext)_localctx).vars = variable_reference();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			terminator(0);
			setState(111);
			statement_list(0);
			setState(112);
			match(END);
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

	public static class Assignment_valuesContext extends ParserRuleContext {
		public RvalContext rval() {
			return getRuleContext(RvalContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public Assignment_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterAssignment_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitAssignment_values(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitAssignment_values(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_valuesContext assignment_values() throws RecognitionException {
		Assignment_valuesContext _localctx = new Assignment_valuesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment_values);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LITERAL:
			case TRUE:
			case FALSE:
			case IDENTIFIER:
			case VARIABLE_IDENTIFIER:
			case INT:
			case PT:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				rval();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				lambda();
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

	public static class RvalContext extends ParserRuleContext {
		public Type_literalContext type_literal() {
			return getRuleContext(Type_literalContext.class,0);
		}
		public Type_doubleContext type_double() {
			return getRuleContext(Type_doubleContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Type_enumContext type_enum() {
			return getRuleContext(Type_enumContext.class,0);
		}
		public Type_boolContext type_bool() {
			return getRuleContext(Type_boolContext.class,0);
		}
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public Type_comparisonContext type_comparison() {
			return getRuleContext(Type_comparisonContext.class,0);
		}
		public RvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterRval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitRval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitRval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RvalContext rval() throws RecognitionException {
		RvalContext _localctx = new RvalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rval);
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				type_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				type_double();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				function_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				type_enum();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				type_bool();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(123);
				variable_reference();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(124);
				type_comparison();
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

	public static class IterableContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public IterableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterIterable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitIterable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitIterable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterableContext iterable() throws RecognitionException {
		IterableContext _localctx = new IterableContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_iterable);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CRLF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				function_call();
				}
				break;
			case VARIABLE_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				variable_reference();
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

	public static class Type_enumContext extends ParserRuleContext {
		public Token type;
		public Token value;
		public TerminalNode DOT() { return getToken(ntsParser.DOT, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(ntsParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ntsParser.IDENTIFIER, i);
		}
		public Type_enumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_enum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterType_enum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitType_enum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitType_enum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_enumContext type_enum() throws RecognitionException {
		Type_enumContext _localctx = new Type_enumContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_type_enum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			((Type_enumContext)_localctx).type = match(IDENTIFIER);
			setState(133);
			match(DOT);
			setState(134);
			((Type_enumContext)_localctx).value = match(IDENTIFIER);
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

	public static class Function_callContext extends ParserRuleContext {
		public Token function_name;
		public Token arguments;
		public TerminalNode IDENTIFIER() { return getToken(ntsParser.IDENTIFIER, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			((Function_callContext)_localctx).function_name = match(IDENTIFIER);
			setState(137);
			((Function_callContext)_localctx).arguments = match(T__0);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(138);
				argument();
				}
			}

			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(141);
				match(T__1);
				setState(142);
				argument();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			match(T__2);
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

	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ntsParser.IF, 0); }
		public Condition_expressionContext condition_expression() {
			return getRuleContext(Condition_expressionContext.class,0);
		}
		public TerminatorContext terminator() {
			return getRuleContext(TerminatorContext.class,0);
		}
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode END() { return getToken(ntsParser.END, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(IF);
			setState(151);
			condition_expression();
			setState(152);
			terminator(0);
			setState(153);
			statement_list(0);
			setState(154);
			match(END);
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

	public static class Foreach_statementContext extends ParserRuleContext {
		public Variable_referenceContext variable;
		public IterableContext collection;
		public TerminalNode FOREACH() { return getToken(ntsParser.FOREACH, 0); }
		public TerminalNode IN() { return getToken(ntsParser.IN, 0); }
		public TerminatorContext terminator() {
			return getRuleContext(TerminatorContext.class,0);
		}
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode END() { return getToken(ntsParser.END, 0); }
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public IterableContext iterable() {
			return getRuleContext(IterableContext.class,0);
		}
		public Foreach_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterForeach_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitForeach_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitForeach_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreach_statementContext foreach_statement() throws RecognitionException {
		Foreach_statementContext _localctx = new Foreach_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_foreach_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(FOREACH);
			setState(157);
			((Foreach_statementContext)_localctx).variable = variable_reference();
			setState(158);
			match(IN);
			setState(159);
			((Foreach_statementContext)_localctx).collection = iterable();
			setState(160);
			terminator(0);
			setState(161);
			statement_list(0);
			setState(162);
			match(END);
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

	public static class ArgumentContext extends ParserRuleContext {
		public Token name;
		public RvalContext value;
		public TerminalNode ASSIGN() { return getToken(ntsParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ntsParser.IDENTIFIER, 0); }
		public RvalContext rval() {
			return getRuleContext(RvalContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			((ArgumentContext)_localctx).name = match(IDENTIFIER);
			setState(165);
			match(ASSIGN);
			setState(166);
			((ArgumentContext)_localctx).value = rval();
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

	public static class NewlineContext extends ParserRuleContext {
		public TerminalNode CRLF() { return getToken(ntsParser.CRLF, 0); }
		public NewlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitNewline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitNewline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewlineContext newline() throws RecognitionException {
		NewlineContext _localctx = new NewlineContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_newline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(CRLF);
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

	public static class Type_literalContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(ntsParser.LITERAL, 0); }
		public Type_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterType_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitType_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitType_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_literalContext type_literal() throws RecognitionException {
		Type_literalContext _localctx = new Type_literalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(LITERAL);
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

	public static class Type_doubleContext extends ParserRuleContext {
		public TerminalNode PT() { return getToken(ntsParser.PT, 0); }
		public List<TerminalNode> INT() { return getTokens(ntsParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ntsParser.INT, i);
		}
		public Type_doubleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_double; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterType_double(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitType_double(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitType_double(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_doubleContext type_double() throws RecognitionException {
		Type_doubleContext _localctx = new Type_doubleContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_type_double);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(172);
					match(INT);
					}
					}
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(177);
				match(PT);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178);
					match(INT);
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(PT);
				setState(185); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(184);
					match(INT);
					}
					}
					setState(187); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(189);
					match(INT);
					}
					}
					setState(192); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
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

	public static class Type_boolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ntsParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ntsParser.FALSE, 0); }
		public Type_boolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterType_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitType_bool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitType_bool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_boolContext type_bool() throws RecognitionException {
		Type_boolContext _localctx = new Type_boolContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_type_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
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

	public static class TerminatorContext extends ParserRuleContext {
		public NewlineContext newline() {
			return getRuleContext(NewlineContext.class,0);
		}
		public TerminatorContext terminator() {
			return getRuleContext(TerminatorContext.class,0);
		}
		public TerminatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterTerminator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitTerminator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitTerminator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminatorContext terminator() throws RecognitionException {
		return terminator(0);
	}

	private TerminatorContext terminator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TerminatorContext _localctx = new TerminatorContext(_ctx, _parentState);
		TerminatorContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_terminator, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(199);
			newline();
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TerminatorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_terminator);
					setState(201);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(202);
					newline();
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return statement_list_sempred((Statement_listContext)_localctx, predIndex);
		case 22:
			return terminator_sempred((TerminatorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statement_list_sempred(Statement_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean terminator_sempred(TerminatorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00d3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B\13"+
		"\3\3\4\3\4\3\4\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\5\5O\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\5\6Y\n\6\3\7\3\7\3\7\3\7\5\7_\n\7\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\13\3\13\7\13l\n\13\f\13\16\13o\13\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\5\fw\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0080\n\r\3"+
		"\16\3\16\3\16\5\16\u0085\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20"+
		"\u008e\n\20\3\20\3\20\7\20\u0092\n\20\f\20\16\20\u0095\13\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\6\26\u00b0\n\26\r\26\16"+
		"\26\u00b1\3\26\3\26\6\26\u00b6\n\26\r\26\16\26\u00b7\3\26\3\26\6\26\u00bc"+
		"\n\26\r\26\16\26\u00bd\3\26\6\26\u00c1\n\26\r\26\16\26\u00c2\5\26\u00c5"+
		"\n\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\7\30\u00ce\n\30\f\30\16\30\u00d1"+
		"\13\30\3\30\2\4\4.\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\2\5\3\2\26\31\3\2\24\25\3\2\f\r\2\u00db\2\60\3\2\2\2\48\3\2\2\2\6H\3"+
		"\2\2\2\bN\3\2\2\2\nX\3\2\2\2\f^\3\2\2\2\16`\3\2\2\2\20b\3\2\2\2\22f\3"+
		"\2\2\2\24i\3\2\2\2\26v\3\2\2\2\30\177\3\2\2\2\32\u0084\3\2\2\2\34\u0086"+
		"\3\2\2\2\36\u008a\3\2\2\2 \u0098\3\2\2\2\"\u009e\3\2\2\2$\u00a6\3\2\2"+
		"\2&\u00aa\3\2\2\2(\u00ac\3\2\2\2*\u00c4\3\2\2\2,\u00c6\3\2\2\2.\u00c8"+
		"\3\2\2\2\60\61\5\4\3\2\61\62\7\2\2\3\62\3\3\2\2\2\63\64\b\3\1\2\64\65"+
		"\5\6\4\2\65\66\5.\30\2\669\3\2\2\2\679\5.\30\28\63\3\2\2\28\67\3\2\2\2"+
		"9@\3\2\2\2:;\f\4\2\2;<\5\6\4\2<=\5.\30\2=?\3\2\2\2>:\3\2\2\2?B\3\2\2\2"+
		"@>\3\2\2\2@A\3\2\2\2A\5\3\2\2\2B@\3\2\2\2CI\5\20\t\2DI\5\36\20\2EI\5\22"+
		"\n\2FI\5 \21\2GI\5\"\22\2HC\3\2\2\2HD\3\2\2\2HE\3\2\2\2HF\3\2\2\2HG\3"+
		"\2\2\2I\7\3\2\2\2JO\5\36\20\2KO\5,\27\2LO\5\16\b\2MO\5\n\6\2NJ\3\2\2\2"+
		"NK\3\2\2\2NL\3\2\2\2NM\3\2\2\2O\t\3\2\2\2PQ\5\f\7\2QR\t\2\2\2RS\5\f\7"+
		"\2SY\3\2\2\2TU\5\f\7\2UV\t\3\2\2VW\5\f\7\2WY\3\2\2\2XP\3\2\2\2XT\3\2\2"+
		"\2Y\13\3\2\2\2Z_\5,\27\2[_\5*\26\2\\_\5\16\b\2]_\5\36\20\2^Z\3\2\2\2^"+
		"[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\r\3\2\2\2`a\7!\2\2a\17\3\2\2\2bc\7!\2"+
		"\2cd\7\t\2\2de\5\26\f\2e\21\3\2\2\2fg\7\13\2\2gh\5\30\r\2h\23\3\2\2\2"+
		"im\7\37\2\2jl\5\16\b\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2"+
		"\2om\3\2\2\2pq\5.\30\2qr\5\4\3\2rs\7\34\2\2s\25\3\2\2\2tw\5\30\r\2uw\5"+
		"\24\13\2vt\3\2\2\2vu\3\2\2\2w\27\3\2\2\2x\u0080\5(\25\2y\u0080\5*\26\2"+
		"z\u0080\5\36\20\2{\u0080\5\34\17\2|\u0080\5,\27\2}\u0080\5\16\b\2~\u0080"+
		"\5\n\6\2\177x\3\2\2\2\177y\3\2\2\2\177z\3\2\2\2\177{\3\2\2\2\177|\3\2"+
		"\2\2\177}\3\2\2\2\177~\3\2\2\2\u0080\31\3\2\2\2\u0081\u0085\3\2\2\2\u0082"+
		"\u0085\5\36\20\2\u0083\u0085\5\16\b\2\u0084\u0081\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0083\3\2\2\2\u0085\33\3\2\2\2\u0086\u0087\7 \2\2\u0087"+
		"\u0088\7#\2\2\u0088\u0089\7 \2\2\u0089\35\3\2\2\2\u008a\u008b\7 \2\2\u008b"+
		"\u008d\7\3\2\2\u008c\u008e\5$\23\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0093\3\2\2\2\u008f\u0090\7\4\2\2\u0090\u0092\5$\23\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\5\2\2\u0097"+
		"\37\3\2\2\2\u0098\u0099\7\32\2\2\u0099\u009a\5\b\5\2\u009a\u009b\5.\30"+
		"\2\u009b\u009c\5\4\3\2\u009c\u009d\7\34\2\2\u009d!\3\2\2\2\u009e\u009f"+
		"\7\35\2\2\u009f\u00a0\5\16\b\2\u00a0\u00a1\7\36\2\2\u00a1\u00a2\5\32\16"+
		"\2\u00a2\u00a3\5.\30\2\u00a3\u00a4\5\4\3\2\u00a4\u00a5\7\34\2\2\u00a5"+
		"#\3\2\2\2\u00a6\u00a7\7 \2\2\u00a7\u00a8\7\t\2\2\u00a8\u00a9\5\30\r\2"+
		"\u00a9%\3\2\2\2\u00aa\u00ab\7\n\2\2\u00ab\'\3\2\2\2\u00ac\u00ad\7\6\2"+
		"\2\u00ad)\3\2\2\2\u00ae\u00b0\7\"\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\7$\2\2\u00b4\u00b6\7\"\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00c5\3\2\2\2\u00b9"+
		"\u00bb\7$\2\2\u00ba\u00bc\7\"\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c5\3\2\2\2\u00bf"+
		"\u00c1\7\"\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00af\3\2\2\2\u00c4"+
		"\u00b9\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c5+\3\2\2\2\u00c6\u00c7\t\4\2\2"+
		"\u00c7-\3\2\2\2\u00c8\u00c9\b\30\1\2\u00c9\u00ca\5&\24\2\u00ca\u00cf\3"+
		"\2\2\2\u00cb\u00cc\f\4\2\2\u00cc\u00ce\5&\24\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0/\3\2\2\2"+
		"\u00d1\u00cf\3\2\2\2\248@HNX^mv\177\u0084\u008d\u0093\u00b1\u00b7\u00bd"+
		"\u00c2\u00c4\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}