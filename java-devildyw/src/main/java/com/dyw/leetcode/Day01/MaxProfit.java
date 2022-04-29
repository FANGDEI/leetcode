package com.dyw.leetcode.Day01;

/**
 * @author Devil
 * 股票最大利润
 *
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class MaxProfit {
    public int maxProfit01(int[] prices) {
        if (prices==null&&prices.length==0){
            return 0;
        }
        //新建dp数组
        int[][] dp = new int[prices.length][2];

        //第一天没有持有股票的利润 
        dp[0][0] = 0;
        //第一天持有股票的利润
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit02(int[] prices) {
        if (prices==null&&prices.length==0){
            return 0;
        }
        //没有持有股票的利润
        int noHold = 0;
        //持有股票的利润
        int hold = -prices[0];

        for (int price : prices) {
            //持续更新 没有持有股票的利润 持有股票的利润
            noHold = Math.max(noHold, hold + price);
            hold = Math.max(hold, -price);
        }
        return noHold;
    }
}
