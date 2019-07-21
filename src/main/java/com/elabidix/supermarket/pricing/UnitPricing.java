package com.elabidix.supermarket.pricing;

import com.elabidix.supermarket.order.OrderItem;

public class UnitPricing implements Pricing {


    @Override
    public double doPricing(OrderItem orderItem) throws Exception{
        return orderItem.getProduct().getPrice() * orderItem.getAmount();
    }
}
