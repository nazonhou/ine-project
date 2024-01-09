package bj.ine.TaskManagement.repositories;

import bj.ine.TaskManagement.entities.Project;
import bj.ine.TaskManagement.entities.projections.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p")
    Page<ProjectDto> findProjectsWithManager(Pageable pageable);

    @Query("SELECT p FROM Project p WHERE p.id = :id")
    Optional<ProjectDto> findProjectById(Long id);

    Optional<Project> findByName(String name);
}
