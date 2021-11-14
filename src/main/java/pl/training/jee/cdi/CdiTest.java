package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log
@Startup
@Singleton
public class CdiTest {

    @Inject
    private Vehicle vehicle;
   /* @Inject
    private Vehicle otherVehicle;*/
    @Inject
    private MessageProducer messageProducer;
    @RandomValue
    @Inject
    private int number;
    @RandomValue
    @Inject
    private String text;
    @Inject
    private Logger logger;

    @PostConstruct
    public void start() {
        vehicle.go();
        vehicle.printInfo();
        messageProducer.send("Hello CDI");
        log.info("Random number: " + number);
        log.info("Random text: " + text);
        logger.log(Level.INFO,  logger.getName());
    }

}
