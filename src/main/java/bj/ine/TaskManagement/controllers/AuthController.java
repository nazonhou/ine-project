package bj.ine.TaskManagement.controllers;

import bj.ine.TaskManagement.dtos.RegisterUserDto;
import bj.ine.TaskManagement.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
            @Valid @RequestBody RegisterUserDto dto
    ) {
        userService.registerUser(dto);
        return new ResponseEntity<>(
                "User registered successfully", HttpStatus.CREATED);
    }
}
