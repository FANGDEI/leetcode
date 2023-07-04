package com.feng.leetcode.offerII._11二分查找;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/30 21:10
 * @description: {}
 */
public class 剑指OfferII072求平方根 {

    //我们将 x2
    //写成幂的形式 x1/2
    //再使用自然对数 e 进行换底，
    class Solution数学 {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            int ans = (int) Math.exp(0.5 * Math.log(x));//全是以e为底；
            return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
        }
    }

    //二分
    class Solution {
        /**
         * 二分查找那个数字就行了
         *
         * @param x
         * @return
         */
        public int mySqrt(int x) {
            int left = 0, right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) mid * mid == x) return mid;
                if ((long) mid * mid > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }
    }

}
