package com.feng.leetcode.offerII._15图;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/22 21:40
 * @description: {}
 */
public class 剑指OfferII105岛屿的最大面积 {


    //一层一层来的遍历
    class Solution11 {
        /**
         * bfs，通过记忆化搜索，这里的记忆化，其实就是把遍历过的位置置零就行了。
         * bfs的思想就是从中间向外面扩散；
         *
         * @param grid
         * @return
         */
        public int maxAreaOfIsland(int[][] grid) {
            int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            Deque<int[]> queue = new ArrayDeque<>();
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        queue.offer(new int[]{i, j});
                        int curAns = queue.size();
                        while (!queue.isEmpty()) {
                            int curLen = queue.size();
                            for (int k = 0; k < curLen; k++) {
                                int[] pop = queue.pop();
                                int x = pop[0];
                                int y = pop[1];
                                grid[x][y] = 0;
                                for (int[] dir : dirs) {
                                    int curX = x + dir[0];
                                    int curY = y + dir[1];
                                    if (curX >= 0 && curX < grid.length && curY >= 0 && curY < grid[0].length && grid[curX][curY] == 1) {
                                        curAns++;
                                        queue.offer(new int[]{curX, curY});
                                        grid[curX][curY] = 0;//染色标记
                                    }
                                }
                            }
                        }
                        ans = Math.max(ans, curAns);
                    }
                }
            }
            return ans;
        }
    }


    //改进版，不需要严格区分是第几层
    class Solution {
        /**
         * bfs，通过记忆化搜索，这里的记忆化，其实就是把遍历过的位置置零就行了。
         * bfs的思想就是从中间向外面扩散；
         *
         * @param grid
         * @return
         */
        public int maxAreaOfIsland(int[][] grid) {
            int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            Deque<int[]> queue = new ArrayDeque<>();
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        queue.offer(new int[]{i, j});
                        int curAns = queue.size();
                        while (!queue.isEmpty()) {
                            int[] pop = queue.pop();
                            int x = pop[0];
                            int y = pop[1];
                            grid[x][y] = 0;
                            for (int[] dir : dirs) {
                                int curX = x + dir[0];
                                int curY = y + dir[1];
                                if (curX >= 0 && curX < grid.length && curY >= 0 && curY < grid[0].length && grid[curX][curY] == 1) {
                                    curAns++;
                                    queue.offer(new int[]{curX, curY});
                                    grid[curX][curY] = 0;//染色标记
                                }
                            }
                        }
                        ans = Math.max(ans, curAns);
                    }
                }
            }
            return ans;
        }
    }

}
