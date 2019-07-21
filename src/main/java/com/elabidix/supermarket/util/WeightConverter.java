package com.elabidix.supermarket.util;

import com.elabidix.supermarket.exception.ConversionException;

import java.util.function.Function;

public class WeightConverter {

    public static Function<Double, Double> convert(WeightUnit in, WeightUnit out) throws ConversionException {

        if (in == null) {
            throw new NullPointerException("input unit is null");
        }
        if (out == null) {
            throw new NullPointerException("input unit is null");
        }
        if (in == out) {
            return weight -> weight;
        }
        switch (in) {
            case POUND:
                return weight -> weight / 16;
            case OUNCE:
                return weight -> weight * 16;
            default:
                throw new ConversionException();
        }

    }
}
