package bj.ine.TaskManagement.dtos;

import bj.ine.TaskManagement.constraints.HasProfile;
import bj.ine.TaskManagement.constraints.IsProjectNameExists;
import bj.ine.TaskManagement.constraints.IsUser;
import bj.ine.TaskManagement.constraints.NotNullIfAnotherFieldHasValue;
import bj.ine.TaskManagement.enums.RoleName;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNullIfAnotherFieldHasValue(
        fieldName = "name",
        fieldValue = "project1",
        dependFieldName = "description",
        message = "Required when name equals project1"
)
public class CreateProjectDto {
    @NotBlank
    @IsProjectNameExists
    private String name;

    private String description;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime deadline;

    @NotNull
    @IsUser
    @HasProfile(roleName = RoleName.ADMIN)
    private Long managerId;

    @NotEmpty
    private List<@Size(min = 5) String> tags;
}
