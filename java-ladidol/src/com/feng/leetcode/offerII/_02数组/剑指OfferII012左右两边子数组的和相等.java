package com.feng.leetcode.offerII._02数组;

import java.util.Arrays;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/12 13:40
 * @description: {}
 */
public class 剑指OfferII012左右两边子数组的和相等 {


    //前缀和（都用不到）简单题简单过了
    class Solution {
        /**
         * total 是否等于 preSum* 2 + nums[i]
         *
         * @param nums
         * @return
         */
        public int pivotIndex(int[] nums) {
            int ans = -1;
            int total = Arrays.stream(nums).sum();
            int preSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (preSum * 2 + nums[i] == total) {
                    return i;
                }
                preSum += nums[i];
            }
            return ans;
        }
    }

}
