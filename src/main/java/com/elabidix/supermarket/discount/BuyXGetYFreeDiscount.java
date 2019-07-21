package com.elabidix.supermarket.discount;

public class BuyXGetYFreeDiscount implements Discount {

    private int costProduct;
    private int freeProduct;

    public BuyXGetYFreeDiscount(int costProduct, int freeProduct) {
        this.costProduct = costProduct;
        this.freeProduct = freeProduct;
    }

    public int getFreeProduct() {
        return freeProduct;
    }

    public void setFreeProduct(int freeProduct) {
        this.freeProduct = freeProduct;
    }

    public int getCostProduct() {
        return costProduct;
    }

    public void setCostProduct(int costProduct) {
        this.costProduct = costProduct;
    }

    public double getCostProductAsDouble() {
        return (double) costProduct;
    }

    public double getFreeProductAsDouble() {
        return freeProduct;
    }

    public int getTotalProductDiscount() {
        return freeProduct + costProduct;
    }

    public double getTotalProductAsDouble() {
        return (double) (freeProduct + costProduct);
    }

    public double getPercentageDiscount() {

        return (1 - getFreeProductAsDouble() / getTotalProductAsDouble());
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Buy ")
                .append(costProduct)
                .append(" get ")
                .append(freeProduct)
                .append(" free");
        return str.toString();
    }
}
