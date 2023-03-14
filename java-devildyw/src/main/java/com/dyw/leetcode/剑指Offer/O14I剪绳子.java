package com.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/14 20:08
 **/
@SuppressWarnings("all")
public class O14I剪绳子 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1]; // dp[i] 表示将正整数i拆分成了至少两个数之后对应的最大乘积
        //dp[0] dp[1] 因为 0 和 1 都是不能再拆分的数所以值为0

        //dp[i] 要么直接为 i直接拆成两个数的乘积(j*(i-j))，要么为i+1拆成多个数相乘 (i*dp[i-j]) 或者上两种情况都不如其原本的值大（dp[i]是会变化的）
        //因为上述分析过，0，1不能拆分所以这里从2开始
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //动态规划
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }

        return dp[n];
    }
}

