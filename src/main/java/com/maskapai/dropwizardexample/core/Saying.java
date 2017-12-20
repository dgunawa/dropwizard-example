package com.maskapai.dropwizardexample.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.Inject;

public class Saying {
    private long id;
    private DefaultProcessor defaultProcessor;

    public Saying() {
        // Jackson deserialization
    }

    @Inject
    public Saying(DefaultProcessor defaultProcessor) {
        this.defaultProcessor = defaultProcessor;
    }

//    @JsonProperty
//    public long getId() {
//        return id;
//    }

    @JsonProperty
    public String getContent() {
        return defaultProcessor.getContent();
    }
}
