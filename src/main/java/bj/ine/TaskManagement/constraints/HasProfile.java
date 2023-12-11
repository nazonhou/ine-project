package bj.ine.TaskManagement.constraints;

import bj.ine.TaskManagement.constraints.validators.HasProfileConstraintValidator;
import bj.ine.TaskManagement.constraints.validators.IsUserConstraintValidator;
import bj.ine.TaskManagement.enums.RoleName;
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
@Constraint(validatedBy = HasProfileConstraintValidator.class)
@Documented
public @interface HasProfile {
    String message() default "Has not the expected profile";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    RoleName roleName();
}
