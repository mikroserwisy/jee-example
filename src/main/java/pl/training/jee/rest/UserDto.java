package pl.training.jee.rest;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class UserDto {

    @XmlTransient
    private String id;
    @XmlElement(name = "full-name")
    @Length(max = 25)
    @NotBlank
    @Pattern(regexp = "[a-zA-Z\\s]+")
    private String fullName;

}
