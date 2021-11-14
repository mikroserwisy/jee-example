package pl.training.jee.cdi;

import lombok.extern.java.Log;

@Log
public class DieselEngine implements Engine {

    @Override
    public void start() {
        log.info("Engine STARTED klkelekleklekelek");
    }

}
