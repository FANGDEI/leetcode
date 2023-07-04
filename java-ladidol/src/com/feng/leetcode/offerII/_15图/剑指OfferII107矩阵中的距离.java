package com.feng.leetcode.offerII._15图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/23 21:20
 * @description: {}
 */
public class 剑指OfferII107矩阵中的距离 {

    class Solution {
        private int n;
        private int m;
        private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        /**
         * BFS从零开始，多源bfs，逆向思维；
         * 从最外层往里面扩散，用一个极大值来标记更里层；
         */
        public int[][] updateMatrix(int[][] matrix) {
            n = matrix.length;
            m = matrix[0].length;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        // 将所有 0 元素作为 BFS 第一层
                        queue.add(new int[]{i, j});
                    } else {
                        matrix[i][j] = n + m;
                    }
                }
            }
            while (!queue.isEmpty()) {
                int[] s = queue.poll();
                // 搜索上下左右四个方向
                for (int[] dir : dirs) {
                    int r = s[0] + dir[0], c = s[1] + dir[1];
                    if (r >= 0 && r < n
                            && c >= 0 && c < m
                            && matrix[r][c] > matrix[s[0]][s[1]] + 1) {//判断更里面一层的条件
                        matrix[r][c] = matrix[s[0]][s[1]] + 1;//维护最新扩散层的正确值
                        queue.add(new int[]{r, c});
                    }
                }
            }
            return matrix;
        }

    }
}
