package bj.ine.TaskManagement.constraints;

import bj.ine.TaskManagement.constraints.validators.IsUserConstraintValidator;
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
@Constraint(validatedBy = IsUserConstraintValidator.class)
@Documented
public @interface IsUser {
    String message() default "This is not a valid user";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
