package com.jirafa.leetcode.algorithm.dp;

public class L416 {
    public static boolean canPartition(int[] nums) {
        int sum=0;

        for(int num:nums) {
            sum+=num;
        }
        if(sum%2!=0)
            return false;

        int target=sum/2;
        int[] dp = new int[target + 1];


        for (int i = 0; i < dp.length; i++) {
            dp[i]= i>=nums[0] ? nums[0] : 0;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = dp.length-1; j >=nums[i]; j--) {
                    dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);

            }
        }

        return dp[target]==target;
    }

    public static void main(String[] args) {
        canPartition(new int[]{1,2,5});
    }
}
