package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.enterprise.inject.Alternative;

@Log
@MotorType("petrol")
@Alternative
public class PetrolEngine implements Engine {

    @Override
    public void start() {
        log.info("Engine STARTED");
    }

}
