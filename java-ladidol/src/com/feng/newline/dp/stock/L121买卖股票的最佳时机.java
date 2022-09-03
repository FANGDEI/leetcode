package com.feng.newline.dp.stock;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L121买卖股票的最佳时机
 * @author: Ladidol
 * @description: 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 提示：
 * @date: 2022/9/3 15:50
 * @version: 1.0
 */
public class L121买卖股票的最佳时机 {
    // 贪心：左边取最小值，右边取最大值。
    class Solution1 {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int chaMax = 0;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                chaMax = Math.max(chaMax, prices[i] - min);
            }
            return chaMax;
        }
    }

    // 二维dp
    // dp：dp[i][0]代表第i天持有股票的最大收益，dp[i][1]代表第i天不持有股票的最大收益
    // 状态转移方程：
    // dp[i][0] = Math.max(dp[i-1][0], -prices[i])：持有股票的可能来源：①从以前传来，②今天购买
    // dp[i][1] = Math.max(dp[i-1][1],prices[i] + dp[i-1][0])：不持有股票的可能来源：①以前就卖了，②今天卖出了；
    class Solution2 {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = -prices[0];// 只能买第一天股票
            dp[0][1] = 0;//第一天不能靠股票盈利的
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
            }
            return dp[dp.length - 1][1];//不持有股票才收益最高；
        }
    }


    // 一维dp（滚动数组优化）？？？？为啥 [1,2,4]这个用例会出问题？？？？
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[2][2];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i & 1][0] = Math.max(dp[(i - 1) & 1][0], -prices[i]);
                dp[i & 1][1] = Math.max(dp[(i - 1) & 1][1], prices[i] + dp[(i - 1) & 1][0]);
            }
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < dp.length; i++) {
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("(dp.length - 1) & 1 = " + ((dp.length - 1) & 1));
            return dp[(dp.length - 1) & 1][1];
        }
    }


}
