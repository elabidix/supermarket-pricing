package com.elabidix.supermarket.product;


import com.elabidix.supermarket.util.AppUtil;

public abstract class Product {

    private String code;
    private String name ;
    private double price ;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {


        double d = 2.34568;
        double d1 = 1.199;

        System.out.println(AppUtil.round(d));
    }
}
