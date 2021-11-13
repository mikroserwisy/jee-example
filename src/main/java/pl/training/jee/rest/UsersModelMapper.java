package pl.training.jee.rest;

import javax.ejb.Stateless;

@Stateless
public class UsersModelMapper {

    public static final String SEPARATOR = " ";

    public User toModel(UserDto userDto) {
        var elements = userDto.getFullName().split(SEPARATOR);
        var user = new User();
        user.setFirstName(elements[0]);
        user.setLastName(elements[1]);
        return user;
    }

    public UserDto toUserDto(User user) {
        var userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFirstName() + SEPARATOR + user.getLastName());
        return userDto;
    }

}
