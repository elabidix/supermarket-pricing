package com.elabidix.supermarket;


import com.elabidix.supermarket.audit.AuditImpl;
import com.elabidix.supermarket.discount.BuyXGetYFreeDiscount;
import com.elabidix.supermarket.discount.XForYDiscount;
import com.elabidix.supermarket.order.Order;
import com.elabidix.supermarket.order.OrderItem;
import com.elabidix.supermarket.pricing.BuyXGetYFreePricing;
import com.elabidix.supermarket.pricing.UnitPricing;
import com.elabidix.supermarket.pricing.WeightPricing;
import com.elabidix.supermarket.pricing.XForYPricing;
import com.elabidix.supermarket.product.UnitProduct;
import com.elabidix.supermarket.product.WeightProduct;
import com.elabidix.supermarket.audit.Audit;
import com.elabidix.supermarket.util.WeightUnit;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TDDTest {

    Audit audit = new AuditImpl();

    @Test
    public void simplePricing(){

        UnitProduct product = new UnitProduct() ;
        product.setName("beans");
        product.setPrice(0.65);

        OrderItem orderItem = new OrderItem(new UnitPricing());
        orderItem.setProduct(product);
        orderItem.setAmount(2);

        Order order = new Order() ;
        order.addItem(orderItem);

        audit.saveOrder(order);

        Assert.assertEquals(1.3, order.getTotalOrder(),0.01);

    }

    @Test
    public void simpleWeightPricing(){

        WeightProduct product = new WeightProduct() ;
        product.setName("seems");
        product.setPrice(1.99);
        product.setWeightUnit(WeightUnit.POUND);

        OrderItem orderItem = new OrderItem(new WeightPricing());
        orderItem.setProduct(product);
        orderItem.setAmount(4);
        orderItem.setWeightUnit(WeightUnit.OUNCE);

        Order order = new Order() ;
        order.addItem(orderItem);

        audit.saveOrder(order);

        Assert.assertEquals(0.5, order.getTotalOrder(),0.01);

    }


    @Test
    public void XForYDiscount(){

        UnitProduct product = new UnitProduct() ;
        product.setName("Apple");
        product.setPrice(1);

        OrderItem orderItem = new OrderItem(new XForYPricing());
        orderItem.setProduct(product);
        orderItem.setAmount(5);
        orderItem.setDiscount(new XForYDiscount(3,1));

        Order order = new Order() ;
        order.addItem(orderItem);

        audit.saveOrder(order);

        Assert.assertEquals(1.67, order.getTotalOrder(),0.01);

    }


    @Test
    public void Buy2Get1FreeDiscount(){

        UnitProduct product = new UnitProduct() ;
        product.setName("watch");
        product.setPrice(5);

        OrderItem orderItem = new OrderItem(new BuyXGetYFreePricing());
        orderItem.setProduct(product);
        orderItem.setAmount(4);
        orderItem.setDiscount(new BuyXGetYFreeDiscount(2,1));

        Order order = new Order() ;
        order.addItem(orderItem);

        audit.saveOrder(order);

        Assert.assertEquals(15, order.getTotalOrder(),0.01);

    }


    @Test
    public  void z_auditTrail(){

        double totalAllOrders = audit
                .getAllOrders()
                .stream()
                .mapToDouble(order -> order.getTotalOrder())
                .sum();
        Assert.assertEquals(18.47, totalAllOrders,0.01);

      /*   ORDERS SUMMARY*/

        String header = String.format("%-15s%-15s%-15s%-30s%-15s","Name" ,"Amount","Price","Discount","Total") ; ;
        String footer = String.format("%80s",String.valueOf(totalAllOrders)) ; ;
        String line = "--------------------------------------------------------------------------------" ; ;
        System.out.println(header);
        System.out.println(line);

        audit.getAllOrders().stream().forEach(
                order ->
                {    order.getOrderItems()
                    .stream()
                    .forEach( orderItem -> System.out.println(orderItem ));
                    System.out.println(line);
                }
        );
        System.out.println(footer);





    }





}
