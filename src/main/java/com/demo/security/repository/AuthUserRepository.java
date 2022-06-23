package com.demo.security.repository;

import com.demo.security.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser,Integer> {
    AuthUser findByUserName(String username);
}

