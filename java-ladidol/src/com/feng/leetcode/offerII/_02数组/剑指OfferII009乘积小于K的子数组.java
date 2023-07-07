package com.feng.leetcode.offerII._02数组;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/7 14:29
 * @description: {}
 */
public class 剑指OfferII009乘积小于K的子数组 {


    //朴素做法，容易错觉感觉差不多
    class Solution1 {
        public int numSubarrayProductLessThanK(int[] nums, int k) {

            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int curMulti = 1;
                for (int j = i; j < nums.length; j++) {
                    curMulti *= nums[j];
                    if (curMulti >= k) break;
                    ans++;
                }
            }
            return ans;
        }
    }

    //滑动窗口只能用于非负数的情况
    //滑动窗口
    class Solution {
        /**
         * 固定一边，求子数组个数。
         * <p>
         * <p>
         * (值得注意的是，这里固定的是right，右边。)
         *
         * @param nums
         * @param k
         * @return
         */
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1)
                return 0;

            int ans = 0;
            int left = 0, cur = 1;
            for (int right = 0; right < nums.length; right++) {
                cur *= nums[right];
                while (cur >= k) {
                    cur /= nums[left++];
                }
                ans += right - left + 1;
            }
            return ans;
        }
    }


}
