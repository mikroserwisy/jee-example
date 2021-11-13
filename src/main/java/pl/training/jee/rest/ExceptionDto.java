package pl.training.jee.rest;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionDto {

    private LocalDateTime timestamp;
    private String description;

}
