package com.smhumayun.datascience.ire.booleanretrieval.query.expression;

import java.util.HashSet;

/**
 * Created by Humayun on 4/10/2016.
 */
public class BooleanLiteral implements IBooleanExpression {

    public static final BooleanLiteral TRUE = new BooleanLiteral(true);
    public static final BooleanLiteral FALSE = new BooleanLiteral(false);

    private boolean value;

    private BooleanLiteral(boolean value) {
        this.value = value;
    }

    public boolean evaluate(HashSet<String> dictionary) {
        return this.value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
