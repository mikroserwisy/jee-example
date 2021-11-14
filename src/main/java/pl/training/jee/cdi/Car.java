package pl.training.jee.cdi;

import lombok.extern.java.Log;

@Log
public class Car {

    private final PetrolEngine engine = new PetrolEngine();

    public void go() {
        engine.start();
        log.info("================>>>>");
    }

}
