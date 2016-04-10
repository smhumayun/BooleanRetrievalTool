package com.smhumayun.datascience.ire.booleanretrieval.config;

import java.util.List;

/**
 * Created by Humayun on 4/3/2016.
 */
public class BooleanRetrievalToolConfig {

    private String searchQuery;
    private List<InputDocumentConfig> inputDocuments;

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public List<InputDocumentConfig> getInputDocuments() {
        return inputDocuments;
    }

    public void setInputDocuments(List<InputDocumentConfig> inputDocuments) {
        this.inputDocuments = inputDocuments;
    }
}
