package pl.training.jee.rest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;

import static java.util.stream.Collectors.joining;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    private static final String DESCRIPTION = "Validation exception: ";
    public static final String KEY_VALUE_SEPARATOR = ": ";
    public static final String ERROR_DELIMITER = ", ";

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        var response = new ExceptionDto();
        response.setTimestamp(LocalDateTime.now());
        response.setDescription(generateDescription(exception));
        return Response.status(BAD_REQUEST)
                .entity(response)
                .build();
    }

    private String generateDescription(ConstraintViolationException exception) {
        return DESCRIPTION + exception.getConstraintViolations().stream()
                .map(this::toViolationMessage)
                .collect(joining(ERROR_DELIMITER));
    }

    private String toViolationMessage(ConstraintViolation<?> violation) {
        return violation.getPropertyPath() + KEY_VALUE_SEPARATOR + violation.getMessage();
    }

}