package bj.ine.TaskManagement.repositories;

import bj.ine.TaskManagement.entities.Role;
import bj.ine.TaskManagement.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
//    @Query("SELECT r FROM Role r WHERE r.name IN :roleNames")
    List<Role> findByNameIn(List<RoleName> roleNames);

    @Query("SELECT r FROM Role r")
    List<Role> getAllRoles();
}
