package com.feng.newline.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/26 12:10
 * @description: {}
 */
public class L1091二进制矩阵中的最短路径 {
    class Solution {
        /**
         * bfs
         *
         * @param grid
         * @return
         */
        public int shortestPathBinaryMatrix(int[][] grid) {

            if (grid[0][0] == 1) return -1;
            if (grid[0][0] == 0 && grid.length == 1 && grid[0].length == 1) return 1;
            Deque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0, 0});
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 1}, {1, -1}, {1, 0}, {-1, 1}, {-1, 0}, {-1, -1}};
            int ans = 1;
            while (!queue.isEmpty()) {
                int curSize = queue.size();
                ans++;
                while (curSize-- > 0) {
                    int[] poll = queue.poll();
                    int x = poll[0], y = poll[1];
                    for (int[] dir : dirs) {
                        int newX = x + dir[0], newY = y + dir[1];
                        if (newX == grid.length - 1 && newY == grid[0].length - 1 && grid[newX][newY] == 0) {
                            return ans;
                        }
                        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                            grid[newX][newY] = 1;//标记已访问
                            queue.offer(new int[]{newX, newY});
                        }
                    }

                }
            }
            return -1;
        }
    }
}
