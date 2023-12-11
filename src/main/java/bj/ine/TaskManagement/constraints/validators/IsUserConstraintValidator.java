package bj.ine.TaskManagement.constraints.validators;

import bj.ine.TaskManagement.constraints.IsUser;
import bj.ine.TaskManagement.entities.User;
import bj.ine.TaskManagement.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class IsUserConstraintValidator implements
        ConstraintValidator<IsUser, Long> {

    private final UserRepository userRepository;

    public IsUserConstraintValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(IsUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<User> user = userRepository.findById(value);
        return user.isPresent();
    }
}
