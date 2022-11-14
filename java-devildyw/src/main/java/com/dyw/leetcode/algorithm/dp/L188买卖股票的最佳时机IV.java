package com.dyw.leetcode.algorithm.dp;

/**
 *
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * @author Devil
 * @since 2022-11-14-11:56
 */
@SuppressWarnings("all")
public class L188买卖股票的最佳时机IV {
    public static void main(String[] args) {

    }

    /**
     * 与买入股票的最大利润 III 相似 唯一区别就在于 交易次数 这里是由 K 决定最大的交易次数
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length==0) return 0;

        int len = prices.length;
        // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
        int[][] dp= new int[len][k*2+1];

        //dp 数组初始化
        for (int i = 1; i < k * 2; i+=2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < k * 2 - 1; j+=2) {
                dp[i][j+1] = Math.max(dp[i-1][j+1],dp[i-1][j]-prices[i]);
                dp[i][j+2] = Math.max(dp[i-1][j+2],dp[i-1][j+1]+prices[i]);
            }
        }

        return dp[len-1][k*2];
    }
}
