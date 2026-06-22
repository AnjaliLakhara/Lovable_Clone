package com.SpringProject.Lovable_Clone.service;

import com.SpringProject.Lovable_Clone.dto.subscription.CheckoutResponse;
import com.SpringProject.Lovable_Clone.dto.subscription.PortalResponse;
import com.SpringProject.Lovable_Clone.dto.subscription.SubscriptionResponse;
import com.SpringProject.Lovable_Clone.dto.subscription.CheckoutRequest;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);
    PortalResponse openCustomerPortal(Long userId);
}
