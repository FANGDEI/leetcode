package com.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-03-01-11:25
 */
@SuppressWarnings("all")
public class O10II青蛙跳台阶问题 {

    public static void main(String[] args) {
        System.out.println(new O10II青蛙跳台阶问题().numWays(0));
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 1 || n == 0) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
