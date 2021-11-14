package pl.training.jee.cdi;

import lombok.extern.java.Log;

@Log
public class VehicleLogger {

    public void logBeforeGo() {
        log.info("Before go");
    }


    public void logAfterGo() {
        log.info("After go");
    }

}
