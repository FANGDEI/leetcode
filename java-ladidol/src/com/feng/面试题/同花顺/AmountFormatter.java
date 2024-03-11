package com.feng.面试题.同花顺;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AmountFormatter {
    public static String formatAmount(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount);
    }

    public static void main(String[] args) {
//        int amount = 20200909;
//        String formattedAmount = formatAmount(amount);
//        System.out.println(formattedAmount);  // 输出 "20,200,909"

        ArrayList list= new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add("nihao");


    }
}