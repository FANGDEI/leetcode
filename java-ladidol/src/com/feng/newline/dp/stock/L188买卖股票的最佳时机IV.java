package com.feng.newline.dp.stock;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L188买卖股票的最佳时机IV
 * @author: Ladidol
 * @description: 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1：
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * @date: 2022/9/3 20:28
 * @version: 1.0
 */
public class L188买卖股票的最佳时机IV {
    // 二维dp，根据123买卖股票III推演过来，这题的每天就有2k+1个状态的，出去什么都不干就还剩2k个状态了。
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) return 0;
            // 奇数是买入，偶数是卖出。
            int[][] dp = new int[prices.length][2 * k + 1];

            //初始化
            for (int j = 1; j < 2 * k; j += 2) {
                dp[0][j] = -prices[0];
            }

            for (int i = 1; i < prices.length; i++) {
                for (int j = 1; j < 2 * k; j += 2) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);//买入
                    dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);//卖出
                }
            }
            return dp[dp.length - 1][2 * k];
        }
    }

    // 有些为了方便表示用了三维数组来做，其实是一样的。
}
