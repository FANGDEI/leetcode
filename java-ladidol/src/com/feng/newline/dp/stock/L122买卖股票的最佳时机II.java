package com.feng.newline.dp.stock;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L122买卖股票的最佳时机II
 * @author: Ladidol
 * @description: 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 * 示例 1：
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * @date: 2022/9/3 19:28
 * @version: 1.0
 */
public class L122买卖股票的最佳时机II {
    // 需要好好注意的就是可以多次购买多次卖出，（同一天能买卖）

    // 二维dp
    // dp：dp[i][0]代表第i天持有股票的最大收益，dp[i][1]代表第i天不持有股票的最大收益
    // 状态转移方程：
    // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i])：持有股票的可能来源：①从以前传来，②昨天不持有股票，今天购买
    // dp[i][1] = Math.max(dp[i-1][1],prices[i] + dp[i-1][0])：不持有股票的可能来源：①以前就卖了，②昨天持有的股票今天卖出了；
    class Solution1 {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
            }
            return dp[prices.length - 1][1];
        }
    }

    // 一维dp（滚动数组优化）
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[2][2];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i & 1][0] = Math.max(dp[(i - 1) & 1][0], dp[(i - 1) & 1][1] - prices[i]);
                dp[i & 1][1] = Math.max(dp[(i - 1) & 1][1], prices[i] + dp[(i - 1) & 1][0]);
            }
            return dp[(prices.length - 1) & 1][1];
        }
    }
}
