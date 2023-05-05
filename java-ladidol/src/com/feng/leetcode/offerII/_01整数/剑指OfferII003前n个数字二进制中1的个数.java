package com.feng.leetcode.offerII._01整数;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/1 18:20
 * @description: {}
 */
public class 剑指OfferII003前n个数字二进制中1的个数 {
    //介绍Java运算符>、>>、>>>三者的含义及区别
    public static void main(String[] args) {
        //大于、有符号右移，无符号右移；
        System.out.println(-10>>>1);//2147483643
        System.out.println(Integer.toBinaryString(2147483643));//01111111_11111111_11111111_11111011正数
        System.out.println(-10>>>2);//1073741821
        System.out.println(Integer.toBinaryString(1073741821));//0011111_11111111_11111111_111111101

    }

    //直接调用api吧
    class Solution {
        public int[] countBits(int n) {
            int[] res = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                res[i] = Integer.bitCount(i);
            }
            return res;
        }
    }
}
