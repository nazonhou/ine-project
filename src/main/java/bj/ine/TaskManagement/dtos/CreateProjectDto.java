package bj.ine.TaskManagement.dtos;

import bj.ine.TaskManagement.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectDto {
    @NotBlank
    private String name;

    private String description;

    @Future
    private LocalDateTime deadline;

    @NotNull
    private Long managerId;
}
