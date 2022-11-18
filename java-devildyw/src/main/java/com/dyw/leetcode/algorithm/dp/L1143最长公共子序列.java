package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-18-11:43
 */
@SuppressWarnings("all")
public class L1143最长公共子序列 {

    public static void main(String[] args) {

    }

    /**
     * 遍历顺序
     * <p>
     * <img src = "https://img-blog.csdnimg.cn/20210204115139616.jpg">
     * <p>
     * 举例推导 dp 数组
     * <p>
     * <img src="https://img-blog.csdnimg.cn/20210210150215918.jpg">
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();

        /**
         * dp[i][j] 表示text1 从0到 i-1 与 text2 从 0到 j-1 的最长公共子序列
         * 数组初始化为0
         */
        int[][] dp = new int[n + 1][m + 1];
        /**
         * 遍历顺序 外层text1 从1 开始遍历 内层text2 从 1开始遍历
         * 要让text1的每一个元素 与 text2 的每个元素比对
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //如果遇到相同的字符 那么找到了一个公共元素 所以 dp[i][j] = dp[i-1][j-1]+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //如果不相同，那就取前面找到的最大公共子序列长度
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
