package com.jirafa.leetcode.algorithm.dp;

import org.junit.Test;

public class L62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0]=0;
        for (int i = 1; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int dfs(int i,int j,int m,int n){
        if(i>m||j>n)
            return 0;
        if(i==m&&j==n)
            return 1;
        return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
    }

    @Test
    public void test(){
        System.out.println(new L62().uniquePaths(3,7));
    }
}
