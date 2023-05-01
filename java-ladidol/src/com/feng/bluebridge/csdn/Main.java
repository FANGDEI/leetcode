package com.feng.bluebridge.csdn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/7 17:04
 * @description: {}
 */
public class Main {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal(1234.5678)
                .divide(
                        new BigDecimal(1.19),
                        4,
                        RoundingMode.CEILING
                );
        BigDecimal bd2 = new BigDecimal(1234.5678)
                .divide(
                        new BigDecimal(1.19),
                        new MathContext(4, RoundingMode.CEILING)
                );


        BigDecimal bd3 = new BigDecimal(1234.5678)
                .divide(
                        new BigDecimal(1.19),
                        new MathContext(7, RoundingMode.CEILING)
                );

        System.out.println("bd1 = " + bd1);
        System.out.println("bd2 = " + bd2);
        System.out.println("bd3 = " + bd3);


    }
}
