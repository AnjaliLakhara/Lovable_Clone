package com.SpringProject.Lovable_Clone.dto.subscription;

public record PlanLimitsResponse(
    String planName,
    Integer maxTokensPerDay,
    Integer maxProjects,
    boolean unlimitedAi
) {

}
