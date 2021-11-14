package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.enterprise.inject.Alternative;

@Log
@MotorType("diesel")
@Alternative
public class DieselEngine implements Engine {

    @Override
    public void start() {
        log.info("Engine STARTED klkelekleklekelek");
    }

}
