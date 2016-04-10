package com.smhumayun.datascience.ire.booleanretrieval.model;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by Humayun on 4/3/2016.
 */
public class InvertedIndex extends TreeMap<String, List<Integer>> {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String term : this.keySet()) {
            sb.append(String.format("%1$-30s", term)).append(this.get(term)).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
