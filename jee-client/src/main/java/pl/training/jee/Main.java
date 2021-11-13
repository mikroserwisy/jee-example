package pl.training.jee;

import javax.naming.NamingException;
import java.util.Map;

public class Main {

    private static final String EXECUTOR_JNDI_NAME = "java:/jee-1.0-SNAPSHOT/SingleThreadExecutor!pl.training.jee.Executor";

    public static void main(String[] args) throws NamingException {
        var proxyFactory = new ProxyFactory();
        Executor executor = proxyFactory.createProxy(EXECUTOR_JNDI_NAME);
        executor.add(Map.of("key", "value"));
        //executor.execute();
        executor.add(Map.of("key", "value"));
    }

}