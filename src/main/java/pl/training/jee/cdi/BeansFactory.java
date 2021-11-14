package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.Random;
import java.util.logging.Logger;

@Log
@ApplicationScoped
public class BeansFactory {

    private final Random random = new Random();

    //@Singleton
    @RandomValue
    @Produces
    public Integer randomInt() {
        return random.nextInt(101);
    }

    @RandomValue
    @Produces
    public String randomText(@RandomValue Integer number) {
        return "Text" + number;
    }

    public void destroyRandom(@Disposes @RandomValue String value) {
        log.info("Destroying: " + value);
    }

    public void destroyRandom(@Disposes @RandomValue Integer value) {
        log.info("Destroying: " + value);
    }

    @Produces
    public Logger logger(InjectionPoint injectionPoint) {
        var className = injectionPoint.getMember().getDeclaringClass().getName();
        return Logger.getLogger(className);
    }

}
