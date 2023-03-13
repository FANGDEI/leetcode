package com.feng.review.动态规划.股票问题;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L121买卖股票的最佳时机
 * @author: Ladidol
 * @description:
 * @date: 2022/9/3 15:50 2023年3月11日20:04:13
 * @version: 1.0
 */
public class L121买卖股票的最佳时机_固定次数问题 {

    // 二维dp
    // dp：dp[i][0]代表第i天持有股票的最大收益，dp[i][1]代表第i天不持有股票的最大收益
    // 状态转移方程：
    // dp[i][0] = dp[i-1][0];其实一直没有变而已
    // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);持有股票的可能来源：①从以前传来，②今天购买
    // dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);不持有股票的可能来源：①以前就卖了，②今天卖出了；
    class Solution {
        /**
         * 限制只能买入一次
         * 我们设置三个状态，①什么都不做；②就是买入股票，或者存有股票；③卖出股票，或者以前就卖出了
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][3];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];//第一次买入
            dp[0][2] = 0;//卖出
            for (int i = 1; i < prices.length; i++) {
                //其实有三个状态，只是不操作的状态一直不变而已
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            }
            return dp[prices.length - 1][2];
        }
    }
}
