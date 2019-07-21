package com.elabidix.supermarket.pricing;

import com.elabidix.supermarket.order.OrderItem;
import com.elabidix.supermarket.product.WeightProduct;
import com.elabidix.supermarket.util.AppUtil;
import com.elabidix.supermarket.util.WeightConverter;
import com.elabidix.supermarket.util.WeightUnit;

public class WeightPricing implements Pricing {
    @Override
    public double doPricing(OrderItem orderItem) throws Exception {
        WeightProduct product = (WeightProduct) orderItem.getProduct();

        WeightUnit unitIn = product.getWeightUnit();
        WeightUnit unitOut = orderItem.getWeightUnit();
        double amount = orderItem.getAmount();
        double price = product.getPrice();

        return AppUtil.round(price * WeightConverter.convert(unitIn, unitOut).apply(amount));
    }
}
