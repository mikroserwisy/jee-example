package pl.training.jee.cdi;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class CdiTest {

    public Vehicle vehicle() {
        var logger = new VehicleLogger();
        var car = new Car(new DieselEngine());
        return  new CarProxy(car, logger);
    }

    @PostConstruct
    public void start() {
        var vehicle = vehicle();
        vehicle.go();
    }

}
