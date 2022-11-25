package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-24-17:10
 */
@SuppressWarnings("all")
public class L516最长回文子序列 {

    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        /**
         * dp[i][j]:字符串s在[i,j]范围内最长的回文字符串的长度为dp[i][j]
         */
        int[][] dp = new int[len+1][len+1];
        /**
         * 根据递推公式来看 遍历i的时候一定要从下到上遍历，这样才能保证，下一行的数据是经过计算的。
         */
        for (int i = len-1; i >=0; i--) { //从后往前遍历，保证情况不漏
            dp[i][i] = 1;//初始化
            for (int j = i+1; j < len; j++) {
                //如果两边字符相等 则更新 i - j 字符串长度为 dp[i+1][j-1]+2
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    //如果不相等 就代表s[i] s[j] 不能同时加入回文子序列，那么就分别加入s[i] s[j] 看看那一个可以组成最长回文子序列
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);//而且dp[i+1][j],dp[i][j-1]都是提前计算好了的 我们不需要再次计算
                }
            }
        }
        return dp[0][len-1];
    }
}
