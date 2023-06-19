package com.blog.blogrestapi.service.serviceImpl.impl;


import com.blog.blogrestapi.entity.Role;
import com.blog.blogrestapi.entity.User;
import com.blog.blogrestapi.exception.BlogAPIException;
import com.blog.blogrestapi.payload.LoginDto;
import com.blog.blogrestapi.payload.RegisterDto;
import com.blog.blogrestapi.repository.RoleRepository;
import com.blog.blogrestapi.repository.UserRepository;
import com.blog.blogrestapi.service.serviceImpl.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    public AuthServiceImpl(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }

    @Override
    public String login(LoginDto loginDto) {

       Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
           loginDto.getUsernameOrEmail(), loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "user is logged-in Successfully!.";
    }


    @Override
    public String register(RegisterDto registerDto) {

        // check for username that exists in database
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "username already exists!");
        }

        // check for email in database
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "email already exists!");
        }
        //
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        return "User Registered sucessfully";
    }
}
