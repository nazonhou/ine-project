package bj.ine.TaskManagement.services.impl;

import bj.ine.TaskManagement.dtos.CreateProjectDto;
import bj.ine.TaskManagement.entities.Project;
import bj.ine.TaskManagement.entities.User;
import bj.ine.TaskManagement.repositories.ProjectRepository;
import bj.ine.TaskManagement.repositories.UserRepository;
import bj.ine.TaskManagement.services.ProjectService;
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
}
