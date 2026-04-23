package com.saumyproject.jwt_auth_system.controller;

import com.saumyproject.jwt_auth_system.dto.LoginRequest;
import com.saumyproject.jwt_auth_system.dto.RegisterRequest;
import com.saumyproject.jwt_auth_system.dto.UserResponse;
import com.saumyproject.jwt_auth_system.entity.User;
import com.saumyproject.jwt_auth_system.service.UserService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.loginUser(request.getEmail(), request.getPassword());
    }
    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}
