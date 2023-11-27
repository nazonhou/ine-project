package bj.ine.TaskManagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleName {
    ADMIN("ADMIN"), PROJECT_MANAGER("PROJECT_MANAGER"), NORMAL("NORMAL");
    private String name;
}
