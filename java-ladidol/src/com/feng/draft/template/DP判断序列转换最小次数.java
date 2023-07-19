package com.feng.draft.template;

public class DP判断序列转换最小次数 {
    public static int minimumMoves(int[] s1, int[] s2) {
        // 确保两个序列长度相等
        if (s1.length != s2.length) {
            throw new IllegalArgumentException("序列长度不一致");
        }

        int n = s1.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[n][n];
    }

    public static void main(String[] args) {
        int[] s1 = {3, 3, 0, 0, -1};
        int[] s2 = {-1, 0, 0, 3, 3};
        int minimumMoves = minimumMoves(s1, s2);

        System.out.println("从序列s2变换到s1所需的最少移动数字数量为：" + minimumMoves);
    }
}
