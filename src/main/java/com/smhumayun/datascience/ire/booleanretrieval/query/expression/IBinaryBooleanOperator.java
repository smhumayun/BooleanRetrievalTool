package com.smhumayun.datascience.ire.booleanretrieval.query.expression;

import java.util.HashSet;

/**
 * Created by Humayun on 4/10/2016.
 */
public interface IBinaryBooleanOperator {

    boolean evaluate (IBooleanExpression leftBooleanExpression, IBooleanExpression rightBooleanExpression, HashSet<String> dictionary);

}
