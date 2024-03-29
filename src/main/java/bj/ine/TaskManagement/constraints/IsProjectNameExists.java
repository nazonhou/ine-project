package bj.ine.TaskManagement.constraints;

import bj.ine.TaskManagement.constraints.validators.IsProjectNameExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = IsProjectNameExistsValidator.class)
@Documented
public @interface IsProjectNameExists {
    String message() default "The project name is already used";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean creating() default true;
}
