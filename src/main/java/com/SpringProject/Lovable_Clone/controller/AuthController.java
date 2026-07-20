package com.SpringProject.Lovable_Clone.controller;

import com.SpringProject.Lovable_Clone.dto.auth.AuthResponse;
import com.SpringProject.Lovable_Clone.dto.auth.LoginRequest;
import com.SpringProject.Lovable_Clone.service.UserService;
import com.SpringProject.Lovable_Clone.dto.auth.UserProfileResponse;
import com.SpringProject.Lovable_Clone.dto.auth.SignupRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<AuthResponse> signup(@RequestBody @Valid SignupRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));

    }
}
