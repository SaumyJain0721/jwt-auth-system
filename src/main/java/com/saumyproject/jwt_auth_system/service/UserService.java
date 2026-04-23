package com.saumyproject.jwt_auth_system.service;
import com.saumyproject.jwt_auth_system.dto.RegisterRequest;
import com.saumyproject.jwt_auth_system.dto.UserResponse;
import com.saumyproject.jwt_auth_system.entity.Role;
import com.saumyproject.jwt_auth_system.entity.User;
import com.saumyproject.jwt_auth_system.repository.UserRepository;
import com.saumyproject.jwt_auth_system.security.JwtService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private JwtService jwtService;
    @Autowired   
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

   public User registerUser(RegisterRequest request) {

        User user = User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();

        return userRepository.save(user);
    }
    public String loginUser(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtService.generateToken(user.getEmail());
    }
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(user -> new UserResponse(user.getId(), user.getName()))
            .toList();
}
}
