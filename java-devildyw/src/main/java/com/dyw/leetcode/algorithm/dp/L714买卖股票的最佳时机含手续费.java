package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-16-12:34
 */
@SuppressWarnings("all")
public class L714买卖股票的最佳时机含手续费 {

    public static void main(String[] args) {
        System.out.println(new L714买卖股票的最佳时机含手续费().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        //0 持股 买入
        //1 不持股 卖出
        //dp[i] 定义第 i 天持股/不持股，所得的最大现金 在卖出时计算手续费
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //可以多次购买 所以这里持股情况需要将dp[i][1]带入计算
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
        }

        return Math.max(dp[len-1][0],dp[len-1][1]);
    }
}
