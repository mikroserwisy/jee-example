package pl.training.jee.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {

    private static final String USER_NOT_FOUND_MESSAGE = "User not found";

    @Override
    public Response toResponse(UserNotFoundException exception) {
        var response = new ExceptionDto();
        response.setTimestamp(LocalDateTime.now());
        response.setDescription(USER_NOT_FOUND_MESSAGE);
        return Response.status(NOT_FOUND)
                .entity(response)
                .build();
    }

}
