package com.SpringProject.Lovable_Clone.dto.project;

import java.time.Instant;
import com.SpringProject.Lovable_Clone.dto.auth.UserProfileResponse;

public record ProjectResponse(
    Long id,
    String name,
    Instant createdAt,
    Instant updatedAt,
    UserProfileResponse owner
) {

}
