package com.elabidix.supermarket.audit;

import com.elabidix.supermarket.order.Order;
import com.elabidix.supermarket.util.InMemoryDB;

import java.util.List;

public class AuditImpl implements Audit {
    @Override
    public void saveOrder(Order order) {
        InMemoryDB.orders.add(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return  InMemoryDB.orders;
    }
}
