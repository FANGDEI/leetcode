package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/14 19:26
 **/
@SuppressWarnings("all")
public class O63股票的最大利润 {

    public static void main(String[] args) {

    }

    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int n = prices.length;

        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0]; //第一天持有股票时的利润
        dp[0][1] = 0; //第一天不持有股票时的利润

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[n - 1][1];

    }


    public int maxProfit01(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int n = prices.length;

        int min = prices[0];

        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] + min);
            }
        }

        return res;

    }
}
