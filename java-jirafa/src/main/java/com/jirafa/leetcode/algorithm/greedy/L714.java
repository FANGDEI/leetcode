package com.jirafa.leetcode.algorithm.greedy;

import org.junit.Test;

public class L714 {
    public int maxProfit(int[] prices, int fee) {
        int minPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            //买入操作，买入后相当于真正的卖出
            if(prices[i]<minPrice)
                minPrice = prices[i];

            if(prices[i]>minPrice+fee){
                result+=prices[i]-minPrice-fee;
                //若未进行买入操作，多次计算result时fee会被抵消，相当于只计算最后一笔交易金额
                minPrice = prices[i] - fee;
            }
        }
        return result;
    }

    @Test
    public void test(){
        int i = new L714().maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3);
        System.out.println(i);
    }
}
