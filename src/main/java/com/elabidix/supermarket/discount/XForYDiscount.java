package com.elabidix.supermarket.discount;

public class XForYDiscount implements Discount {

    private double amount ;
    private double amountPrice ;

    public XForYDiscount(double amount, double amountPrice) {
        this.amount = amount;
        this.amountPrice = amountPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountPrice() {
        return amountPrice;
    }

    public void setAmountPrice(double amountPrice) {
        this.amountPrice = amountPrice;
    }


    @Override
    public String toString() {
        StringBuffer str = new StringBuffer() ;
        str.append((int) amount)
                .append(" for ")
                .append(amountPrice)
                .append("$");
        return str.toString();
    }

}
