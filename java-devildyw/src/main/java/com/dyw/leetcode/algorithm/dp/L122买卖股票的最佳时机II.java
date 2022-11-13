package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-13-12:47
 */
@SuppressWarnings("all")
public class L122买卖股票的最佳时机II {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp= new int[n][2];
        dp[0][0] = 0; //卖出股票收益
        dp[0][1] = -prices[0]; //持有股票收益

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]); //第i天没有股票
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]); //第i天持有股票
        }

        return dp[n-1][0];
    }
}
