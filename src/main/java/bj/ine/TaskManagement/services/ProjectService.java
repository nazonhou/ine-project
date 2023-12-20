package bj.ine.TaskManagement.services;

import bj.ine.TaskManagement.dtos.CreateProjectDto;
import bj.ine.TaskManagement.entities.projections.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    void createProject(CreateProjectDto dto);

    Page<ProjectDto> getProjects(Pageable pageable);

    ProjectDto getProject(Long id);
}
