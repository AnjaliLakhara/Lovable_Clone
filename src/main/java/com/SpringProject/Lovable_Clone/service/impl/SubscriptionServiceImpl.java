package com.SpringProject.Lovable_Clone.service.impl;

import com.SpringProject.Lovable_Clone.service.SubscriptionService;

import org.springframework.stereotype.Service;

import com.SpringProject.Lovable_Clone.dto.subscription.CheckoutRequest;
import com.SpringProject.Lovable_Clone.dto.subscription.CheckoutResponse;
import com.SpringProject.Lovable_Clone.dto.subscription.PortalResponse;
import com.SpringProject.Lovable_Clone.dto.subscription.SubscriptionResponse;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
