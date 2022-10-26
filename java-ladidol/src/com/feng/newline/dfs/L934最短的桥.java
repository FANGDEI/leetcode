package com.feng.newline.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/10/25 15:15
 * @description: 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * 返回必须翻转的 0 的最小数目。
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] 为 0 或 1
 * grid 中恰有两个岛
 */
public class L934最短的桥 {


    //dfs+bfs
    class Solution {
        /**
         * 参数：[grid]
         * 返回值：int
         * 作者： ladidol
         * 描述：值得注意的是题中最初是只有两个岛的，这样一看就简单很多了。
         * 两次DFS会超时
         * 第一次DFS找出其中的一个岛，全部标记为2
         * 在第一个岛的基础上，之后对另一个岛进行BFS，向外进行扩展，当遇到2时，扩展的层数即是答案
         */
        public int shortestBridge(int[][] grid) {
            //先对其中的一个岛进行染色。
            out:
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j);
                        break out;
                    }
                }
            }
            //对第二个到进行向外扩层。
            int ans = bfs(grid);
            return ans;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> queue = new ArrayDeque<>();

        void dfs(int[][] grid, int i, int j) {
            if (grid[i][j] == 0 || grid[i][j] == 2) return;
            queue.offer(new int[]{i, j});//将第一层的染色岛给存入队列中。
            grid[i][j] = 2;
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                    dfs(grid, x, y);
                }
            }
        }

        //bfs类似树的层序遍历，通过队列来操作。
        int bfs(int[][] grid) {

            int ans = 0;
            while (!queue.isEmpty()) {
                int curSize = queue.size();
                while (curSize > 0) {
                    int[] tmp = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = tmp[0] + dirs[k][0];
                        int y = tmp[1] + dirs[k][1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                            if (grid[x][y] == 1) return ans;
                            else if (grid[x][y] == 0) {
                                grid[x][y] = 2;
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }

                    curSize--;
                }
                ans++;//层数自加
            }
            return ans;
        }
    }
}
















