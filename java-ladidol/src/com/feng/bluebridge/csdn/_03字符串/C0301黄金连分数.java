package com.feng.bluebridge.csdn._03字符串;

import java.io.*;
import java.math.BigDecimal;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/7 16:52
 * @description: {}
 */
public class C0301黄金连分数 {
    public static void main(String[] args) {
        BigDecimal result = new BigDecimal(1);
        BigDecimal fenZi = new BigDecimal(1);

        for (int i = 0; i < 500; i++) {
            result = fenZi.divide(result.add(fenZi), 200, BigDecimal.ROUND_HALF_UP);
        }
        System.out.println(result.setScale(101, BigDecimal.ROUND_HALF_UP));//这里保留一位小数

    }

}
// 0.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911375
