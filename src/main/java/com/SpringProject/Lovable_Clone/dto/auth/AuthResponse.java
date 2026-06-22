package com.SpringProject.Lovable_Clone.dto.auth;

public record AuthResponse(
    String token, 
    UserProfileResponse user) {

}
