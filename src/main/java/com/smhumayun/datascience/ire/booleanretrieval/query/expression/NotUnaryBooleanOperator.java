package com.smhumayun.datascience.ire.booleanretrieval.query.expression;

import java.util.HashSet;

/**
 * Created by Humayun on 4/10/2016.
 */
public class NotUnaryBooleanOperator implements IUnaryBooleanOperator {

    public static final String TEXT = "NOT";
    public static final NotUnaryBooleanOperator INSTANCE = new NotUnaryBooleanOperator();

    private NotUnaryBooleanOperator() {
    }

    public boolean evaluate(IBooleanExpression booleanExpression, HashSet<String> dictionary) {
        return !booleanExpression.evaluate(dictionary);
    }

    @Override
    public String toString() {
        return TEXT;
    }
}
