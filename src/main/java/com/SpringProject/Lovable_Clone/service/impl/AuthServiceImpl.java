package com.SpringProject.Lovable_Clone.service.impl;

import org.springframework.stereotype.Service;

import com.SpringProject.Lovable_Clone.dto.auth.AuthResponse;
import com.SpringProject.Lovable_Clone.dto.auth.LoginRequest;
import com.SpringProject.Lovable_Clone.dto.auth.SignupRequest;
import com.SpringProject.Lovable_Clone.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
