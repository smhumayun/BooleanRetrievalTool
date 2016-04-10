package com.smhumayun.datascience.ire.booleanretrieval.query.expression;

import java.util.HashSet;

/**
 * Created by Humayun on 4/10/2016.
 */
public class OrBinaryBooleanOperator implements IBinaryBooleanOperator {

    public static final String TEXT = "OR";
    public static final OrBinaryBooleanOperator INSTANCE = new OrBinaryBooleanOperator();

    private OrBinaryBooleanOperator() {
    }

    public boolean evaluate(IBooleanExpression leftBooleanExpression, IBooleanExpression rightBooleanExpression, HashSet<String> dictionary) {
        return leftBooleanExpression.evaluate(dictionary) || rightBooleanExpression.evaluate(dictionary);
    }

    @Override
    public String toString() {
        return TEXT;
    }
}
