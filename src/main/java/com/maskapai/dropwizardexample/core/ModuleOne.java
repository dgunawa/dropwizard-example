package com.maskapai.dropwizardexample.core;

import com.google.inject.AbstractModule;

public class ModuleOne extends AbstractModule {
    @Override
    protected void configure() {
        bind(DefaultProcessor.class).to(ProcessorOne.class);
    }
}

