package bj.ine.TaskManagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Project extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
}
