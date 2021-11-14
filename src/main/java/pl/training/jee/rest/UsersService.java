package pl.training.jee.rest;

import lombok.Setter;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UsersService {

    @Setter
    @EJB
    private UsersRepository usersRepository;

    public User add(User user) {
        return usersRepository.save(user);
    }

    public User getById(String id) {
        return usersRepository.getById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public void deleteById(String id) {
        usersRepository.deleteById(id);
    }

    public User update(User user) {
        getById(user.getId());
        return usersRepository.update(user);
    }

}
