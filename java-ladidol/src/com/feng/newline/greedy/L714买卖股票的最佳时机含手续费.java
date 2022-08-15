package com.feng.newline.greedy;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L714买卖股票的最佳时机含手续费
 * @author: Ladidol
 * @description: 给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 示例 1：
 * <p>
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 示例 2：
 * <p>
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * @date: 2022/8/15 21:05
 * @version: 1.0
 */
public class L714买卖股票的最佳时机含手续费 {
    //又是一道没有思路的题。好难啊。这一题的贪心比较难了。
    // 贪心思路
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int buy = prices[0] + fee;
            int sum = 0;
            for (int p : prices) {
                if (p + fee < buy) {
                    buy = p + fee;
                } else if (p > buy) {
                    sum += p - buy;
                    buy = p;
                }
            }
            return sum;
        }
    }


    //主要是dp来做这题。后面学了就来重做这题。

}
