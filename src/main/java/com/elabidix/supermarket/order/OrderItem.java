package com.elabidix.supermarket.order;

import com.elabidix.supermarket.discount.Discount;
import com.elabidix.supermarket.pricing.Pricing;
import com.elabidix.supermarket.product.Product;
import com.elabidix.supermarket.product.UnitProduct;
import com.elabidix.supermarket.product.WeightProduct;
import com.elabidix.supermarket.util.WeightUnit;

public final class OrderItem {


    private Product product;
    private double amount;
    private WeightUnit weightUnit;
    private Discount discount;
    private Pricing pricing;


    public OrderItem(Pricing pricing) {
        this.pricing = pricing;
    }

    public double getTotalOrderItem() throws Exception {
        return this.pricing.doPricing(this);
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    @Override
    public String toString() {

        StringBuffer priceStr = new StringBuffer();
        StringBuffer amountStr = new StringBuffer();
        StringBuffer discountStr = new StringBuffer();

        if (product instanceof UnitProduct) {
            priceStr.append(product.getPrice())
                    .append("/$");
            amountStr.append((int) this.amount)
                    .append(" UNIT");
        } else if (product instanceof WeightProduct) {
            priceStr.append(product.getPrice())
                    .append("/")
                    .append(((WeightProduct) product).getWeightUnit().name());

            amountStr.append((int) this.amount)
                    .append(" ")
                    .append(this.weightUnit.name());
        }

        if (this.discount != null) {
            discountStr.append(this.discount.toString());
        } else {
            discountStr.append("No discount");
        }

        double totalOrderItem = 0;

        try {
            totalOrderItem = getTotalOrderItem();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.format("%-15s%-15s%-15s%-30s%-15s",
                product.getName(), amountStr, priceStr, discountStr, totalOrderItem);

    }

}
