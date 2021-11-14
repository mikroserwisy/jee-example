package pl.training.jee.cdi;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class CdiTest {

    @PostConstruct
    public void start() {
        var car = new Car();
        car.go();
    }

}
