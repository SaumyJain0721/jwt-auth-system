package com.saumyproject.jwt_auth_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saumyproject.jwt_auth_system.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}