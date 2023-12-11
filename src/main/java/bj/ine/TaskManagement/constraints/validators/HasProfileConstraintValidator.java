package bj.ine.TaskManagement.constraints.validators;

import bj.ine.TaskManagement.constraints.HasProfile;
import bj.ine.TaskManagement.entities.User;
import bj.ine.TaskManagement.enums.RoleName;
import bj.ine.TaskManagement.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class HasProfileConstraintValidator implements
        ConstraintValidator<HasProfile, Long> {
    private RoleName roleName;

    private final UserRepository userRepository;

    public HasProfileConstraintValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(HasProfile constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.roleName = constraintAnnotation.roleName();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<User> user = userRepository.findUserByIdAndRole(value, roleName);
        return user.isPresent();
    }
}
