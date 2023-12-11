package bj.ine.TaskManagement.repositories;

import bj.ine.TaskManagement.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
