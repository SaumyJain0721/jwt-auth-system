package com.saumyproject.jwt_auth_system.dto;

public class LoginResponse {

    private String message;
    private String token;
    private Long id;
    private String name;

    public LoginResponse(String message, String token, Long id, String name) {
        this.message = message;
        this.token = token;
        this.id = id;
        this.name = name;
    }

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getMessage() { return message; }
    public String getToken() { return token; }
    public Long getId() { return id; }
    public String getName() { return name; }
}