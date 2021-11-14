package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

@Log
public class MessageConsumer {

    public void onMessage(@Observes(notifyObserver = Reception.ALWAYS) String message) {
        log.info("Message: " + message);
    }

}
