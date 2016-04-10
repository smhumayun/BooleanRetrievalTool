package com.smhumayun.datascience.ire.booleanretrieval.model;

import java.net.URI;

/**
 * Created by Humayun on 4/3/2016.
 */
public class Document {

    private Integer index;
    private String name;
    private URI uri;
    private String content;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
