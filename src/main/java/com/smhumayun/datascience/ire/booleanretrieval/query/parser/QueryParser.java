package com.smhumayun.datascience.ire.booleanretrieval.query.parser;

import com.smhumayun.datascience.ire.booleanretrieval.query.expression.IBooleanExpression;
import com.smhumayun.datascience.ire.booleanretrieval.query.parser.antlr4.BooleanRetrievalQueryLanguageListenerImpl;
import com.smhumayun.datascience.ire.booleanretrieval.query.parser.antlr4.generated.BooleanRetrievalQueryLanguageLexer;
import com.smhumayun.datascience.ire.booleanretrieval.query.parser.antlr4.generated.BooleanRetrievalQueryLanguageParser;
import org.antlr.v4.runtime.CaseInsensitiveInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.HashSet;

/**
 * Created by Humayun on 4/3/2016.
 */
public class QueryParser {

    private IBooleanExpression booleanExpression;

    public void parse (String query) {
        try {
            BooleanRetrievalQueryLanguageLexer lexer = new BooleanRetrievalQueryLanguageLexer(new CaseInsensitiveInputStream(query.toLowerCase()));
            BooleanRetrievalQueryLanguageParser parser = new BooleanRetrievalQueryLanguageParser(new CommonTokenStream(lexer));
            BooleanRetrievalQueryLanguageListenerImpl booleanRetrievalQueryLanguageListener = new BooleanRetrievalQueryLanguageListenerImpl();
            parser.addParseListener(booleanRetrievalQueryLanguageListener);
            parser.parse();
            booleanExpression = booleanRetrievalQueryLanguageListener.getOperand();
            System.out.println("PARSED QUERY: " + booleanExpression + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean match (HashSet<String> dictionary) {
        boolean matched = false;
        try {
            if(dictionary != null && dictionary.size() > 0) {
                matched = booleanExpression.evaluate(dictionary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matched;
    }

}