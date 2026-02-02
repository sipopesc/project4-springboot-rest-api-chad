package com.luv2code.springboot.todos.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.todos.entity.Authority;
import com.luv2code.springboot.todos.entity.User;
import com.luv2code.springboot.todos.repository.UserRepository;
import com.luv2code.springboot.todos.response.UserResponse;

@Service
public class UserServiceImpl implements UserService {
        
        private final UserRepository userRepository;

        public UserServiceImpl(UserRepository theUserRepository) {
            userRepository = theUserRepository;
        }

        @Override
        @Transactional(readOnly = true)
        public UserResponse getUserInfo() throws Exception {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
                throw new Exception("Authentication required to get user info");
            }

            User user = (User) authentication.getPrincipal();
            return new UserResponse(
                user.getId(), 
                user.getFirstName() + " " + user.getLastName(), 
                user.getEmail(), 
                user.getAuthorities().stream().map(auth -> (Authority) auth).toList());
        }
}
