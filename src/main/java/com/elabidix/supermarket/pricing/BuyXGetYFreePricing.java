package com.elabidix.supermarket.pricing;

import com.elabidix.supermarket.discount.BuyXGetYFreeDiscount;
import com.elabidix.supermarket.exception.DiscountException;
import com.elabidix.supermarket.order.OrderItem;
import com.elabidix.supermarket.util.AppUtil;

public class BuyXGetYFreePricing implements Pricing {

    @Override
    public double doPricing(OrderItem orderItem) throws Exception {

        BuyXGetYFreeDiscount discount = (BuyXGetYFreeDiscount) orderItem.getDiscount();
        int orderAmount = (int) orderItem.getAmount();

        if (orderAmount < discount.getTotalProductDiscount()) {
            throw new DiscountException("To benifit from this count, you should take more then " + discount.getTotalProductDiscount() + " items");
        }

        double price = orderItem.getProduct().getPrice();
        double discountPrice = price * discount.getPercentageDiscount();


        int discountedItems = (orderAmount / discount.getTotalProductDiscount()) * discount.getTotalProductDiscount();
        int noDiscountedItems = orderAmount - discountedItems;


        return AppUtil.round(discountedItems * discountPrice + noDiscountedItems * price);
    }

}
