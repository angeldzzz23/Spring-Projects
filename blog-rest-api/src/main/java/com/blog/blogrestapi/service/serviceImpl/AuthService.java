package com.blog.blogrestapi.service.serviceImpl;

import com.blog.blogrestapi.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
