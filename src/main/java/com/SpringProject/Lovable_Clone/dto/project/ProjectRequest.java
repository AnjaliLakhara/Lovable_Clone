package com.SpringProject.Lovable_Clone.dto.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
    @NotBlank String name
) {

}
