package bj.ine.TaskManagement.constraints.validators;

import bj.ine.TaskManagement.constraints.IsValidProjectId;
import bj.ine.TaskManagement.repositories.ProjectRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsValidProjectIdValidator implements
        ConstraintValidator<IsValidProjectId, Long> {

    private final ProjectRepository projectRepository;

    public IsValidProjectIdValidator(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void initialize(IsValidProjectId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return projectRepository.findById(value).isPresent();
    }
}
