package com.saumyproject.jwt_auth_system.service;
import com.saumyproject.jwt_auth_system.dto.RegisterRequest;
import com.saumyproject.jwt_auth_system.entity.Role;
import com.saumyproject.jwt_auth_system.entity.User;
import com.saumyproject.jwt_auth_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(RegisterRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword()) // ⚠️ encryption later
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }
}
