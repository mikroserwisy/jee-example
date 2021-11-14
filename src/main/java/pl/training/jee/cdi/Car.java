package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;


@RequestScoped
@Log
public class Car implements Vehicle {

    private final Engine engine;

    @Inject
    public Car(@Any Engine engine) {
        this.engine = engine;
    }

    @LogInfo
    @Override
    public void go() {
        engine.start();
    }

    @PostConstruct
    public void onCreate() {
        log.info(getClass().getSimpleName() + " is created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info(getClass().getSimpleName() + " is shutting down");
    }


}
