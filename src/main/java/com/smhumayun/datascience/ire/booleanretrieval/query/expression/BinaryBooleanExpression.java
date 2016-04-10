package com.smhumayun.datascience.ire.booleanretrieval.query.expression;

import java.util.HashSet;

/**
 * Created by Humayun on 4/10/2016.
 */
public class BinaryBooleanExpression implements IBooleanExpression {

    private IBinaryBooleanOperator binaryBooleanOperator;
    private IBooleanExpression leftBooleanExpression;
    private IBooleanExpression rightBooleanExpression;

    public boolean evaluate(HashSet<String> dictionary) {
        return binaryBooleanOperator.evaluate(leftBooleanExpression, rightBooleanExpression, dictionary);
    }

    public IBinaryBooleanOperator getBinaryBooleanOperator() {
        return binaryBooleanOperator;
    }

    public void setBinaryBooleanOperator(IBinaryBooleanOperator binaryBooleanOperator) {
        this.binaryBooleanOperator = binaryBooleanOperator;
    }

    public IBooleanExpression getLeftBooleanExpression() {
        return leftBooleanExpression;
    }

    public void setLeftBooleanExpression(IBooleanExpression leftBooleanExpression) {
        this.leftBooleanExpression = leftBooleanExpression;
    }

    public IBooleanExpression getRightBooleanExpression() {
        return rightBooleanExpression;
    }

    public void setRightBooleanExpression(IBooleanExpression rightBooleanExpression) {
        this.rightBooleanExpression = rightBooleanExpression;
    }

    @Override
    public String toString() {
        return (leftBooleanExpression == null ? "null" : leftBooleanExpression.toString())
                + " "
                + (binaryBooleanOperator == null ? "null" : binaryBooleanOperator.toString())
                + " "
                + (rightBooleanExpression == null ? "null" : rightBooleanExpression.toString());
    }
}
