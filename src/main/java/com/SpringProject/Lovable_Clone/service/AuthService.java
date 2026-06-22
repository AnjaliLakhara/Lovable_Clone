package com.SpringProject.Lovable_Clone.service;

import com.SpringProject.Lovable_Clone.dto.auth.AuthResponse;
import com.SpringProject.Lovable_Clone.dto.auth.LoginRequest;
import com.SpringProject.Lovable_Clone.dto.auth.SignupRequest;


public interface AuthService {
    AuthResponse signup(SignupRequest request);
    AuthResponse login(LoginRequest request);
}
