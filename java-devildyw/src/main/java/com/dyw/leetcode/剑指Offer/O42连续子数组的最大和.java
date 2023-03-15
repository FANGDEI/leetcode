package com.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/15 20:02
 **/
@SuppressWarnings("all")
public class O42连续子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(new O42连续子数组的最大和().maxSubArray(new int[]{1,2}));
    }

    /**
     * 动态规划
     */
    public int maxSubArray(int[] nums) {
        //dp[i] 表示到达第i个位置的最大连续子数组和
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = nums[0]; //用来记录最大的连续子数组和

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }

        return max;
    }
}
