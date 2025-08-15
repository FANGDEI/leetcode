
package com.feng.面试题.快手;


import java.util.Arrays;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/15 10:37
 */
public class 最大路径和 {

  private static int maxPathSum(int[][] grid) {
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
        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[][] grid = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int sum = maxPathSum(grid);
    System.out.println("sum = " + sum);
  }


}
