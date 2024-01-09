package bj.ine.TaskManagement.services.impl;

import bj.ine.TaskManagement.dtos.CreateProjectDto;
import bj.ine.TaskManagement.dtos.UpdateProjectDto;
import bj.ine.TaskManagement.entities.Project;
import bj.ine.TaskManagement.entities.User;
import bj.ine.TaskManagement.entities.projections.ProjectDto;
import bj.ine.TaskManagement.exceptions.CustomEntityNotFoundException;
import bj.ine.TaskManagement.repositories.ProjectRepository;
import bj.ine.TaskManagement.repositories.UserRepository;
import bj.ine.TaskManagement.services.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectServiceImpl(
            ProjectRepository projectRepository,
            UserRepository userRepository
    ) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createProject(CreateProjectDto dto) {

        Optional<User> manager = userRepository.findById(dto.getManagerId());

        Project project = Project.builder()
                .createdAt(LocalDateTime.now())
                .name(dto.getName())
                .description(dto.getDescription())
                .deadline(dto.getDeadline())
                .manager(manager.get())
                .build();

        projectRepository.save(project);
    }

    @Override
    public Page<ProjectDto> getProjects(Pageable pageable) {
        return projectRepository.findProjectsWithManager(pageable);
    }

    @Override
    public ProjectDto getProject(Long id) {
        Optional<ProjectDto> project = projectRepository.findProjectById(id);
        if (project.isPresent()) {
            return project.get();
        }
        throw new CustomEntityNotFoundException("Project");
    }

    @Override
    public void updateProject(Long id, UpdateProjectDto dto) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if (optionalProject.isEmpty()) {
            throw new CustomEntityNotFoundException("Project");
        }

        Project project = optionalProject.get();

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setDeadline(dto.getDeadline());
        project.setManager(
                userRepository.findById(dto.getManagerId())
                        .get()
        );
        project.setUpdatedAt(LocalDateTime.now());

        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if (optionalProject.isEmpty()) {
            throw new CustomEntityNotFoundException("Project");
        }

        projectRepository.deleteById(id);
    }

}
