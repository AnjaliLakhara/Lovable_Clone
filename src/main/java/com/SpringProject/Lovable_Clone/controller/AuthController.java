package com.SpringProject.Lovable_Clone.controller;

import com.SpringProject.Lovable_Clone.dto.auth.AuthResponse;
import com.SpringProject.Lovable_Clone.dto.auth.LoginRequest;
import com.SpringProject.Lovable_Clone.service.UserService;
import com.SpringProject.Lovable_Clone.dto.auth.UserProfileResponse;
import com.SpringProject.Lovable_Clone.dto.auth.SignupRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.SpringProject.Lovable_Clone.service.AuthService;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

    AuthService authService;
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(SignupRequest request){
        return ResponseEntity.ok(authService.signup(request));
    };

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));

    }
}
