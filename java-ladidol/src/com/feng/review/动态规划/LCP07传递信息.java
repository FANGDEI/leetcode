package com.feng.review.动态规划;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/17 21:18
 * @description: {}
 */
public class LCP07传递信息 {
    //显然用bfs和dfs都能做，这里就用dp来做一下吧。
    class Solution {
        /**
         * dp[i][b] += dp[i-1][a],其中i是已经走的步数，在一步中a是起点，b是终点。
         *
         * @param n
         * @param relation
         * @param k
         * @return
         */
        public int numWays(int n, int[][] relation, int k) {
            int[][] dp = new int[k + 1][n];
            dp[0][0] = 1;
            for (int i = 1; i <= k; i++) {
                for (int[] ints : relation) {
                    int a = ints[0], b = ints[1];
                    dp[i][b] += dp[i - 1][a];
                }
            }
            return dp[k][n - 1];
        }
    }
}
