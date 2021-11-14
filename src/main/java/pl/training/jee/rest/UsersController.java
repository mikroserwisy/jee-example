package pl.training.jee.rest;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
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

    @PUT
    @Path("{id:\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}}")
    public UserDto update(@PathParam("id") String id, @Valid UserDto userDto) {
        var user = mapper.toModel(userDto);
        user.setId(id);
        return mapper.toUserDto(usersService.update(user));
    }

    @DELETE
    @Path("{id:\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}}")
    public Response deleteById(@PathParam("id") String id) {
        usersService.deleteById(id);
        return Response.noContent().build();
    }

    private URI getLocation(String id) {
        return uriInfo.getAbsolutePathBuilder().path(id).build();
    }

}
