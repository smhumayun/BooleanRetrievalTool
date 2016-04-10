package com.smhumayun.datascience.ire.booleanretrieval.query.parser.antlr4;

import com.smhumayun.datascience.ire.booleanretrieval.query.expression.*;
import com.smhumayun.datascience.ire.booleanretrieval.query.parser.antlr4.generated.BooleanRetrievalQueryLanguageBaseListener;
import com.smhumayun.datascience.ire.booleanretrieval.query.parser.antlr4.generated.BooleanRetrievalQueryLanguageParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

/**
 * Created by Humayun on 4/11/2016.
 */
public class BooleanRetrievalQueryLanguageListenerImpl extends BooleanRetrievalQueryLanguageBaseListener {

    private boolean ignoreTerminalValue = false;
    private Stack<IBooleanExpression> expressionStack = new Stack<IBooleanExpression>();
    private IBooleanExpression operand = null;

    public Stack<IBooleanExpression> getExpressionStack() {
        return expressionStack;
    }

    public IBooleanExpression getOperand() {
        return operand;
    }

    @Override
    public void enterNestedExpr(BooleanRetrievalQueryLanguageParser.NestedExprContext ctx) {
        expressionStack.push(new NestedBooleanExpression());
    }

    @Override
    public void exitNestedExpr(BooleanRetrievalQueryLanguageParser.NestedExprContext ctx) {
        if(expressionStack.size() > 0) {
            if (operand != null) {
                ((NestedBooleanExpression) expressionStack.peek()).setNestedBooleanExpression(operand);
                operand = expressionStack.pop();
                processOperand();
            }
        }
    }

    @Override
    public void enterLiteralExpr(BooleanRetrievalQueryLanguageParser.LiteralExprContext ctx) {
        ignoreTerminalValue = false;
    }

    @Override
    public void exitLiteralExpr(BooleanRetrievalQueryLanguageParser.LiteralExprContext ctx) {
        ignoreTerminalValue = true;
    }

    @Override
    public void enterTermExpr(BooleanRetrievalQueryLanguageParser.TermExprContext ctx) {
        ignoreTerminalValue = false;
    }

    @Override
    public void exitTermExpr(BooleanRetrievalQueryLanguageParser.TermExprContext ctx) {
        ignoreTerminalValue = true;
    }

    @Override
    public void enterUnaryOp(BooleanRetrievalQueryLanguageParser.UnaryOpContext ctx) {
        ignoreTerminalValue = true;
        expressionStack.push(new UnaryBooleanExpression());
    }

    @Override
    public void exitUnaryOp(BooleanRetrievalQueryLanguageParser.UnaryOpContext ctx) {
        ignoreTerminalValue = false;
        if(ctx.getText().equalsIgnoreCase(NotUnaryBooleanOperator.TEXT)) {
            ((UnaryBooleanExpression) expressionStack.peek()).setUnaryBooleanOperator(NotUnaryBooleanOperator.INSTANCE);
        }
    }


    @Override
    public void enterBinaryOp(BooleanRetrievalQueryLanguageParser.BinaryOpContext ctx) {
        ignoreTerminalValue = true;
        expressionStack.push(new BinaryBooleanExpression());
        ((BinaryBooleanExpression) expressionStack.peek()).setLeftBooleanExpression(operand);
        operand = null;
    }

    @Override
    public void exitBinaryOp(BooleanRetrievalQueryLanguageParser.BinaryOpContext ctx) {
        ignoreTerminalValue = false;
        if(ctx.getText().equalsIgnoreCase(AndBinaryBooleanOperator.TEXT)) {
            ((BinaryBooleanExpression) expressionStack.peek()).setBinaryBooleanOperator(AndBinaryBooleanOperator.INSTANCE);
        } else if(ctx.getText().equalsIgnoreCase(OrBinaryBooleanOperator.TEXT)) {
            ((BinaryBooleanExpression) expressionStack.peek()).setBinaryBooleanOperator(OrBinaryBooleanOperator.INSTANCE);
        }
    }

    @Override
    public void exitBoolean_literal(BooleanRetrievalQueryLanguageParser.Boolean_literalContext ctx) {
        operand = ctx.getText().equalsIgnoreCase(BooleanLiteral.TRUE.toString()) ? BooleanLiteral.TRUE : BooleanLiteral.FALSE;
        processOperand();
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        if (!ignoreTerminalValue && node.getText() != null
                && !node.getText().trim().equals("(") && !node.getText().trim().equals(")")) {
            operand = new Term(node.getText());
            processOperand();
        }
    }

    private void processOperand () {
        if (expressionStack.size() > 0 && expressionStack.peek() instanceof UnaryBooleanExpression) {
            ((UnaryBooleanExpression) expressionStack.peek()).setBooleanExpression(operand);
            operand = expressionStack.pop();
            processOperand();
        }
        if (expressionStack.size() > 0 && expressionStack.peek() instanceof BinaryBooleanExpression) {
            ((BinaryBooleanExpression) expressionStack.peek()).setRightBooleanExpression(operand);
            operand = expressionStack.pop();
            processOperand();
        }
    }

}