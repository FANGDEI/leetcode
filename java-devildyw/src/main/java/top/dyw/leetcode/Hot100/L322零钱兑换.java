package top.dyw.leetcode.Hot100;

import java.util.*;

public class L322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // dp[i] 表示凑成总金额i所需要的硬币的最少数量
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j=0; j<coins.length; j++) {
                if (coins[j]<=i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}