package pl.training.jee.cdi;

import lombok.extern.java.Log;

@Log
public class Car implements Vehicle {

    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void go() {
        engine.start();
    }

}
