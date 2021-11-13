package pl.training.jee.rest;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class InMemoryUsersRepository implements UsersRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public User save(User user) {
        users.put(UUID.randomUUID().toString(), user);
        return user;
    }

}
