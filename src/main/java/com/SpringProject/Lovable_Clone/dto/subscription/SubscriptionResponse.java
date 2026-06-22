package com.SpringProject.Lovable_Clone.dto.subscription;

import java.time.Instant;

public record SubscriptionResponse(
    PlanResponse plan,
    String status,
    Instant periodEnd,
    Long tokensUsedThisCycle
) {

}
