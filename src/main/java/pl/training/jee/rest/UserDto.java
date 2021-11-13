package pl.training.jee.rest;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {

    private String id;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String fullName;

}
