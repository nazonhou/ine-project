package bj.ine.TaskManagement.entities;

import bj.ine.TaskManagement.converters.RoleNameConverter;
import bj.ine.TaskManagement.enums.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    @Convert(converter = RoleNameConverter.class)
    private RoleName name;

    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
