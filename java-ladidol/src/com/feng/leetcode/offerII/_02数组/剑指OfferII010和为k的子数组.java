package com.feng.leetcode.offerII._02数组;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/7 14:48
 * @description: {}
 */
public class 剑指OfferII010和为k的子数组 {

    //这是朴素做法
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

    //还有一种前缀和+哈希的做法 https://leetcode.cn/problems/QTMn0o/solutions/1764672/by-ac_oier-hr6k/

}
