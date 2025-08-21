package com.feng.leetcode.hot100._09动态规划;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/21 18:24
 */
public class h72编辑距离 {


  class Solution {
    public int minDistance(String strA, String strB) {
      int m = strA.length();
      int n = strB.length();
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 0; i <= m; i++) {
        dp[i][0] = i;
      }
      for (int j = 0; j <= n; j++) {
        dp[0][j] = j;
      }

      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1];
          } else {
            dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
          }
        }
      }
      return dp[m][n];
    }
  }

}
