package top.dyw.leetcode.algorithm.dp;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author Devil
 * @since 2022-11-12-15:19
 */
@SuppressWarnings("all")
public class L121买卖股票的最佳时机 {

    public static void main(String[] args) {
        System.out.println(new L121买卖股票的最佳时机().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * 通过动态规划 不断遍历更新得持有股票利润的最大值（即 买入最便宜的股票的价值） 以及最大不持有股票的利润（即卖出股票的最大利润） 最后返回不持有股票的最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //dp[i][j] 下标含义
        //dp[i][0] 表示第i天持有股票的利润
        dp[0][0] = -prices[0]; //初始化 第一天持有股票就是第一天买入股票
        //dp[i][1] 表示第i天不持有股票的利润
        dp[0][1] = 0; //第一天不持有股票就是第一天不买股票

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }

        return dp[n-1][1];

    }
}
