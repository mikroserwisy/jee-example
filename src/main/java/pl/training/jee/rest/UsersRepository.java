package pl.training.jee.rest;

import java.util.Optional;

public interface UsersRepository {

    User save(User user);

    Optional<User> getById(String id);

    void deleteById(String id);

    User update(User user);

}
