package pl.training.jee.rest;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("users")
public class UsersController {

    @EJB
    private UsersService usersService;
    @EJB
    private UsersModelMapper mapper;

    @POST
    public Response createUser(UserDto userDto) {
        var user = mapper.toModel(userDto);
        usersService.add(user);
        return Response.ok().build();
    }

}
