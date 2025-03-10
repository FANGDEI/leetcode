package top.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-13-12:47
 */
@SuppressWarnings("all")
public class L122买卖股票的最佳时机II {

    public static void main(String[] args) {
        System.out.println(new L122买卖股票的最佳时机II().maxProfit02(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0]; //第0天持有股票的利润
        dp[0][1] = 0; //第0天不持有股票的利润

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }

        return dp[n-1][1];
    }

    /**
     * dp[i][0] 是持有股票的利润 i-1 持有股票但是i-1天没有卖出，i-1未持有股票，但是i天购入了
     * dp[i][1] 是未持有股票的利润 i-1天就未持有股票，第i天也没有买入；i-1天持有股票，但是第i天买出了
     * @param prices
     * @return
     */
    public int maxProfit02(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
        }
        return dp[prices.length-1][1];
    }
}
