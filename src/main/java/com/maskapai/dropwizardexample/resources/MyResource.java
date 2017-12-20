package com.maskapai.dropwizardexample.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.maskapai.dropwizardexample.core.ModuleOne;
import com.maskapai.dropwizardexample.core.ModuleTwo;
import com.maskapai.dropwizardexample.core.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MyResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        Injector injector;
        System.out.println(value);
        switch (value) {
            case "Hello, one!":
                injector = Guice.createInjector(new ModuleOne());
                break;
            case "Hello, two!":
                injector = Guice.createInjector(new ModuleTwo());
                break;
            default:
                injector = Guice.createInjector(new ModuleOne());
                break;
        }
        return injector.getInstance(Saying.class);

//        Saying saying;
//        System.out.println(value);
//        switch (value) {
//            case "Hello, one!":
//                saying = new Saying(new ProcessorOne());
//                break;
//            case "Hello, two!":
//                saying = new Saying(new ProcessorTwo());
//                break;
//            default:
//                saying = new Saying(new ProcessorOne());
//                break;
//        }
//        return saying;
    }
}
