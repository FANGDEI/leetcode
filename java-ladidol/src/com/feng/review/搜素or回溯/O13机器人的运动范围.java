package com.feng.review.搜素or回溯;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/6 11:45
 * @description: {}
 */
public class O13机器人的运动范围 {


    //dfs深搜
    class Solution {
        /**
         * 注意，机器人只能一步一步走，不能走到不合法的格子上去。
         *
         * @param m
         * @param n
         * @param k
         * @return
         */
        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            isVisited = new boolean[m][n];
            dfs(0, 0, k);
            return ans;
        }

        boolean[][] isVisited;
        int ans = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m, n;

        void dfs(int i, int j, int k) {
            if (isVisited[i][j] || !isValid(i, j, k)) return;
            ans++;
            //染色
            isVisited[i][j] = true;
            //搜索
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    dfs(x, y, k);
                }
            }
        }


        boolean isValid(int i, int j, int k) {
            int sum = 0;
            while (i > 0) {
                sum += i % 10;
                i /= 10;
            }
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }
            return sum <= k;
        }
    }

}
