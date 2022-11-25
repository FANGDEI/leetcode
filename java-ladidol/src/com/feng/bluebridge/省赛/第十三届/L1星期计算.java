package com.feng.bluebridge.省赛.第十三届;

import java.math.BigDecimal;

/**
 * @author: ladidol
 * @date: 2022/11/19 11:25
 * @description: 已知今天是星期六，请问 20^22 天后是星期几？
 * 注意用数字 1 到 7 表示星期一到星期日。
 */
public class L1星期计算 {

    public static void main(String[] args) {
        BigDecimal shu = new BigDecimal(20);
        BigDecimal pow22_6 = shu.pow(22).add(new BigDecimal(6));
        System.out.println("pow22_6 = " + pow22_6);
        BigDecimal remainder = pow22_6.remainder(new BigDecimal(7));
        System.out.println("remainder = " + remainder);
        //pow22_6 = 41943040000000000000000000006
        //remainder = 0
    }
}