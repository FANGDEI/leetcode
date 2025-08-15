/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._09动态规划;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/15 10:47
 */
public class h64最小路径和 {

  class Solution {
    public int minPathSum(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[][] dp = new int[m][n];
      dp[0][0] = grid[0][0];
      for (int j = 1; j < n; j++) {
        dp[0][j] = dp[0][j - 1] + grid[0][j];
      }
      for (int i = 1; i < m; i++) {
        dp[i][0] = dp[i - 1][0] + grid[i][0];
      }
      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
        }
      }
      return dp[m - 1][n - 1];
    }
  }
}
