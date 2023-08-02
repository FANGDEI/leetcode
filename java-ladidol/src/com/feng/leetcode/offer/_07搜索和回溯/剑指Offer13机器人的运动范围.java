package com.feng.leetcode.offer._07搜索和回溯;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 21:59
 * @description: {}
 */
public class 剑指Offer13机器人的运动范围 {


    //dfs
    class Solution {

        boolean[][] isVisited;
        int ans = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m, n;

        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            isVisited = new boolean[m][n];
            dfs(0, 0, k);
            return ans;
        }

        void dfs(int i, int j, int k) {
            if (isVisited[i][j] || !isValid(i, j, k)) return;
            isVisited[i][j] = true;
            ans++;
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {//不超范围
                    dfs(x, y, k);
                }
            }
        }


        /**
         * 判断当前格子是不是符合要求的
         *
         * @param i
         * @param j
         * @param k
         * @return
         */
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
