package com.smhumayun.datascience.ire.booleanretrieval.query.expression;

import java.util.HashSet;

/**
 * Created by Humayun on 4/10/2016.
 */
public class Term implements IBooleanExpression {

    private String term;

    public Term(String term) {
        this.term = term;
    }

    public boolean evaluate(HashSet<String> dictionary) {
        return dictionary.contains(this.term);
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return this.term;
    }
}
