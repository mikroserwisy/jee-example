package pl.training.jee;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.Map;

@Log
@Stateful
public class SingleThreadExecutor implements Executor {


    @Override
    public void add(Map<String, String> data) {
        log.info("New data: " + data);
    }

    @Remove
    @Override
    public void execute() {
       log.info("Executing...");
    }

    @PostConstruct
    public void onCreate() {
        log.info(getClass().getSimpleName() + " is created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info(getClass().getSimpleName() + " is shutting down");
    }

    @PrePassivate
    public void prePassivate() {
        log.info(getClass().getSimpleName() + " is passivated");
    }

    @PostActivate
    public void postActivate() {
        log.info(getClass().getSimpleName() + " is activated");
    }

}
