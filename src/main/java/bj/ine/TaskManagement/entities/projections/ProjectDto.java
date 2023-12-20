package bj.ine.TaskManagement.entities.projections;

import java.time.LocalDateTime;

public interface ProjectDto {
    Long getId();

    String getName();

    String getDescription();

    LocalDateTime getDeadline();

    UserDto getManager();
}
