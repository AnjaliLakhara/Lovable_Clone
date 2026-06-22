package com.SpringProject.Lovable_Clone.service;

import com.SpringProject.Lovable_Clone.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
