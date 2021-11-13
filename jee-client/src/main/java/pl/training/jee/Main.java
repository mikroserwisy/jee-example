package pl.training.jee;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.NamingException;
import java.util.Map;

public class Main {

    private static final String EXECUTOR_JNDI_NAME = "java:/jee-1.0-SNAPSHOT/SingleThreadExecutor!pl.training.jee.Executor";
    private static final String TOPIC_CONNECTION_FACTORY_JNDI_NAME = "jms/RemoteConnectionFactory";
    private static final String TOPIC_JNDI_NAME = "jms/topic/Training";

    public static void main(String[] args) throws NamingException {
        var proxyFactory = new ProxyFactory();
        Executor executor = proxyFactory.createProxy(EXECUTOR_JNDI_NAME);
        executor.add(Map.of("key", "value"));
        //executor.execute();
        executor.add(Map.of("key", "value"));

        ConnectionFactory connectionFactory = proxyFactory.createProxy(TOPIC_CONNECTION_FACTORY_JNDI_NAME);
        Topic topic = proxyFactory.createProxy(TOPIC_JNDI_NAME);
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().send(topic, "Hello JMS!");
        }

    }

}