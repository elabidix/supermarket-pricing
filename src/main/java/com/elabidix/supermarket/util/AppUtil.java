package com.elabidix.supermarket.util;

import java.text.DecimalFormat;

public final class AppUtil {

    public static double round(double d){
        DecimalFormat f = new DecimalFormat("##.00");
        return Double.parseDouble(f.format(d).replaceAll(",",".")) ;
    }
}
