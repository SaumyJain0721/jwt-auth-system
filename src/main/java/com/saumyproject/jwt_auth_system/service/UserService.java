package com.saumyproject.jwt_auth_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saumyproject.jwt_auth_system.dto.LoginResponse;
import com.saumyproject.jwt_auth_system.dto.RegisterRequest;
import com.saumyproject.jwt_auth_system.dto.UserResponse;
import com.saumyproject.jwt_auth_system.entity.Role;
import com.saumyproject.jwt_auth_system.entity.User;
import com.saumyproject.jwt_auth_system.repository.UserRepository;
import com.saumyproject.jwt_auth_system.security.JwtService;;

@Service
public class UserService {
    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    
    public User registerUser(RegisterRequest request) {

        Role role = Role.USER;

        if (userRepository.count() == 0) {
            role = Role.ADMIN;
        }

        User user = User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(role)
            .build();

        return userRepository.save(user);
    }
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(user -> new UserResponse(user.getId(), user.getName()))
            .toList();
    }

    public LoginResponse loginUser(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}