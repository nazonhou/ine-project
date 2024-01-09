package bj.ine.TaskManagement.constraints.validators;

import bj.ine.TaskManagement.constraints.IsProjectNameExists;
import bj.ine.TaskManagement.entities.Project;
import bj.ine.TaskManagement.repositories.ProjectRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;
import java.util.Optional;

public class IsProjectNameExistsValidator implements
        ConstraintValidator<IsProjectNameExists, String> {
    private final ProjectRepository projectRepository;
    private final HttpServletRequest request;
    private boolean creating;

    public IsProjectNameExistsValidator(ProjectRepository projectRepository, HttpServletRequest request) {
        this.projectRepository = projectRepository;
        this.request = request;
    }

    @Override
    public void initialize(IsProjectNameExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.creating = constraintAnnotation.creating();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Project> project = projectRepository.findByName(value);

        if (creating) {
            return project.isEmpty();
        }

        if (project.isEmpty()) {
            return true;
        }

        Map<String, String> pathVariables = (Map) request
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Long id = Long.parseLong(pathVariables.get("id"));

        return id == project.get().getId();
    }
}
