package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-14-11:32
 */
@SuppressWarnings("all")
public class L123买卖股票的最佳时机III {

    public static void main(String[] args) {

    }

    /**
     * 一天共有五种状态
     * 0. 没有操作
     * 1. 第一次买入
     * 2. 第一次卖出
     * 3. 第二次买入
     * 4. 第四次卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len==0) return 0;
        /**
         * dp[i][j] i 标识第 i 天，j为[0-4]五个状态，dp[i][j]表示第 i 天状态 j 所剩最大现金
         */
        int[][] dp = new int[len][5];
        //初始化第一次买入
        dp[0][1] = -prices[0];
        //初始化第二次买入
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            //第 i 天 第一次买入
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
            //第 i 天 第一次卖出
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            //第 i 天 第二次买入
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            //第 i 天 第二次卖出
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }

        return dp[len-1][4];

    }


}
