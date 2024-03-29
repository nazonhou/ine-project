package bj.ine.TaskManagement.controllers;

import bj.ine.TaskManagement.dtos.CreateProjectDto;
import bj.ine.TaskManagement.dtos.UpdateProjectDto;
import bj.ine.TaskManagement.entities.projections.ProjectDto;
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
    public ResponseEntity<Page<ProjectDto>> getProjects(
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(defaultValue = "10") String size
    ) {
        Pageable pageable = PageRequest.of(
                Integer.parseInt(page),
                Integer.parseInt(size)
        );

        return new ResponseEntity<>(projectService.getProjects(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ProjectDto getProject(
            @PathVariable Long id
    ) {
        return projectService.getProject(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProject(
            @Valid @RequestBody UpdateProjectDto dto,
            @PathVariable Long id
    ) {
        projectService.updateProject(id, dto);

        return new ResponseEntity<>(
                "Project updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {

        projectService.deleteProject(id);

        return new ResponseEntity<>(
                "Project deleted successfully",
                HttpStatus.OK
        );
    }

}
