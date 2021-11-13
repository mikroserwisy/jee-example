package pl.training.jee.rest;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("users")
public class UsersController {

    @EJB
    private UsersService usersService;
    @EJB
    private UsersModelMapper mapper;
    @Context
    private UriInfo uriInfo;

    @POST
    public Response createUser(@Valid UserDto userDto) {
        var user = mapper.toModel(userDto);
        var response = mapper.toUserDto(usersService.add(user));
        return Response.created(getLocation(response.getId()))
                .entity(response)
                .build();
    }

    @GET
    @Path("{id:\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}}")
    public UserDto getById(@PathParam("id") String id) {
        var user = usersService.getById(id);
        return mapper.toUserDto(user);
    }

    private URI getLocation(String id) {
        return uriInfo.getAbsolutePathBuilder().path(id).build();
    }

}
