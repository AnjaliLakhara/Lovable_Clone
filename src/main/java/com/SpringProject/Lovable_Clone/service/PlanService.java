package com.SpringProject.Lovable_Clone.service;

import java.util.List;
import com.SpringProject.Lovable_Clone.dto.subscription.PlanResponse;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
