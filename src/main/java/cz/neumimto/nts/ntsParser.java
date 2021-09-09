// Generated from nts.g4 by ANTLR 4.5
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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, LITERAL=5, WS=6, SL_COMMENT=7, ASSIGN=8, 
		CRLF=9, RETURN=10, TRUE=11, FALSE=12, PLUS=13, MINUS=14, MUL=15, DIV=16, 
		MOD=17, EXP=18, EQUAL=19, NOT_EQUAL=20, GREATER=21, LESS=22, LESS_EQUAL=23, 
		GREATER_EQUAL=24, IF=25, ELSE=26, END=27, FOREACH=28, IN=29, IDENTIFIER=30, 
		VARIABLE_IDENTIFIER=31, INT=32;
	public static final int
		RULE_script = 0, RULE_statement_list = 1, RULE_statement = 2, RULE_condition_expression = 3, 
		RULE_type_comparison = 4, RULE_op_less = 5, RULE_op_greater = 6, RULE_op_less_eq = 7, 
		RULE_op_greater_eq = 8, RULE_op_eq = 9, RULE_op_neq = 10, RULE_comparable_expr = 11, 
		RULE_variable_reference = 12, RULE_assignment_statement = 13, RULE_return_statement = 14, 
		RULE_rval = 15, RULE_iterable = 16, RULE_type_enum = 17, RULE_function_call = 18, 
		RULE_if_statement = 19, RULE_foreach_statement = 20, RULE_argument = 21, 
		RULE_newline = 22, RULE_type_literal = 23, RULE_type_integer = 24, RULE_type_bool = 25, 
		RULE_terminator = 26;
	public static final String[] ruleNames = {
		"script", "statement_list", "statement", "condition_expression", "type_comparison", 
		"op_less", "op_greater", "op_less_eq", "op_greater_eq", "op_eq", "op_neq", 
		"comparable_expr", "variable_reference", "assignment_statement", "return_statement", 
		"rval", "iterable", "type_enum", "function_call", "if_statement", "foreach_statement", 
		"argument", "newline", "type_literal", "type_integer", "type_bool", "terminator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'{'", "','", "'}'", null, null, null, "'='", null, null, 
		null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", "'!='", 
		"'>'", "'<'", "'<='", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "LITERAL", "WS", "SL_COMMENT", "ASSIGN", 
		"CRLF", "RETURN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", 
		"EXP", "EQUAL", "NOT_EQUAL", "GREATER", "LESS", "LESS_EQUAL", "GREATER_EQUAL", 
		"IF", "ELSE", "END", "FOREACH", "IN", "IDENTIFIER", "VARIABLE_IDENTIFIER", 
		"INT"
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
			setState(54);
			statement_list(0);
			setState(55);
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
			setState(62);
			switch (_input.LA(1)) {
			case RETURN:
			case IF:
			case FOREACH:
			case IDENTIFIER:
			case VARIABLE_IDENTIFIER:
				{
				setState(58);
				statement();
				setState(59);
				terminator(0);
				}
				break;
			case CRLF:
				{
				setState(61);
				terminator(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
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
					setState(64);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(65);
					statement();
					setState(66);
					terminator(0);
					}
					} 
				}
				setState(72);
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
			setState(78);
			switch (_input.LA(1)) {
			case VARIABLE_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				assignment_statement();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				function_call();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				return_statement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				if_statement();
				}
				break;
			case FOREACH:
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
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
			setState(84);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				type_bool();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				variable_reference();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
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
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				((Type_comparisonContext)_localctx).left = comparable_expr();
				setState(87);
				((Type_comparisonContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER) | (1L << LESS) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
					((Type_comparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(88);
				((Type_comparisonContext)_localctx).right = comparable_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				((Type_comparisonContext)_localctx).left = comparable_expr();
				setState(91);
				((Type_comparisonContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
					((Type_comparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(92);
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

	public static class Op_lessContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(ntsParser.LESS, 0); }
		public Op_lessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_less; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterOp_less(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitOp_less(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitOp_less(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_lessContext op_less() throws RecognitionException {
		Op_lessContext _localctx = new Op_lessContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_op_less);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(LESS);
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

	public static class Op_greaterContext extends ParserRuleContext {
		public TerminalNode GREATER() { return getToken(ntsParser.GREATER, 0); }
		public Op_greaterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_greater; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterOp_greater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitOp_greater(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitOp_greater(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_greaterContext op_greater() throws RecognitionException {
		Op_greaterContext _localctx = new Op_greaterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_op_greater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(GREATER);
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

	public static class Op_less_eqContext extends ParserRuleContext {
		public TerminalNode LESS_EQUAL() { return getToken(ntsParser.LESS_EQUAL, 0); }
		public Op_less_eqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_less_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterOp_less_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitOp_less_eq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitOp_less_eq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_less_eqContext op_less_eq() throws RecognitionException {
		Op_less_eqContext _localctx = new Op_less_eqContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_op_less_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(LESS_EQUAL);
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

	public static class Op_greater_eqContext extends ParserRuleContext {
		public TerminalNode GREATER_EQUAL() { return getToken(ntsParser.GREATER_EQUAL, 0); }
		public Op_greater_eqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_greater_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterOp_greater_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitOp_greater_eq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitOp_greater_eq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_greater_eqContext op_greater_eq() throws RecognitionException {
		Op_greater_eqContext _localctx = new Op_greater_eqContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_op_greater_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(GREATER_EQUAL);
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

	public static class Op_eqContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(ntsParser.EQUAL, 0); }
		public Op_eqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterOp_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitOp_eq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitOp_eq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_eqContext op_eq() throws RecognitionException {
		Op_eqContext _localctx = new Op_eqContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_op_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(EQUAL);
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

	public static class Op_neqContext extends ParserRuleContext {
		public TerminalNode NOT_EQUAL() { return getToken(ntsParser.NOT_EQUAL, 0); }
		public Op_neqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_neq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterOp_neq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitOp_neq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitOp_neq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_neqContext op_neq() throws RecognitionException {
		Op_neqContext _localctx = new Op_neqContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_op_neq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(NOT_EQUAL);
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
		public Type_integerContext type_integer() {
			return getRuleContext(Type_integerContext.class,0);
		}
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
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
		enterRule(_localctx, 22, RULE_comparable_expr);
		try {
			setState(111);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				type_bool();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				type_integer();
				}
				break;
			case VARIABLE_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
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
		enterRule(_localctx, 24, RULE_variable_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
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
		public RvalContext value;
		public TerminalNode VARIABLE_IDENTIFIER() { return getToken(ntsParser.VARIABLE_IDENTIFIER, 0); }
		public RvalContext rval() {
			return getRuleContext(RvalContext.class,0);
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
		enterRule(_localctx, 26, RULE_assignment_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			((Assignment_statementContext)_localctx).name = match(VARIABLE_IDENTIFIER);
			setState(116);
			match(ASSIGN);
			setState(117);
			((Assignment_statementContext)_localctx).value = rval();
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
		enterRule(_localctx, 28, RULE_return_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(RETURN);
			setState(120);
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

	public static class RvalContext extends ParserRuleContext {
		public Type_literalContext type_literal() {
			return getRuleContext(Type_literalContext.class,0);
		}
		public Type_integerContext type_integer() {
			return getRuleContext(Type_integerContext.class,0);
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
		enterRule(_localctx, 30, RULE_rval);
		try {
			setState(128);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				type_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				type_integer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				function_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				type_enum();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				type_bool();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
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
		enterRule(_localctx, 32, RULE_iterable);
		try {
			setState(133);
			switch (_input.LA(1)) {
			case CRLF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				function_call();
				}
				break;
			case VARIABLE_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
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
		enterRule(_localctx, 34, RULE_type_enum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			((Type_enumContext)_localctx).type = match(IDENTIFIER);
			setState(136);
			match(T__0);
			setState(137);
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
		enterRule(_localctx, 36, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			((Function_callContext)_localctx).function_name = match(IDENTIFIER);
			setState(140);
			((Function_callContext)_localctx).arguments = match(T__1);
			setState(142);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(141);
				argument();
				}
			}

			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(144);
				match(T__2);
				setState(145);
				argument();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			match(T__3);
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
		enterRule(_localctx, 38, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(IF);
			setState(154);
			condition_expression();
			setState(155);
			terminator(0);
			setState(156);
			statement_list(0);
			setState(157);
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
		enterRule(_localctx, 40, RULE_foreach_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(FOREACH);
			setState(160);
			((Foreach_statementContext)_localctx).variable = variable_reference();
			setState(161);
			match(IN);
			setState(162);
			((Foreach_statementContext)_localctx).collection = iterable();
			setState(163);
			terminator(0);
			setState(164);
			statement_list(0);
			setState(165);
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
		enterRule(_localctx, 42, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			((ArgumentContext)_localctx).name = match(IDENTIFIER);
			setState(168);
			match(ASSIGN);
			setState(169);
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
		enterRule(_localctx, 44, RULE_newline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
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
		enterRule(_localctx, 46, RULE_type_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
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

	public static class Type_integerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ntsParser.INT, 0); }
		public Type_integerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).enterType_integer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ntsListener ) ((ntsListener)listener).exitType_integer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ntsVisitor ) return ((ntsVisitor<? extends T>)visitor).visitType_integer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_integerContext type_integer() throws RecognitionException {
		Type_integerContext _localctx = new Type_integerContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(INT);
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
		enterRule(_localctx, 50, RULE_type_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			} else {
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_terminator, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(180);
			newline();
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TerminatorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_terminator);
					setState(182);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(183);
					newline();
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		case 26:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"\u00c0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3A\n"+
		"\3\3\3\3\3\3\3\3\3\7\3G\n\3\f\3\16\3J\13\3\3\4\3\4\3\4\3\4\3\4\5\4Q\n"+
		"\4\3\5\3\5\3\5\3\5\5\5W\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6a\n\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\5\rr\n\r"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u0083\n\21\3\22\3\22\3\22\5\22\u0088\n\22\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\5\24\u0091\n\24\3\24\3\24\7\24\u0095\n\24\f\24\16\24"+
		"\u0098\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u00bb\n\34\f\34\16\34\u00be"+
		"\13\34\3\34\2\4\4\66\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\66\2\5\3\2\27\32\3\2\25\26\3\2\r\16\u00ba\28\3\2\2\2\4@\3"+
		"\2\2\2\6P\3\2\2\2\bV\3\2\2\2\n`\3\2\2\2\fb\3\2\2\2\16d\3\2\2\2\20f\3\2"+
		"\2\2\22h\3\2\2\2\24j\3\2\2\2\26l\3\2\2\2\30q\3\2\2\2\32s\3\2\2\2\34u\3"+
		"\2\2\2\36y\3\2\2\2 \u0082\3\2\2\2\"\u0087\3\2\2\2$\u0089\3\2\2\2&\u008d"+
		"\3\2\2\2(\u009b\3\2\2\2*\u00a1\3\2\2\2,\u00a9\3\2\2\2.\u00ad\3\2\2\2\60"+
		"\u00af\3\2\2\2\62\u00b1\3\2\2\2\64\u00b3\3\2\2\2\66\u00b5\3\2\2\289\5"+
		"\4\3\29:\7\2\2\3:\3\3\2\2\2;<\b\3\1\2<=\5\6\4\2=>\5\66\34\2>A\3\2\2\2"+
		"?A\5\66\34\2@;\3\2\2\2@?\3\2\2\2AH\3\2\2\2BC\f\4\2\2CD\5\6\4\2DE\5\66"+
		"\34\2EG\3\2\2\2FB\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\5\3\2\2\2JH\3"+
		"\2\2\2KQ\5\34\17\2LQ\5&\24\2MQ\5\36\20\2NQ\5(\25\2OQ\5*\26\2PK\3\2\2\2"+
		"PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2Q\7\3\2\2\2RW\5&\24\2SW\5\64\33"+
		"\2TW\5\32\16\2UW\5\n\6\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\t\3"+
		"\2\2\2XY\5\30\r\2YZ\t\2\2\2Z[\5\30\r\2[a\3\2\2\2\\]\5\30\r\2]^\t\3\2\2"+
		"^_\5\30\r\2_a\3\2\2\2`X\3\2\2\2`\\\3\2\2\2a\13\3\2\2\2bc\7\30\2\2c\r\3"+
		"\2\2\2de\7\27\2\2e\17\3\2\2\2fg\7\31\2\2g\21\3\2\2\2hi\7\32\2\2i\23\3"+
		"\2\2\2jk\7\25\2\2k\25\3\2\2\2lm\7\26\2\2m\27\3\2\2\2nr\5\64\33\2or\5\62"+
		"\32\2pr\5\32\16\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2r\31\3\2\2\2st\7!\2\2t"+
		"\33\3\2\2\2uv\7!\2\2vw\7\n\2\2wx\5 \21\2x\35\3\2\2\2yz\7\f\2\2z{\5 \21"+
		"\2{\37\3\2\2\2|\u0083\5\60\31\2}\u0083\5\62\32\2~\u0083\5&\24\2\177\u0083"+
		"\5$\23\2\u0080\u0083\5\64\33\2\u0081\u0083\5\32\16\2\u0082|\3\2\2\2\u0082"+
		"}\3\2\2\2\u0082~\3\2\2\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0081"+
		"\3\2\2\2\u0083!\3\2\2\2\u0084\u0088\3\2\2\2\u0085\u0088\5&\24\2\u0086"+
		"\u0088\5\32\16\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086\3"+
		"\2\2\2\u0088#\3\2\2\2\u0089\u008a\7 \2\2\u008a\u008b\7\3\2\2\u008b\u008c"+
		"\7 \2\2\u008c%\3\2\2\2\u008d\u008e\7 \2\2\u008e\u0090\7\4\2\2\u008f\u0091"+
		"\5,\27\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0096\3\2\2\2\u0092"+
		"\u0093\7\5\2\2\u0093\u0095\5,\27\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009a\7\6\2\2\u009a\'\3\2\2\2\u009b\u009c\7\33\2"+
		"\2\u009c\u009d\5\b\5\2\u009d\u009e\5\66\34\2\u009e\u009f\5\4\3\2\u009f"+
		"\u00a0\7\35\2\2\u00a0)\3\2\2\2\u00a1\u00a2\7\36\2\2\u00a2\u00a3\5\32\16"+
		"\2\u00a3\u00a4\7\37\2\2\u00a4\u00a5\5\"\22\2\u00a5\u00a6\5\66\34\2\u00a6"+
		"\u00a7\5\4\3\2\u00a7\u00a8\7\35\2\2\u00a8+\3\2\2\2\u00a9\u00aa\7 \2\2"+
		"\u00aa\u00ab\7\n\2\2\u00ab\u00ac\5 \21\2\u00ac-\3\2\2\2\u00ad\u00ae\7"+
		"\13\2\2\u00ae/\3\2\2\2\u00af\u00b0\7\7\2\2\u00b0\61\3\2\2\2\u00b1\u00b2"+
		"\7\"\2\2\u00b2\63\3\2\2\2\u00b3\u00b4\t\4\2\2\u00b4\65\3\2\2\2\u00b5\u00b6"+
		"\b\34\1\2\u00b6\u00b7\5.\30\2\u00b7\u00bc\3\2\2\2\u00b8\u00b9\f\4\2\2"+
		"\u00b9\u00bb\5.\30\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\67\3\2\2\2\u00be\u00bc\3\2\2\2\r@H"+
		"PV`q\u0082\u0087\u0090\u0096\u00bc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}