package com.SpringProject.Lovable_Clone.dto.member;

import com.SpringProject.Lovable_Clone.enums.ProjectRole;

public record UpdateMemberRoleRequest(
    ProjectRole role
) {

}
