package com.elabidix.supermarket.pricing;

import com.elabidix.supermarket.discount.XForYDiscount;
import com.elabidix.supermarket.exception.DiscountException;
import com.elabidix.supermarket.order.OrderItem;
import com.elabidix.supermarket.util.AppUtil;

public class XForYPricing implements Pricing {
    @Override
    public double doPricing(OrderItem orderItem) throws Exception {

        XForYDiscount discount = (XForYDiscount) orderItem.getDiscount();
        double orderAmount = orderItem.getAmount();

        if (discount.getAmount() > orderAmount) {
            throw new DiscountException("This product is discounted, you should buy more then " + discount.getAmount());
        }

        return AppUtil.round(orderAmount * discount.getAmountPrice() / discount.getAmount());
    }
}
