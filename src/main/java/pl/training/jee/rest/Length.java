package pl.training.jee.rest;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LengthValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {

    String message() default "Invalid length";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 3;

    int max() default 20;

}
