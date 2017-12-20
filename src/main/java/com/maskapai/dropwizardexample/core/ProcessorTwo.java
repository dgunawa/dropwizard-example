package com.maskapai.dropwizardexample.core;

public class ProcessorTwo implements DefaultProcessor{
    @Override
    public String getContent() {
        return "This is processor Two - 2";
    }
}
