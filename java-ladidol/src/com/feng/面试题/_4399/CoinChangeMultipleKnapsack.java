package com.feng.面试题._4399;

import java.util.Arrays;

public class CoinChangeMultipleKnapsack {
    public static int coinChange(int[] coins, int[] counts, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        int n = coins.length;

        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            int count = counts[i];

            for (int j = amount; j >= coin; j--) {
                for (int k = 1; k <= count && k * coin <= j; k++) {
                    if (dp[j - k * coin] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - k * coin] + k);
                    }
                }
            }
        }
        System.out.println("coins = " + Arrays.toString(dp));

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int[] counts = {3, 2, 1};
        int amount = 11;

        int minCoins = coinChange(coins, counts, amount);
        System.out.println("The minimum number of coins required is: " + minCoins);
    }
}