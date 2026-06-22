package com.SpringProject.Lovable_Clone.dto.subscription;

public record PlanLimitsResponse(
    String planName,
    int maxTokensPerDay,
    int maxProjects,
    boolean unlimitedAi
) {

}
