package com.elabidix.supermarket.product;

import com.elabidix.supermarket.util.WeightUnit;

public class WeightProduct extends Product {

    private WeightUnit weightUnit;

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }
}
