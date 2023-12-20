package bj.ine.TaskManagement.exceptions;

public class CustomEntityNotFoundException extends RuntimeException {
    public CustomEntityNotFoundException(String entity) {
        super(entity + " not found");
    }
}
