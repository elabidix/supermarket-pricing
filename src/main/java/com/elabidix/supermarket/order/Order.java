package com.elabidix.supermarket.order;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> orderItems = new ArrayList<OrderItem>() ;


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public double getTotalOrder(){
        return orderItems
                .stream()
                .mapToDouble(orderItem -> {
                    try {
                        return orderItem.getTotalOrderItem();
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage()) ;
                    }
                })
                .sum() ;
    }

}
