package com.SpringProject.Lovable_Clone.dto.member;

import com.SpringProject.Lovable_Clone.enums.ProjectRole;

public record InviteMemberRequest(
    String email,
    ProjectRole role
) {

}
