package com.jirafa.leetcode.algorithm.dp;

import org.junit.Test;

public class L746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0]=dp[1]=0;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[dp.length-1];
    }

    @Test
    public void test(){
        System.out.println(new L746().minCostClimbingStairs(new int[]{10,15,20}));
    }
}
