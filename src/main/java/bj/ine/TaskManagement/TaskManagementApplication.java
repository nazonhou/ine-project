package bj.ine.TaskManagement;

import bj.ine.TaskManagement.entities.Role;
import bj.ine.TaskManagement.entities.User;
import bj.ine.TaskManagement.enums.RoleName;
import bj.ine.TaskManagement.repositories.RoleRepository;
import bj.ine.TaskManagement.repositories.UserRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@Log
public class TaskManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
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
        };
    }

}
