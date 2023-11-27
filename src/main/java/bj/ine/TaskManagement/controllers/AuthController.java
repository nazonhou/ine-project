package bj.ine.TaskManagement.controllers;

import bj.ine.TaskManagement.dtos.RegisterUserDto;
import bj.ine.TaskManagement.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUserDto dto) {
        userService.registerUser(dto);
        return new ResponseEntity<>(
                "User registered successfully", HttpStatus.CREATED);
    }
}
