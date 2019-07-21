package com.elabidix.supermarket.pricing;

import com.elabidix.supermarket.order.OrderItem;

public interface Pricing {
    double doPricing(OrderItem orderItem) throws Exception;
}
