package top.dyw.leetcode.medium.arrays;

/**
 * @author Devildyw
 * @date 2023/07/15 11:58
 **/
@SuppressWarnings("all")
public class L121买卖股票的最佳时机 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0]; //第一天持有股票
        dp[0][1] = 0; //第一天卖出股票

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]); //得到买入股票的最小金额
            dp[i][1] = Math.max(dp[i-1][1],prices[i]+dp[i-1][0]); //第i天卖出股票的金额
        }

        return dp[n-1][1];
    }
}
