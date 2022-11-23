package com.jirafa.leetcode.algorithm.greedy;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class L122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int profit;
        for (int i = 1; i < prices.length; i++) {
            profit=prices[i]-prices[i-1];
            if(profit>=0)
                result+=profit;
        }
        return result;
    }
}
