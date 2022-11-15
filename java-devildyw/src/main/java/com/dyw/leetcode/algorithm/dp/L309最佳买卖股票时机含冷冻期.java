package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-15-11:17
 */
@SuppressWarnings("all")
public class L309最佳买卖股票时机含冷冻期 {

    public static void main(String[] args) {

    }

    /**
     * 动态规划
     * <p>
     * 状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
     * 卖出股票状态，这里就有两种卖出股票状态
     * <p>
     * 状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
     * <p>
     * 状态三：今天卖出了股票
     * <p>
     * 状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n==0) return 0;

        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0]; //第i天持有股票
        for (int i = 1; i < n; i++) {
            /**
             * dp[i][0] 第i天持有股票的情况 (刚卖出的情况不能取 因为有一天的冷冻期不能再卖 所以不能取dp[i-1][2])
             * 要么是前一天持有股票的状况 要么是今天买入（有两种状况） 1. 前一天是冷冻期 dp[i-1][3]-prices[i] 2.前一天是保持卖出股票状态 dp[i-1][2]-prices[1]
             */
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][3],dp[i-1][1])-prices[i]);
            /**
             * dp[i][1] 是第i天保持卖出股票状态(度过了冷冻期但没有操作)
             * 取 前一天卖出股票利润 和  前一天是冷冻期的利润的最大值 因为刚卖出有冷冻期需要等1天 所以这里不能取 dp[i-1][2]
             */
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3]);
            /**
             * dp[i][2] 是第i天卖出股票状态(第i天卖出去)
             * 前一天持有股票的利润加上今天卖出股票的利润
             */
            dp[i][2] = dp[i-1][0] + prices[i];
            /**
             * dp[i][3] 是第i天达到冷冻期状态 即卖出了股票后的状态
             * 所以利润和 dp[i][2] 一样
             */
            dp[i][3] = dp[i-1][2];
        }
        return Math.max(dp[n-1][3],Math.max(dp[n-1][1],dp[n-1][2]));
    }

    public int maxProfit01(int[] prices) {
        if (prices.length==0||prices==null){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i][0],Math.max(dp[i-1][1],dp[i-1][3])-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2] = dp[i][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        return Math.max(dp[n-1][2],Math.max(dp[n-1][1],dp[n-1][3]));
    }
}
