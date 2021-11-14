package pl.training.jee.cdi;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class CdiTest {

    @Inject
    private Vehicle vehicle;
    @Inject
    private Vehicle otherVehicle;

    @PostConstruct
    public void start() {
        vehicle.go();
    }

}
