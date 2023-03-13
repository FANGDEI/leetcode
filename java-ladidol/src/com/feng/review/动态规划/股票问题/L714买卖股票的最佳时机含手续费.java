package com.feng.review.动态规划.股票问题;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.stock
 * @className: L714买卖股票的最佳时机含手续费
 * @author: Ladidol
 * @description: 给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 示例 1：
 * <p>
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 示例 2：
 * <p>
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * @date: 2022/9/4 1:08 2023年3月12日20:32:14
 * @version: 1.0
 */
public class L714买卖股票的最佳时机含手续费 {
    // 二维dp，几乎和122买卖股票II一样，这里一维dp就略了
    class Solution {
        // 共有三个状态：记住三个状态的每一种状态下对第二天的影响都是等价的，所以才会从中选择最大的。
        //1. dp[i][0]代表第i天持有股票的最大收益，  【有情况有两种：a.第i-1天也持有股票传过来了；b.第i-1天没有股票，在第i天买入股票】
        //2. dp[i][1]代表第i天不持有股票的最大收益  【有两种情况：a.第i-1天也不持有股票传过来了；b.第i-1天持有股票，在第i-1天卖出】
        public int maxProfit(int[] prices, int fee) {
            int[][] dp = new int[prices.length][2];
            // 初始化
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
            }
            return dp[dp.length - 1][1];
        }
    }
}
