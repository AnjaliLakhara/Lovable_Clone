package com.SpringProject.Lovable_Clone.dto.auth;

public record UserProfileResponse(
    Long id,
    String email,
    String name,
    String avatarUrl
) {

}
