package com.maskapai.dropwizardexample.core;

public class ProcessorOne implements DefaultProcessor {
    @Override
    public String getContent() {
        return "This is processor One - 1";
    }
}
