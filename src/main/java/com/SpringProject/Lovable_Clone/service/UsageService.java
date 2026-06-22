package com.SpringProject.Lovable_Clone.service;

import com.SpringProject.Lovable_Clone.dto.subscription.UsageTodayResponse;
import com.SpringProject.Lovable_Clone.dto.subscription.PlanLimitsResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);
    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
