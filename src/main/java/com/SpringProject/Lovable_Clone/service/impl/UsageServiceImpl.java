package com.SpringProject.Lovable_Clone.service.impl;

import com.SpringProject.Lovable_Clone.dto.subscription.PlanLimitsResponse;
import com.SpringProject.Lovable_Clone.dto.subscription.UsageTodayResponse;
import com.SpringProject.Lovable_Clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
