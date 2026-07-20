package com.SpringProject.Lovable_Clone.mapper;

import com.SpringProject.Lovable_Clone.dto.auth.SignupRequest;
import com.SpringProject.Lovable_Clone.dto.auth.UserProfileResponse;
import com.SpringProject.Lovable_Clone.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);
}
