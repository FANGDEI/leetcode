package com.jirafa.leetcode.algorithm.dp;

import org.junit.Test;


public class L63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) //如果在起点或终点出现了障碍，直接返回0
            return 0;
        int[][] dp = obstacleGrid.clone();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]=dp[i][j]==0?1:0;
            }
        }
        for (int i = 1; i < m; i++) {
            if(dp[i][0]!=0)
                dp[i][0]=dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            if(dp[0][i]!=0)
                dp[0][i]=dp[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(dp[i][j]!=0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }


        return dp[m-1][n-1];
    }

    @Test
    public void test(){
        System.out.println(new L63().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0},{
            0, 0, 0
        }}));
    }
}
