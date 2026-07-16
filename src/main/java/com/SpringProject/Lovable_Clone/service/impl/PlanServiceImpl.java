package com.SpringProject.Lovable_Clone.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.SpringProject.Lovable_Clone.dto.subscription.PlanResponse;
import com.SpringProject.Lovable_Clone.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

     @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }

}
