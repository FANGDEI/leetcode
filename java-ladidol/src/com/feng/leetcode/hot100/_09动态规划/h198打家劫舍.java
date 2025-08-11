package com.feng.leetcode.hot100._09动态规划;

public class h198打家劫舍 {

    class Solution {
        public int rob(int[] nums) {

            int max = 0;
            int[] dp = new int[nums.length + 2];
            for (int i = 0; i < nums.length; i++) {
                dp[i+2] = Math.max(dp[i+1],dp[i]+nums[i]);
            }
            // 最后两个都可能是答案 dp[nums.length - 1] + nums[nums.length - 1] or dp[nums.length]
            return dp[nums.length + 1];
        }
    }

}
