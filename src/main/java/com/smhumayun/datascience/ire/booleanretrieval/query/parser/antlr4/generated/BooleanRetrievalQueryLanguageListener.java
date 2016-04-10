// Generated from BooleanRetrievalQueryLanguage.g4 by ANTLR 4.5.3

package com.smhumayun.datascience.ire.booleanretrieval.query.parser.antlr4.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BooleanRetrievalQueryLanguageParser}.
 */
public interface BooleanRetrievalQueryLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(BooleanRetrievalQueryLanguageParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(BooleanRetrievalQueryLanguageParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BooleanRetrievalQueryLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BooleanRetrievalQueryLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#nestedExpr}.
	 * @param ctx the parse tree
	 */
	void enterNestedExpr(BooleanRetrievalQueryLanguageParser.NestedExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#nestedExpr}.
	 * @param ctx the parse tree
	 */
	void exitNestedExpr(BooleanRetrievalQueryLanguageParser.NestedExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(BooleanRetrievalQueryLanguageParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(BooleanRetrievalQueryLanguageParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#literalExpr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(BooleanRetrievalQueryLanguageParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#literalExpr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(BooleanRetrievalQueryLanguageParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#termExpr}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(BooleanRetrievalQueryLanguageParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#termExpr}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(BooleanRetrievalQueryLanguageParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(BooleanRetrievalQueryLanguageParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(BooleanRetrievalQueryLanguageParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(BooleanRetrievalQueryLanguageParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(BooleanRetrievalQueryLanguageParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(BooleanRetrievalQueryLanguageParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanRetrievalQueryLanguageParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(BooleanRetrievalQueryLanguageParser.Boolean_literalContext ctx);
}