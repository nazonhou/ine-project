package bj.ine.TaskManagement.converters;

import bj.ine.TaskManagement.enums.RoleName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class RoleNameConverter implements AttributeConverter<RoleName, String> {
    @Override
    public String convertToDatabaseColumn(RoleName attribute) {
        return attribute.getName();
    }
    @Override
    public RoleName convertToEntityAttribute(String dbData) {
        return Stream.of(RoleName.values())
                .filter(roleName -> roleName.getName().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
