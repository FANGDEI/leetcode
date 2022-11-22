package com.feng.newline.二分;

/**
 * @author: ladidol
 * @date: 2022/11/22 13:43
 * @description: 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 * 示例 1：
 * 输入：n = 1, a = 2, b = 3
 * 输出：2
 * 示例2：
 * 输入：n = 4, a = 2, b = 3
 * 输出：6
 * 提示：
 * 1 <= n <= 109
 * 2 <= a, b <= 4 * 104
 */
public class L878第N个神奇数字 {
    //巧妙的二分思维
    class Solution {
        /**
         *
         * 作者：Ladidol
         * 描述：容斥原理：a的倍数+b的倍数-lcm(a,b)的倍数=x
         * if (mid / a + mid / b - mid / lcm >= n)
         */
        private static final long MOD = (long) 1e9 + 7;

        public int nthMagicalNumber(int n, int a, int b) {
            long lcm = a / gcd(a, b) * b;
            long left = 0, right = (long) Math.max(a, b) * n; // 开区间 (left, right)
            while (left + 1 < right) { // 开区间不为空
                long mid = left + (right - left) / 2;
                if (mid / a + mid / b - mid / lcm >= n)
                    right = mid; // 范围缩小到 (left, mid)
                else
                    left = mid; // 范围缩小到 (mid, right)
            }
            return (int) (right % MOD);
        }

        //求最大公约数
        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

}