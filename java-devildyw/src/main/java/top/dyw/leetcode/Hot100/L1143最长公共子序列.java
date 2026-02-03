package top.dyw.leetcode.Hot100;

public class L1143最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // dp[i][j] 表示text1 0~i 与text2 0～j的最长公共子序列 长度
        // text1[i] == text2[j] dp[i][j] = dp[i-1][j-1] +1
        // 否则 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) //有道理 我怎么没想到呢
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public int longestCommonSubsequence01(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // dp[i][j]表示text1 0～i-1 与 text2 0～j-1的最长公共子序列
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
