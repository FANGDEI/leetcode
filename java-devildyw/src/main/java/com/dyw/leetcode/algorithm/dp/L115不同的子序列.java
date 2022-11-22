package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-22-12:43
 */
@SuppressWarnings("all")
public class L115不同的子序列 {
    public static void main(String[] args) {

    }

    /**
     * 根据题意要求找到s中t出现的个数 即找到从s不改变相对位置中能得到t的的方案数量
     * 解释：现在s中能够找到t的所有字符，中间如果找到了重复的字符就有着不同的方式（因为换一个索引的字符也算是一个新的方式） 即 rabbbit 与 rabbit 就有三种不同的方案
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        /**
         * dp[i][j]: s以i-1结尾的字符串出现t以j-1结尾的字符串的个数为dp[i][j]
         */
        int[][] dp = new int[n+1][m+1];

        //初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}
