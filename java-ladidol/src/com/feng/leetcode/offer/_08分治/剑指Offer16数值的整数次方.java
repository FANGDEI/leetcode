package com.feng.leetcode.offer._08分治;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/7 19:24
 * @description: {}
 */
public class 剑指Offer16数值的整数次方 {


    //分治
    class Solution {

        /**
         * 拆成 half * half * mod的情形
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            if (n == -1) return 1 / x;
            double half = myPow(x, n / 2);
            double mod = myPow(x, n % 2);
            return half * half * mod;
        }
    }
}
