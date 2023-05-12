package com.feng.leetcode.offerII._02数组;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/7 14:48
 * @description: {}
 */
public class 剑指OfferII010和为k的子数组 {

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int curSum = 0;
                for (int j = i; j < nums.length; j++) {
                    curSum += nums[j];
                    if (curSum == k) {
                        ans++;
                    }


                }
            }
            return ans;
        }
    }
}
