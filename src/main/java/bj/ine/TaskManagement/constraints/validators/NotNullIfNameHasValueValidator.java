package bj.ine.TaskManagement.constraints.validators;

import bj.ine.TaskManagement.constraints.NotNullIfAnotherFieldHasValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.InvocationTargetException;

/**
 * Implementation of {@link NotNullIfAnotherFieldHasValue} validator.
 **/
public class NotNullIfNameHasValueValidator implements ConstraintValidator<NotNullIfAnotherFieldHasValue, Object> {
    private String fieldName;
    private String expectedFieldValue;
    private String dependFieldName;

    @Override
    public void initialize(NotNullIfAnotherFieldHasValue constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        fieldName = constraintAnnotation.fieldName();
        expectedFieldValue = constraintAnnotation.fieldValue();
        dependFieldName = constraintAnnotation.dependFieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(fieldName);
        Object dependFieldValue = new BeanWrapperImpl(value).getPropertyValue(dependFieldName);

        if (expectedFieldValue.equals(fieldValue) && dependFieldValue == null) {
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addNode(dependFieldName)
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
}
