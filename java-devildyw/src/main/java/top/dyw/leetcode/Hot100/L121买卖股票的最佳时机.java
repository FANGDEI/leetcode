package top.dyw.leetcode.Hot100;

public class L121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int profie = prices[0];
        int result = 0;
        for (int i=1; i<prices.length; i++) {
            result = Math.max(result, prices[i] - profie);
            profie = Math.min(profie, prices[i]);
        }
        return result;
    }
}
