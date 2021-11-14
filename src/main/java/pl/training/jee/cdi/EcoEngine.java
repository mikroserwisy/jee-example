package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.enterprise.inject.Alternative;

@Log
@MotorType("eco")
@Alternative
public class EcoEngine implements Engine {

    @Override
    public void start() {
        log.info("Eco engine STARTED");
    }

}
