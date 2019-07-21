package com.elabidix.supermarket.audit;

import com.elabidix.supermarket.order.Order;

import java.util.List;

public interface Audit {

     void saveOrder(Order order) ;
     List<Order> getAllOrders() ;

}
