package com.maskapai.dropwizardexample;

import com.maskapai.dropwizardexample.health.TemplateHealthCheck;
import com.maskapai.dropwizardexample.resources.MyResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<MyConfiguration> {
    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public String getName() {
        return "Dropwizard Example";
    }

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
//        Injector injector = Guice.createInjector(new BillingModule());
    }

    @Override
    public void run(MyConfiguration configuration,
                    Environment environment) {
        final MyResource resource = new MyResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
