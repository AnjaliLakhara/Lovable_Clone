package com.SpringProject.Lovable_Clone.dto.member;

import com.SpringProject.Lovable_Clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
    @NotNull ProjectRole role
) {

}
