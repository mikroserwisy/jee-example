package pl.training.jee;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Log
@Stateless
public class ServiceStatusProvider implements StatusProvider {

    @Override
    public String getStatus(String name) {
        return name != null ? "OK" : "UNKNOWN";
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
