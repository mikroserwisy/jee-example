package pl.training.jee.rest;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class InMemoryUsersRepository implements UsersRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public User save(User user) {
        var id = UUID.randomUUID().toString();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    @Override
    public Optional<User> getById(String id) {
        return Optional.ofNullable(users.get(id));
    }

}
