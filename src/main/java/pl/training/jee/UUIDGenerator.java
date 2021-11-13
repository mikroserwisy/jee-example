package pl.training.jee;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.UUID;

@Log
@Startup
@Singleton
public class UUIDGenerator {

    @Lock(LockType.READ)
    public String getNext() {
        return UUID.randomUUID().toString();
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
