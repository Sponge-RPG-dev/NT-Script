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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, LITERAL=6, WS=7, SL_COMMENT=8, 
		ASSIGN=9, CRLF=10, RETURN=11, TRUE=12, FALSE=13, PLUS=14, MINUS=15, MUL=16, 
		DIV=17, MOD=18, EXP=19, EQUAL=20, NOT_EQUAL=21, LESS_EQUAL=22, GREATER_EQUAL=23, 
		GREATER=24, LESS=25, IF=26, ELSE=27, END=28, FOREACH=29, IN=30, FUNCTION=31, 
		IDENTIFIER=32, ENUM_IDENTIFIER=33, INT=34, DOT=35;
	public static final int
		RULE_script = 0, RULE_statement_list = 1, RULE_statement = 2, RULE_condition_expression = 3, 
		RULE_type_comparison = 4, RULE_comparable_expr = 5, RULE_variable_reference = 6, 
		RULE_putField_statement = 7, RULE_getField_statement = 8, RULE_assignment_statement = 9, 
		RULE_return_statement = 10, RULE_lambda = 11, RULE_assignment_values = 12, 
		RULE_rval = 13, RULE_iterable = 14, RULE_function_call = 15, RULE_if_statement = 16, 
		RULE_foreach_statement = 17, RULE_argument = 18, RULE_newline = 19, RULE_type_literal = 20, 
		RULE_type_double = 21, RULE_type_bool = 22, RULE_terminator = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "statement_list", "statement", "condition_expression", "type_comparison", 
			"comparable_expr", "variable_reference", "putField_statement", "getField_statement", 
			"assignment_statement", "return_statement", "lambda", "assignment_values", 
			"rval", "iterable", "function_call", "if_statement", "foreach_statement", 
			"argument", "newline", "type_literal", "type_double", "type_bool", "terminator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'as'", "'('", "')'", "','", "':'", null, null, null, "'='", null, 
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", 
			"'!='", null, null, "'>'", "'<'", null, null, null, null, null, null, 
			null, null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "LITERAL", "WS", "SL_COMMENT", "ASSIGN", 
			"CRLF", "RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", 
			"EXP", "EQUAL", "NOT_EQUAL", "LESS_EQUAL", "GREATER_EQUAL", "GREATER", 
			"LESS", "IF", "ELSE", "END", "FOREACH", "IN", "FUNCTION", "IDENTIFIER", 
			"ENUM_IDENTIFIER", "INT", "DOT"
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
			setState(48);
			statement_list(0);
			setState(49);
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
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case IF:
			case FOREACH:
			case IDENTIFIER:
				{
				setState(52);
				statement();
				setState(53);
				terminator(0);
				}
				break;
			case CRLF:
				{
				setState(55);
				terminator(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
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
					setState(58);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(59);
					statement();
					setState(60);
					terminator(0);
					}
					} 
				}
				setState(66);
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
		public PutField_statementContext putField_statement() {
			return getRuleContext(PutField_statementContext.class,0);
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
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
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
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				assignment_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				putField_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				return_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				if_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				foreach_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
				function_call();
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
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				type_bool();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				variable_reference();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
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
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((Type_comparisonContext)_localctx).left = comparable_expr();
				setState(82);
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
				setState(83);
				((Type_comparisonContext)_localctx).right = comparable_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				((Type_comparisonContext)_localctx).left = comparable_expr();
				setState(86);
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
				setState(87);
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
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				type_bool();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				type_double();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				variable_reference();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				function_call();
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

	public static class Variable_referenceContext extends ParserRuleContext {
		public Token variable;
		public TerminalNode IDENTIFIER() { return getToken(ntsParser.IDENTIFIER, 0); }
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
			setState(97);
			((Variable_referenceContext)_localctx).variable = match(IDENTIFIER);
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

	public static class PutField_statementContext extends ParserRuleContext {
		public Variable_referenceContext fieldOwner;
		public Token field;
		public RvalContext value;
		public TerminalNode DOT() { return getToken(ntsParser.DOT, 0); }
		public TerminalNode ASSIGN() { return getToken(ntsParser.ASSIGN, 0); }
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ntsParser.IDENTIFIER, 0); }
		public RvalContext rval() {
			return getRuleContext(RvalContext.class,0);
		}
		public PutField_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_putField_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterPutField_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitPutField_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitPutField_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PutField_statementContext putField_statement() throws RecognitionException {
		PutField_statementContext _localctx = new PutField_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_putField_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			((PutField_statementContext)_localctx).fieldOwner = variable_reference();
			setState(100);
			match(DOT);
			setState(101);
			((PutField_statementContext)_localctx).field = match(IDENTIFIER);
			setState(102);
			match(ASSIGN);
			setState(103);
			((PutField_statementContext)_localctx).value = rval(0);
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

	public static class GetField_statementContext extends ParserRuleContext {
		public Variable_referenceContext fieldOwner;
		public Token field;
		public Token type_cast;
		public TerminalNode DOT() { return getToken(ntsParser.DOT, 0); }
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ntsParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ntsParser.IDENTIFIER, i);
		}
		public GetField_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getField_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterGetField_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitGetField_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitGetField_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetField_statementContext getField_statement() throws RecognitionException {
		GetField_statementContext _localctx = new GetField_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_getField_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			((GetField_statementContext)_localctx).fieldOwner = variable_reference();
			setState(106);
			match(DOT);
			setState(107);
			((GetField_statementContext)_localctx).field = match(IDENTIFIER);
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(108);
				match(T__0);
				setState(109);
				((GetField_statementContext)_localctx).type_cast = match(IDENTIFIER);
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

	public static class Assignment_statementContext extends ParserRuleContext {
		public Token name;
		public Assignment_valuesContext value;
		public TerminalNode ASSIGN() { return getToken(ntsParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ntsParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 18, RULE_assignment_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			((Assignment_statementContext)_localctx).name = match(IDENTIFIER);
			setState(113);
			match(ASSIGN);
			setState(114);
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
		enterRule(_localctx, 20, RULE_return_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(RETURN);
			setState(117);
			((Return_statementContext)_localctx).value = rval(0);
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
		enterRule(_localctx, 22, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(FUNCTION);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(120);
				((LambdaContext)_localctx).vars = variable_reference();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			terminator(0);
			setState(127);
			statement_list(0);
			setState(128);
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
		enterRule(_localctx, 24, RULE_assignment_values);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case LITERAL:
			case TRUE:
			case FALSE:
			case MINUS:
			case IDENTIFIER:
			case INT:
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				rval(0);
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
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
		public RvalContext left;
		public Token op;
		public RvalContext right;
		public Type_literalContext type_literal() {
			return getRuleContext(Type_literalContext.class,0);
		}
		public Type_doubleContext type_double() {
			return getRuleContext(Type_doubleContext.class,0);
		}
		public List<RvalContext> rval() {
			return getRuleContexts(RvalContext.class);
		}
		public RvalContext rval(int i) {
			return getRuleContext(RvalContext.class,i);
		}
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
		public GetField_statementContext getField_statement() {
			return getRuleContext(GetField_statementContext.class,0);
		}
		public TerminalNode MUL() { return getToken(ntsParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ntsParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(ntsParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ntsParser.MINUS, 0); }
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
		return rval(0);
	}

	private RvalContext rval(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RvalContext _localctx = new RvalContext(_ctx, _parentState);
		RvalContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_rval, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(135);
				type_literal();
				}
				break;
			case 2:
				{
				setState(136);
				type_double();
				}
				break;
			case 3:
				{
				setState(137);
				match(T__1);
				setState(138);
				rval(0);
				setState(139);
				match(T__2);
				}
				break;
			case 4:
				{
				setState(141);
				function_call();
				}
				break;
			case 5:
				{
				setState(142);
				type_bool();
				}
				break;
			case 6:
				{
				setState(143);
				variable_reference();
				}
				break;
			case 7:
				{
				setState(144);
				type_comparison();
				}
				break;
			case 8:
				{
				setState(145);
				getField_statement();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(154);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new RvalContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rval);
						setState(148);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(149);
						((RvalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((RvalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(150);
						((RvalContext)_localctx).right = rval(9);
						}
						break;
					case 2:
						{
						_localctx = new RvalContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rval);
						setState(151);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(152);
						((RvalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((RvalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(153);
						((RvalContext)_localctx).right = rval(8);
						}
						break;
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 28, RULE_iterable);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				function_call();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				variable_reference();
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

	public static class Function_callContext extends ParserRuleContext {
		public Token function_name;
		public Token arguments;
		public Token type_cast;
		public List<TerminalNode> IDENTIFIER() { return getTokens(ntsParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ntsParser.IDENTIFIER, i);
		}
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
		enterRule(_localctx, 30, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			((Function_callContext)_localctx).function_name = match(IDENTIFIER);
			setState(165);
			((Function_callContext)_localctx).arguments = match(T__1);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(166);
				argument();
				}
			}

			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(169);
				match(T__3);
				setState(170);
				argument();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			match(T__2);
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(177);
				match(T__0);
				setState(178);
				((Function_callContext)_localctx).type_cast = match(IDENTIFIER);
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
		enterRule(_localctx, 32, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(IF);
			setState(182);
			condition_expression();
			setState(183);
			terminator(0);
			setState(184);
			statement_list(0);
			setState(185);
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
		enterRule(_localctx, 34, RULE_foreach_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(FOREACH);
			setState(188);
			((Foreach_statementContext)_localctx).variable = variable_reference();
			setState(189);
			match(IN);
			setState(190);
			((Foreach_statementContext)_localctx).collection = iterable();
			setState(191);
			terminator(0);
			setState(192);
			statement_list(0);
			setState(193);
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
		enterRule(_localctx, 36, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			((ArgumentContext)_localctx).name = match(IDENTIFIER);
			setState(196);
			match(T__4);
			setState(197);
			((ArgumentContext)_localctx).value = rval(0);
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
		enterRule(_localctx, 38, RULE_newline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
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
		enterRule(_localctx, 40, RULE_type_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
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
		public TerminalNode DOT() { return getToken(ntsParser.DOT, 0); }
		public TerminalNode MINUS() { return getToken(ntsParser.MINUS, 0); }
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
		enterRule(_localctx, 42, RULE_type_double);
		int _la;
		try {
			int _alt;
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(203);
					match(MINUS);
					}
				}

				setState(207); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(206);
					match(INT);
					}
					}
					setState(209); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT );
				setState(211);
				match(DOT);
				setState(213); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(212);
						match(INT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(215); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(217);
					match(MINUS);
					}
				}

				setState(220);
				match(DOT);
				setState(222); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(221);
						match(INT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(224); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(226);
					match(MINUS);
					}
				}

				setState(230); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(229);
						match(INT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(232); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		enterRule(_localctx, 44, RULE_type_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_terminator, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(239);
			newline();
			}
			_ctx.stop = _input.LT(-1);
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TerminatorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_terminator);
					setState(241);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(242);
					newline();
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		case 13:
			return rval_sempred((RvalContext)_localctx, predIndex);
		case 23:
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
	private boolean rval_sempred(RvalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}
	private boolean terminator_sempred(TerminatorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00fb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3;\n\3\3\3\3\3\3\3\3\3\7\3A\n\3\f\3"+
		"\16\3D\13\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4L\n\4\3\5\3\5\3\5\3\5\5\5R\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\\\n\6\3\7\3\7\3\7\3\7\5\7b\n\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\nq\n\n\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\7\r|\n\r\f\r\16\r\177\13\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\5\16\u0087\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u0095\n\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u009d\n\17\f\17\16\17\u00a0\13\17\3\20\3\20\3\20\5\20\u00a5\n\20\3\21"+
		"\3\21\3\21\5\21\u00aa\n\21\3\21\3\21\7\21\u00ae\n\21\f\21\16\21\u00b1"+
		"\13\21\3\21\3\21\3\21\5\21\u00b6\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\5\27\u00cf\n\27\3\27\6\27\u00d2\n\27\r\27\16\27\u00d3\3"+
		"\27\3\27\6\27\u00d8\n\27\r\27\16\27\u00d9\3\27\5\27\u00dd\n\27\3\27\3"+
		"\27\6\27\u00e1\n\27\r\27\16\27\u00e2\3\27\5\27\u00e6\n\27\3\27\6\27\u00e9"+
		"\n\27\r\27\16\27\u00ea\5\27\u00ed\n\27\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\7\31\u00f6\n\31\f\31\16\31\u00f9\13\31\3\31\2\5\4\34\60\32\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\7\3\2\30\33\3\2\26\27\3"+
		"\2\22\23\3\2\20\21\3\2\16\17\2\u010b\2\62\3\2\2\2\4:\3\2\2\2\6K\3\2\2"+
		"\2\bQ\3\2\2\2\n[\3\2\2\2\fa\3\2\2\2\16c\3\2\2\2\20e\3\2\2\2\22k\3\2\2"+
		"\2\24r\3\2\2\2\26v\3\2\2\2\30y\3\2\2\2\32\u0086\3\2\2\2\34\u0094\3\2\2"+
		"\2\36\u00a4\3\2\2\2 \u00a6\3\2\2\2\"\u00b7\3\2\2\2$\u00bd\3\2\2\2&\u00c5"+
		"\3\2\2\2(\u00c9\3\2\2\2*\u00cb\3\2\2\2,\u00ec\3\2\2\2.\u00ee\3\2\2\2\60"+
		"\u00f0\3\2\2\2\62\63\5\4\3\2\63\64\7\2\2\3\64\3\3\2\2\2\65\66\b\3\1\2"+
		"\66\67\5\6\4\2\678\5\60\31\28;\3\2\2\29;\5\60\31\2:\65\3\2\2\2:9\3\2\2"+
		"\2;B\3\2\2\2<=\f\4\2\2=>\5\6\4\2>?\5\60\31\2?A\3\2\2\2@<\3\2\2\2AD\3\2"+
		"\2\2B@\3\2\2\2BC\3\2\2\2C\5\3\2\2\2DB\3\2\2\2EL\5\24\13\2FL\5\20\t\2G"+
		"L\5\26\f\2HL\5\"\22\2IL\5$\23\2JL\5 \21\2KE\3\2\2\2KF\3\2\2\2KG\3\2\2"+
		"\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2L\7\3\2\2\2MR\5 \21\2NR\5.\30\2OR\5\16"+
		"\b\2PR\5\n\6\2QM\3\2\2\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\t\3\2\2\2ST\5"+
		"\f\7\2TU\t\2\2\2UV\5\f\7\2V\\\3\2\2\2WX\5\f\7\2XY\t\3\2\2YZ\5\f\7\2Z\\"+
		"\3\2\2\2[S\3\2\2\2[W\3\2\2\2\\\13\3\2\2\2]b\5.\30\2^b\5,\27\2_b\5\16\b"+
		"\2`b\5 \21\2a]\3\2\2\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2\2b\r\3\2\2\2cd\7\""+
		"\2\2d\17\3\2\2\2ef\5\16\b\2fg\7%\2\2gh\7\"\2\2hi\7\13\2\2ij\5\34\17\2"+
		"j\21\3\2\2\2kl\5\16\b\2lm\7%\2\2mp\7\"\2\2no\7\3\2\2oq\7\"\2\2pn\3\2\2"+
		"\2pq\3\2\2\2q\23\3\2\2\2rs\7\"\2\2st\7\13\2\2tu\5\32\16\2u\25\3\2\2\2"+
		"vw\7\r\2\2wx\5\34\17\2x\27\3\2\2\2y}\7!\2\2z|\5\16\b\2{z\3\2\2\2|\177"+
		"\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\5"+
		"\60\31\2\u0081\u0082\5\4\3\2\u0082\u0083\7\36\2\2\u0083\31\3\2\2\2\u0084"+
		"\u0087\5\34\17\2\u0085\u0087\5\30\r\2\u0086\u0084\3\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\33\3\2\2\2\u0088\u0089\b\17\1\2\u0089\u0095\5*\26\2\u008a"+
		"\u0095\5,\27\2\u008b\u008c\7\4\2\2\u008c\u008d\5\34\17\2\u008d\u008e\7"+
		"\5\2\2\u008e\u0095\3\2\2\2\u008f\u0095\5 \21\2\u0090\u0095\5.\30\2\u0091"+
		"\u0095\5\16\b\2\u0092\u0095\5\n\6\2\u0093\u0095\5\22\n\2\u0094\u0088\3"+
		"\2\2\2\u0094\u008a\3\2\2\2\u0094\u008b\3\2\2\2\u0094\u008f\3\2\2\2\u0094"+
		"\u0090\3\2\2\2\u0094\u0091\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2"+
		"\2\2\u0095\u009e\3\2\2\2\u0096\u0097\f\n\2\2\u0097\u0098\t\4\2\2\u0098"+
		"\u009d\5\34\17\13\u0099\u009a\f\t\2\2\u009a\u009b\t\5\2\2\u009b\u009d"+
		"\5\34\17\n\u009c\u0096\3\2\2\2\u009c\u0099\3\2\2\2\u009d\u00a0\3\2\2\2"+
		"\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\35\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00a5\3\2\2\2\u00a2\u00a5\5 \21\2\u00a3\u00a5\5\16\b\2"+
		"\u00a4\u00a1\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\37"+
		"\3\2\2\2\u00a6\u00a7\7\"\2\2\u00a7\u00a9\7\4\2\2\u00a8\u00aa\5&\24\2\u00a9"+
		"\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00af\3\2\2\2\u00ab\u00ac\7\6"+
		"\2\2\u00ac\u00ae\5&\24\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b2\u00b5\7\5\2\2\u00b3\u00b4\7\3\2\2\u00b4\u00b6\7\"\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6!\3\2\2\2\u00b7\u00b8\7\34\2\2"+
		"\u00b8\u00b9\5\b\5\2\u00b9\u00ba\5\60\31\2\u00ba\u00bb\5\4\3\2\u00bb\u00bc"+
		"\7\36\2\2\u00bc#\3\2\2\2\u00bd\u00be\7\37\2\2\u00be\u00bf\5\16\b\2\u00bf"+
		"\u00c0\7 \2\2\u00c0\u00c1\5\36\20\2\u00c1\u00c2\5\60\31\2\u00c2\u00c3"+
		"\5\4\3\2\u00c3\u00c4\7\36\2\2\u00c4%\3\2\2\2\u00c5\u00c6\7\"\2\2\u00c6"+
		"\u00c7\7\7\2\2\u00c7\u00c8\5\34\17\2\u00c8\'\3\2\2\2\u00c9\u00ca\7\f\2"+
		"\2\u00ca)\3\2\2\2\u00cb\u00cc\7\b\2\2\u00cc+\3\2\2\2\u00cd\u00cf\7\21"+
		"\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00d2\7$\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\7%\2\2\u00d6"+
		"\u00d8\7$\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da\u00ed\3\2\2\2\u00db\u00dd\7\21\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\7%"+
		"\2\2\u00df\u00e1\7$\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00ed\3\2\2\2\u00e4\u00e6\7\21"+
		"\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00e9\7$\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ce\3\2\2\2\u00ec"+
		"\u00dc\3\2\2\2\u00ec\u00e5\3\2\2\2\u00ed-\3\2\2\2\u00ee\u00ef\t\6\2\2"+
		"\u00ef/\3\2\2\2\u00f0\u00f1\b\31\1\2\u00f1\u00f2\5(\25\2\u00f2\u00f7\3"+
		"\2\2\2\u00f3\u00f4\f\4\2\2\u00f4\u00f6\5(\25\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\61\3\2\2"+
		"\2\u00f9\u00f7\3\2\2\2\33:BKQ[ap}\u0086\u0094\u009c\u009e\u00a4\u00a9"+
		"\u00af\u00b5\u00ce\u00d3\u00d9\u00dc\u00e2\u00e5\u00ea\u00ec\u00f7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}