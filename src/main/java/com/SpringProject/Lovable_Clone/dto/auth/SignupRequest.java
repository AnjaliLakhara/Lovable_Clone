package com.SpringProject.Lovable_Clone.dto.auth;

public record SignupRequest(
    String email,
    String name,
    String password
) {

}
