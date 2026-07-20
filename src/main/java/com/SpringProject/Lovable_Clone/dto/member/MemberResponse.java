package com.SpringProject.Lovable_Clone.dto.member;

import java.time.Instant;

import com.SpringProject.Lovable_Clone.enums.ProjectRole;

public record MemberResponse(
    Long userId,
    String username,
    String name,
    ProjectRole projectRole,
    Instant invitedAt

) {

}
