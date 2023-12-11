package bj.ine.TaskManagement.repositories;

import bj.ine.TaskManagement.entities.User;
import bj.ine.TaskManagement.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN u.roles r WHERE u.id = :id AND r.name = :roleName")
    Optional<User> findUserByIdAndRole(Long id, RoleName roleName);
}
