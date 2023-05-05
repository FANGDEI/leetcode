package com.feng.leetcode.offerII._01整数;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/1 15:32
 * @description: {}
 */
public class 剑指OfferII001整数除法 {

    /**
     * 触及到字的盲区，跳出去需要多大的勇气。
     *
     * @param args
     */
    public static void main(String[] args) {
        int res = 1;
        res += 1 << 31;
        System.out.println(res);//-2147483648
        System.out.println(1 << 31);//先计算位运算，在计算+=双目运算符
    }

    class Solution {
        /**
         * @param a
         * @param b
         * @return 简而言之就是小学的竖式除法(2进制版本)，从高位开始除。且结果不包括小数位
         */
        public int divide(int a, int b) {
            if (a == Integer.MIN_VALUE && b == -1) {
                return Integer.MAX_VALUE;
            }
            //判断是否同号，同号的话 则为正数
            boolean flag = false;
            if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
                flag = true;
            }
            //绝对值运算，采用位运算
            long dividend = Math.abs((long) a);
            long divisor = Math.abs((long) b);
            if (dividend < divisor) {
                return 0;
            }
            int result = 0;
            int shift = 31;
            while (dividend >= divisor) {
                while (dividend < divisor << shift) {
                    shift--;//说明除数还能在小点
                }
                dividend -= divisor << shift;
                result += 1 << shift;

            }
            return flag ? result : -result;
        }
    }
}
