package com.smhumayun.datascience.ire.booleanretrieval.query.expression;

import java.util.HashSet;

/**
 * Created by Humayun on 4/10/2016.
 */
public class NestedBooleanExpression implements IBooleanExpression {

    private IBooleanExpression nestedBooleanExpression;

    public boolean evaluate(HashSet<String> dictionary) {
        return nestedBooleanExpression.evaluate(dictionary);
    }

    public IBooleanExpression getNestedBooleanExpression() {
        return nestedBooleanExpression;
    }

    public void setNestedBooleanExpression(IBooleanExpression nestedBooleanExpression) {
        this.nestedBooleanExpression = nestedBooleanExpression;
    }

    @Override
    public String toString() {
        return " ( " + (nestedBooleanExpression == null ? "null" : nestedBooleanExpression.toString()) + " ) ";
    }
}
