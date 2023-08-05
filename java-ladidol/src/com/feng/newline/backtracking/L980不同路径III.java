package com.feng.newline.backtracking;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/4 17:47
 * @description: {
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * }
 */
public class L980不同路径III {


    //dfs
    class Solution {

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;
        int startX = 0, startY = 0;//初始化起点坐标
        int n, m;
        int cnt0 = 0;


        public int uniquePathsIII(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            int[] starts = getStart(grid);

            System.out.println("cnt0 = " + cnt0);

            dfs(grid, startX, startY, cnt0 + 1);//起点也可以算是一个可到达点
            return ans;
        }

        /**
         * 每一个无障碍格子都要通过
         *
         * @param grid
         * @param x
         * @param y
         */
        void dfs(int[][] grid, int x, int y, int leave) {

            System.out.println(x + ", " + y + " count = " + leave);

            if (grid[x][y] == -1) return;
            if (grid[x][y] == 2 && leave == 0) {
                ans++;//找到答案了
                return;
            }
            if (grid[x][y] == 2) {
                //非正常到达终点，也需要停止
                return;
            }
            grid[x][y] = -1;//染色
            for (int[] dir : dirs) {
                int curX = dir[0] + x, curY = dir[1] + y;
                if (curX < n && curX >= 0 && curY < m && curY >= 0) {
                    dfs(grid, curX, curY, leave - 1);
                }
            }
            grid[x][y] = 0;
        }

        int[] getStart(int[][] grid) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 0) cnt0++;//记录有多少个无障碍格子
                    else if (grid[i][j] == 1) {
                        startX = i;
                        startY = j;
                    }
                }
            }
            return new int[]{0, 0};
        }
    }

}
