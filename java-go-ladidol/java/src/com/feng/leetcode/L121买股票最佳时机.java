package com.feng.leetcode;

/**
 * @Description:
 * @Author Ladidol
 * @Date: 2022/3/26 19:36
 * @Version 1.0
 */
public class L121买股票最佳时机 {
    public static void main(String[] args) {
        int[] nums1 = {7,1,5,3,6,4};
        int[] nums2 = {7,6,4,3,1};
        System.out.println(new 买股票().maxProfit(nums1));

    }
}
class 买股票 {
    public int maxProfit(int[] prices) {

        //数组中存有当前的现金;
        //每一个天有两个状态,持有股票1和没有持有股票0
        //持有股票的情况来自于,今天买的or昨天及之前就买了的,然后天持有的股票一定是今天以前最低价买来的;
        //没有股票的情况来自于,今天卖出去了股票or昨天及之前就卖了的


        //dp[i][0]没持股票,dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1]持有股票,dp[i][1]=max(dp[i-1][1],-prices[i])

        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1 ; i< n; i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[n-1][0];

    }
}