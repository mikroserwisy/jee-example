package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Log
@Decorator
public abstract class SmartCar implements Vehicle {

    @Delegate
    @Inject
    private Car car;

    @Override
    public void go() {
        log.info("Lights on");
        car.go();
    }

}
