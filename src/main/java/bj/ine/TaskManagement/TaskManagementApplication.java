package bj.ine.TaskManagement;

import bj.ine.TaskManagement.entities.Project;
import bj.ine.TaskManagement.entities.Role;
import bj.ine.TaskManagement.entities.User;
import bj.ine.TaskManagement.enums.RoleName;
import bj.ine.TaskManagement.repositories.ProjectRepository;
import bj.ine.TaskManagement.repositories.RoleRepository;
import bj.ine.TaskManagement.repositories.UserRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@Log
public class TaskManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            RoleRepository roleRepository,
            UserRepository userRepository,
            ProjectRepository projectRepository
    ) {
        return args -> {
            Role admin = new Role();
            admin.setName(RoleName.ADMIN);
            admin.setDescription("L'administrateur de la plateforme");
            roleRepository.save(admin);

            Role projectManager = Role.builder()
                    .name(RoleName.PROJECT_MANAGER)
                    .description("Un chef de projet")
                    .build();
            roleRepository.save(projectManager);

            Role normal = Role.builder()
                    .name(RoleName.NORMAL)
                    .description("Un utilisateur normal")
                    .build();
            roleRepository.save(normal);

            User manager = User.builder()
                    .name("Manager")
                    .roles(List.of(projectManager))
                    .email("manager@gmail.com")
                    .phoneNumber("+22940404040")
                    .build();
            userRepository.save(manager);

            User administrator = User.builder()
                    .name("Administrator")
                    .roles(List.of(admin))
                    .email("admin@gmail.com")
                    .phoneNumber("+22940404041")
                    .build();
            userRepository.save(administrator);

            for (int i = 0; i < 20; i++) {
                Project project = Project.builder()
                        .name("Project_" + (i + 1))
                        .manager(manager)
                        .description("Description of project " + (i + 1))
                        .deadline(LocalDateTime.now()
                                .plusDays(new Random().nextLong(5, 11)))
                        .build();
                projectRepository.save(project);
            }
        };
    }

}
