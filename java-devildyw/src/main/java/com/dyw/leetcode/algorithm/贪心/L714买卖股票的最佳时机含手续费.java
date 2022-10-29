package com.dyw.leetcode.algorithm.贪心;

/**
 * 给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * @author Devil
 * @since 2022-10-26-14:32
 */
@SuppressWarnings("all")
public class L714买卖股票的最佳时机含手续费 {

    public static void main(String[] args) {
        System.out.println(new L714买卖股票的最佳时机含手续费().maxProfit01(new int[]{1, 3, 2, 8, 9, 11}, 2));
    }

    /**
     * 贪心：需要找到最小的买入点 这个买入点可以不断更新 但是卖出点只要是大于当前买入点+fee 的点都可以是卖出点因为有利润
     * <p>
     * 贪心：最小点买，最大点（只要盈利）就卖。
     * <p>
     * 情况一：收获利润的这一天并不是收获利润区间里的最后一天（不是真正的卖出，相当于持有股票），所以后面要继续收获利润。
     * <p>
     * 情况二：前一天是收获利润区间里的最后一天（相当于真正的卖出了），今天要重新记录最小价格了。
     * <p>
     * 情况三：不作操作，保持原有状态（买入，卖出，不买不卖）
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int sum = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                // 这里使用 price[i]-buy 但这不一定是最大点即这里并不是真正卖出了
                // 判断该节点后（紧接着）是否还有比该节点还大的节点，如果有继续收获利润（前面已经交过手续费了 即说明相当于是在最大利润点出交易的）
                // 如果遇到的节点利润（price+fee）小于当前节点price 就相当于前一天已经卖出了，重新寻找新的最小买入点。
                sum += prices[i] - buy;
                buy = prices[i];

                /*
                因为如果还在收获利润的区间里，表示并不是真正的卖出，而计算利润每次都要减去手续费，所以要让minPrice = prices[i] - fee;，这样在明天收获利润的时候，才不会多减一次手续费！
                 */
            }
        }
        return sum;
    }


    public int maxProfit01(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int sum = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i]+fee<buy){
                buy = prices[i]+fee;
            } else if (prices[i] > buy) {
                sum += prices[i]-buy;
                buy = prices[i];
            }
        }
        return sum;
    }


}
