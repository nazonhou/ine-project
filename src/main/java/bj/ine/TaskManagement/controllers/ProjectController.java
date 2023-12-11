package bj.ine.TaskManagement.controllers;

import bj.ine.TaskManagement.dtos.CreateProjectDto;
import bj.ine.TaskManagement.entities.Project;
import bj.ine.TaskManagement.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/projects")
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

    @GetMapping
    public ResponseEntity<Page<Project>> getProjects(
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(defaultValue = "10") String size
    ) {
        Pageable pageable = PageRequest.of(
                Integer.parseInt(page),
                Integer.parseInt(size)
        );

        return new ResponseEntity<>(projectService.getProjects(pageable), HttpStatus.OK);
    }

}
