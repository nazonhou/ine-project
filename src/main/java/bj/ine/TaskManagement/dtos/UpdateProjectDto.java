package bj.ine.TaskManagement.dtos;

import bj.ine.TaskManagement.constraints.HasProfile;
import bj.ine.TaskManagement.constraints.IsProjectNameExists;
import bj.ine.TaskManagement.constraints.IsUser;
import bj.ine.TaskManagement.enums.RoleName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class UpdateProjectDto {
    @NotBlank
    @IsProjectNameExists(creating = false)
    private String name;

    private String description;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime deadline;

    @NotNull
    @IsUser
    @HasProfile(roleName = RoleName.ADMIN)
    private Long managerId;
}
