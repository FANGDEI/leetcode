package com.feng.面试题.途虎;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // 行数
        int n = grid[0].length; // 列数
        
        // 创建一个与原数组相同大小的dp数组，用于存储到达每个位置的最小总和路径
        int[][] dp = new int[m][n];
        
        // 初始化dp数组的第一行和第一列
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // 逐行逐列计算最小总和路径
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到达当前位置的最小总和路径为从上方和左方两个位置中选择较小的路径加上当前位置的代价
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        // 返回右下角位置的最小总和路径
        return dp[m - 1][n - 1];
    }
}




























