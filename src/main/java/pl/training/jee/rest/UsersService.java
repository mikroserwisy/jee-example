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

}
