package com.smhumayun.datascience.ire.booleanretrieval.config;

/**
 * Created by Humayun on 4/3/2016.
 */
public class InputDocumentConfig {

    private String inputDocumentPath;
    private Integer inputDocumentIndex;

    public InputDocumentConfig() {
    }

    public InputDocumentConfig(String inputDocumentPath, Integer inputDocumentIndex) {
        this.inputDocumentPath = inputDocumentPath;
        this.inputDocumentIndex = inputDocumentIndex;
    }

    public String getInputDocumentPath() {
        return inputDocumentPath;
    }

    public void setInputDocumentPath(String inputDocumentPath) {
        this.inputDocumentPath = inputDocumentPath;
    }

    public Integer getInputDocumentIndex() {
        return inputDocumentIndex;
    }

    public void setInputDocumentIndex(Integer inputDocumentIndex) {
        this.inputDocumentIndex = inputDocumentIndex;
    }

}
