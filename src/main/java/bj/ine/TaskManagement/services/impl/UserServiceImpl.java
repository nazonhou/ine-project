package bj.ine.TaskManagement.services.impl;

import bj.ine.TaskManagement.dtos.RegisterUserDto;
import bj.ine.TaskManagement.entities.Role;
import bj.ine.TaskManagement.entities.User;
import bj.ine.TaskManagement.enums.RoleName;
import bj.ine.TaskManagement.repositories.RoleRepository;
import bj.ine.TaskManagement.repositories.UserRepository;
import bj.ine.TaskManagement.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void registerUser(RegisterUserDto dto) {

        List<Role> initialRoles = roleRepository.findByNameIn(List.of(RoleName.NORMAL));

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .roles(initialRoles)
                .build();

        userRepository.save(user);
    }
}
