package com.luv2code.springboot.todos.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String extractUsername(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateToken(Map<String, Object> claims, UserDetails userDetails);
}
