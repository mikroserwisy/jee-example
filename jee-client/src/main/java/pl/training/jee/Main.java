package pl.training.jee;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import pl.training.jee.rest.UserDto;
import pl.training.shop.payments.TimeProvider;

import javax.naming.NamingException;
import javax.ws.rs.client.Entity;
import java.util.Map;

public class Main {

    private static final String EXECUTOR_JNDI_NAME = "java:/jee-1.0-SNAPSHOT/SingleThreadExecutor!pl.training.jee.Executor";
    private static final String TOPIC_CONNECTION_FACTORY_JNDI_NAME = "jms/RemoteConnectionFactory";
    private static final String TOPIC_JNDI_NAME = "jms/topic/Training";
    private static final String USERS_RESOURCE = "http://localhost:8080/jee-1.0-SNAPSHOT/api/users";

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

     /*   var restClient = new ResteasyClientBuilderImpl()
                .register(BinaryMapper.class)
                .build();
        var resource = restClient.target(USERS_RESOURCE);

        var userDto = new UserDto();
        userDto.setFullName("Marek Nowak");
        var response = resource.request()
                .accept(BinaryMapper.MEDIA_TYPE)
                //.accept(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(userDto, BinaryMapper.MEDIA_TYPE));
                //.post(Entity.entity(userDto, MediaType.APPLICATION_XML));
        System.out.println("Status: " + response.getStatus());
        System.out.println(response.readEntity(UserDto.class));*/

      /*  TimeProvider timeProvider = proxyFactory.createProxy("java:jboss/exported/jee-1.0-SNAPSHOT/SystemTimeProvider!pl.training.shop.payments.TimeProvider");
        System.out.println(timeProvider.getTimestamp());*/

    }

}