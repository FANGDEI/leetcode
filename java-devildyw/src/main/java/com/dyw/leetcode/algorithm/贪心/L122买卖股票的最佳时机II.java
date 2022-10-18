package com.dyw.leetcode.algorithm.贪心;

/**
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润。
 * <p>
 *  注意：
 * 只有一只股票！
 * 当前只有买股票或者卖股票的操作
 * 想获得利润至少要两天为一个交易单元。
 *
 * @author Devil
 * @since 2022-10-18-10:25
 */
@SuppressWarnings("all")
public class L122买卖股票的最佳时机II {

    public static void main(String[] args) {

    }

    /**
     * 贪心
     * <p>
     * 将股票利润分成一段一段的序列 我们只取其中大于0的序列 将他们加起来 这样就能得到最大的利润 从局部推到整体
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}
