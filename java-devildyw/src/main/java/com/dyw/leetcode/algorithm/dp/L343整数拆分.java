package com.dyw.leetcode.algorithm.dp;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 *
 * @author Devil
 * @since 2022-11-01-11:21
 */
@SuppressWarnings("all")
public class L343整数拆分 {
    public static void main(String[] args) {
        System.out.println(new L343整数拆分().integerBreak(10));
    }

    /**
     * 动态规划
     * <p>
     * 1. 确定dp数组以及下标含义：dp[i]分拆数字 i，可以得到的最大乘积为dp[i]
     * <p>
     * 2. 确定递推公式：dp[i] = Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j))
     * <p>
     * 3. dp 初始化 dp[0] dp[1] 初始化是毫无意义的， 所以这里初始化dp[2] = 1(1*1)
     * <p>
     * 4. dp[i] 是依靠 dp[i-j] 的状态，所以i遍历一定是从前往后的 而j是从1开始的 i是从3开始的
     * <p>
     * 5. 举例推到dp数组 <img src="https://img-blog.csdnimg.cn/20210104173021581.png">
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i - 1; j++) {

                //这里遍历的i表示被拆分的数字直到 n 而 j则表示将 i 被拆成 i - j 和 j 循环下去 就会被拆成若干的 i-j 和 j
                //(i-j)*j 表示拆分相乘，而d[i-j] 则表示对 i-j的拆分相乘的最大值 比较 (i - j) * j和 dp[i - j] * j 取最大的
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
                //之所以要与 dp[i] 比较是因为要通过j的拆分不断更新 dp[i]
            }
        }
        return dp[n];
    }
}
