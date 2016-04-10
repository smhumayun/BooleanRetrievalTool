package com.smhumayun.datascience.ire.booleanretrieval.query.expression;

import java.util.HashSet;

/**
 * Created by Humayun on 4/10/2016.
 */
public class UnaryBooleanExpression implements IBooleanExpression {

    private IUnaryBooleanOperator unaryBooleanOperator;
    private IBooleanExpression booleanExpression;

    public boolean evaluate(HashSet<String> dictionary) {
        return unaryBooleanOperator.evaluate(booleanExpression, dictionary);
    }

    public IUnaryBooleanOperator getUnaryBooleanOperator() {
        return unaryBooleanOperator;
    }

    public void setUnaryBooleanOperator(IUnaryBooleanOperator unaryBooleanOperator) {
        this.unaryBooleanOperator = unaryBooleanOperator;
    }

    public IBooleanExpression getBooleanExpression() {
        return booleanExpression;
    }

    public void setBooleanExpression(IBooleanExpression booleanExpression) {
        this.booleanExpression = booleanExpression;
    }

    @Override
    public String toString() {
        return (unaryBooleanOperator == null ? "null" : unaryBooleanOperator.toString())
                + " "
                + (booleanExpression == null ? "null" : booleanExpression.toString());
    }
}
