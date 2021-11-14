package pl.training.jee.cdi;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class MessageProducer {

    @Inject
    private Event<String> eventEmitter;

    public void setEventEmitter(Event<String> eventEmitter) {
        this.eventEmitter = eventEmitter;
    }

    public void send(String message) {
        eventEmitter.fire(message);
    }

}
