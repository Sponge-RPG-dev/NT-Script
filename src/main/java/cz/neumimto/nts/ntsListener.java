// Generated from nts.g4 by ANTLR 4.9.2
package cz.neumimto.nts;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ntsParser}.
 */
public interface ntsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ntsParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(ntsParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(ntsParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void enterStatement_list(ntsParser.Statement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void exitStatement_list(ntsParser.Statement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ntsParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ntsParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#condition_expression}.
	 * @param ctx the parse tree
	 */
	void enterCondition_expression(ntsParser.Condition_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#condition_expression}.
	 * @param ctx the parse tree
	 */
	void exitCondition_expression(ntsParser.Condition_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#type_comparison}.
	 * @param ctx the parse tree
	 */
	void enterType_comparison(ntsParser.Type_comparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#type_comparison}.
	 * @param ctx the parse tree
	 */
	void exitType_comparison(ntsParser.Type_comparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#comparable_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparable_expr(ntsParser.Comparable_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#comparable_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparable_expr(ntsParser.Comparable_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#variable_reference}.
	 * @param ctx the parse tree
	 */
	void enterVariable_reference(ntsParser.Variable_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#variable_reference}.
	 * @param ctx the parse tree
	 */
	void exitVariable_reference(ntsParser.Variable_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#putField_statement}.
	 * @param ctx the parse tree
	 */
	void enterPutField_statement(ntsParser.PutField_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#putField_statement}.
	 * @param ctx the parse tree
	 */
	void exitPutField_statement(ntsParser.PutField_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#getField_statement}.
	 * @param ctx the parse tree
	 */
	void enterGetField_statement(ntsParser.GetField_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#getField_statement}.
	 * @param ctx the parse tree
	 */
	void exitGetField_statement(ntsParser.GetField_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(ntsParser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(ntsParser.Assignment_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(ntsParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(ntsParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(ntsParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(ntsParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#assignment_values}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_values(ntsParser.Assignment_valuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#assignment_values}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_values(ntsParser.Assignment_valuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#rval}.
	 * @param ctx the parse tree
	 */
	void enterRval(ntsParser.RvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#rval}.
	 * @param ctx the parse tree
	 */
	void exitRval(ntsParser.RvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#iterable}.
	 * @param ctx the parse tree
	 */
	void enterIterable(ntsParser.IterableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#iterable}.
	 * @param ctx the parse tree
	 */
	void exitIterable(ntsParser.IterableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#type_enum}.
	 * @param ctx the parse tree
	 */
	void enterType_enum(ntsParser.Type_enumContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#type_enum}.
	 * @param ctx the parse tree
	 */
	void exitType_enum(ntsParser.Type_enumContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(ntsParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(ntsParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(ntsParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(ntsParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#foreach_statement}.
	 * @param ctx the parse tree
	 */
	void enterForeach_statement(ntsParser.Foreach_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#foreach_statement}.
	 * @param ctx the parse tree
	 */
	void exitForeach_statement(ntsParser.Foreach_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(ntsParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(ntsParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#newline}.
	 * @param ctx the parse tree
	 */
	void enterNewline(ntsParser.NewlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#newline}.
	 * @param ctx the parse tree
	 */
	void exitNewline(ntsParser.NewlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#type_literal}.
	 * @param ctx the parse tree
	 */
	void enterType_literal(ntsParser.Type_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#type_literal}.
	 * @param ctx the parse tree
	 */
	void exitType_literal(ntsParser.Type_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#type_double}.
	 * @param ctx the parse tree
	 */
	void enterType_double(ntsParser.Type_doubleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#type_double}.
	 * @param ctx the parse tree
	 */
	void exitType_double(ntsParser.Type_doubleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#type_bool}.
	 * @param ctx the parse tree
	 */
	void enterType_bool(ntsParser.Type_boolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#type_bool}.
	 * @param ctx the parse tree
	 */
	void exitType_bool(ntsParser.Type_boolContext ctx);
	/**
	 * Enter a parse tree produced by {@link ntsParser#terminator}.
	 * @param ctx the parse tree
	 */
	void enterTerminator(ntsParser.TerminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ntsParser#terminator}.
	 * @param ctx the parse tree
	 */
	void exitTerminator(ntsParser.TerminatorContext ctx);
}