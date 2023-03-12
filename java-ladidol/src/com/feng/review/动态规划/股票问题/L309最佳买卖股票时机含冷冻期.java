package com.feng.review.动态规划.股票问题;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L309最佳买卖股票时机含冷冻期
 * @author: Ladidol
 * @description: 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * @date: 2022/9/4 0:23 2023年3月12日20:32:08
 * @version: 1.0
 */
public class L309最佳买卖股票时机含冷冻期 {


    // 二维dp
    class Solution {
        // 共有三个状态：记住三个状态的每一种状态下对第二天的影响都是等价的，所以才会从中选择最大的。
        //1. 第i天不持有股票           【有情况有两种：a.第i-1天也不持有股票；b.第i-1天是卖出股票（今天是冷冻期）】
        //2. 第i天持有股票             【有两种情况：a.第i-1天也持有股票，第i天不操作；b.第i-1天不持有股票，在第i天买入】
        //3. 第i天是当天卖出，一个特殊不持有股票的一天【只有一种情况：a.第i-1天持有股票且今天卖出  (留白艺术，他只服务于第一种情况)】
        public int maxProfit(int[] prices) {
            //由于可以无限次交易，所以只定义两个维度，第一个维度是天数，第二个维度表示是否持有股票，0表示不持有，1表示持有，2表示不持有（特殊）
            int[][] dp = new int[prices.length][3];
            // 初始化
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                dp[i][2] = dp[i - 1][1] + prices[i];
            }
            return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
        }
    }
}
