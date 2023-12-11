package bj.ine.TaskManagement.controllers;

import bj.ine.TaskManagement.dtos.CreateProjectDto;
import bj.ine.TaskManagement.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<String> createProject(
            @Valid @RequestBody CreateProjectDto dto
    ) {
        projectService.createProject(dto);

        return new ResponseEntity<>(
                "Project created successfully",
                HttpStatus.CREATED
        );
    }
}
