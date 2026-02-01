package top.dyw.leetcode.Hot100;

public class L72编辑距离 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        // dp[i][j] 表示 word1前i个字符转为word2前j个字符的最少操作次数
        // 初始化
        // 只能插入
        for (int i=0; i<=n; i++) {
            dp[i][0] = i;
        }
        // 只能插入
        for (int j=0; j<=m; j++) {
            dp[0][j] = j;
        }


        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i-1][j],//删除
                            Math.min(
                                    dp[i-1][j-1], //替换
                                    dp[i][j-1] //插入
                            )
                    ) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
