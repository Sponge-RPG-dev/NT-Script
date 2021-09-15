// Generated from nts.g4 by ANTLR 4.9.2
package cz.neumimto.nts;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ntsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ntsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ntsParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(ntsParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_list(ntsParser.Statement_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ntsParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#condition_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_expression(ntsParser.Condition_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#type_comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_comparison(ntsParser.Type_comparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#comparable_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparable_expr(ntsParser.Comparable_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#variable_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_reference(ntsParser.Variable_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#assignment_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_statement(ntsParser.Assignment_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(ntsParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(ntsParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#assignment_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_values(ntsParser.Assignment_valuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#rval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRval(ntsParser.RvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#iterable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterable(ntsParser.IterableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#type_enum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_enum(ntsParser.Type_enumContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(ntsParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(ntsParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#foreach_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeach_statement(ntsParser.Foreach_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(ntsParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#newline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewline(ntsParser.NewlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#type_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_literal(ntsParser.Type_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#type_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_integer(ntsParser.Type_integerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#type_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_bool(ntsParser.Type_boolContext ctx);
	/**
	 * Visit a parse tree produced by {@link ntsParser#terminator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminator(ntsParser.TerminatorContext ctx);
}