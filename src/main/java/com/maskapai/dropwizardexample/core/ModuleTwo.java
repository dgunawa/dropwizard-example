package com.maskapai.dropwizardexample.core;

import com.google.inject.AbstractModule;

public class ModuleTwo extends AbstractModule {
    @Override
    protected void configure() {
        bind(DefaultProcessor.class).to(ProcessorTwo.class);
    }
}
