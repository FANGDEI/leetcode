package com.jirafa.leetcode.algorithm.dp;

import org.junit.Test;

public class L343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i-j; j++) {
                dp[i]=Math.max(dp[i], Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(new L343().integerBreak(10));
    }
}
