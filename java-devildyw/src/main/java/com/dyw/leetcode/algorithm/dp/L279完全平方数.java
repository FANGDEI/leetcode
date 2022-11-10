package com.dyw.leetcode.algorithm.dp;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * @author Devil
 * @since 2022-11-10-11:30
 */
@SuppressWarnings("all")
public class L279完全平方数 {

    public static void main(String[] args) {
        System.out.println(new L279完全平方数().numSquares(12));
    }

    /**
     * 动态规划优化版本
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE-1;
        //dp[i]数组的下标的含义：表示容量为 i 的背包能组成 i 的最少完全平分数的个数最少为dp[i]
        int[] dp = new int[n+1];
        //初始化为 max
        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }

        //初始化容量为0的背包的最少完全平方数为 0
        dp[0] = 0;
        //优化
        for (int i = 1; i*i <= n; i++) {
            for (int j = i*i; j < n + 1; j++) {
                if (dp[j-i*i]!=max){
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];



    }

    public int numSquares01(int n) {
        int max = Integer.MAX_VALUE-1;

        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }

        dp[0] = 0;
        //代码提交超时
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n + 1; j++) {
                if (dp[j-i]!=max&&isSquare(i)){
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }

    public boolean isSquare(int num) {
        double a = 0;
        try {
            a = Math.sqrt(num);
        } catch (Exception e) {
            return false;
        }
        int b = (int) a;
        return a - b == 0;
    }
}
