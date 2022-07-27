package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * 股票最大利润
 * <p>
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
@SuppressWarnings("all")
public class L121买卖股票的最佳时机 {
    public int maxProfit01(int[] prices) {
        if (prices == null && prices.length == 0) {
            return 0;
        }
        //新建dp数组
        int[][] dp = new int[prices.length][2];

        //第一天没有持有股票的利润 
        dp[0][0] = 0;
        //第一天持有股票的利润
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit02(int[] prices) {
        if (prices == null || prices.length == 0) {
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

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit03(int[] prices) {
        //股票原理是 从某一天买入 从某一天卖出  利润就等于卖出那天的价格减去买入那天的价格
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        //初始化 没有握有股票时的利润
        int noHold = 0;
        //握有股票时的利润
        int hold = -prices[0];
        for (int price : prices) {
            //遍历数组 不断更新利润 没有握有的利润就相当于 一开始就没有握有股票的利润 或是卖掉股票后的利润 即握有+现在股票价格卖掉后的价格
            noHold = Math.max(noHold, hold + price);
            //更新握有的股票利润 都是取最大值这样卖掉后才有最大的利润
            hold = Math.max(hold, -price);
        }

        //返回卖掉后的利润
        return noHold;
    }
}
