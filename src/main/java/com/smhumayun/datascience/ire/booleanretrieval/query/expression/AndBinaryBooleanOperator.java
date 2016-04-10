package com.smhumayun.datascience.ire.booleanretrieval.query.expression;

import java.util.HashSet;

/**
 * Created by Humayun on 4/10/2016.
 */
public class AndBinaryBooleanOperator implements IBinaryBooleanOperator {

    public static final String TEXT = "AND";
    public static final AndBinaryBooleanOperator INSTANCE = new AndBinaryBooleanOperator();

    private AndBinaryBooleanOperator() {
    }

    public boolean evaluate(IBooleanExpression leftBooleanExpression, IBooleanExpression rightBooleanExpression, HashSet<String> dictionary) {
        return leftBooleanExpression.evaluate(dictionary) && rightBooleanExpression.evaluate(dictionary);
    }

    @Override
    public String toString() {
        return TEXT;
    }
}
