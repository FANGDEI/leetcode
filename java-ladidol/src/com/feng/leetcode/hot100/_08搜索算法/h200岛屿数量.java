/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._08搜索算法;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/11 10:47
 */
public class h200岛屿数量 {

  class Solution {

    public int numIslands(char[][] grid) {
      int ans = 0;
      mem = new int[grid.length][grid[0].length];
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (mem[i][j] != 1 && grid[i][j] != '0') {
            ans++;
            dfs(grid, i, j);
          }
        }
      }
      return ans;
    }

    void dfs(char[][] grid, int i, int j) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
        return;
      }
      if (grid[i][j] != '1' || mem[i][j] == 1) {
        return;
      } else {
        // 标记走过
        mem[i][j] = 1;
      }

      // 向右或者向下
      for (int[] dir : dirs) {
        dfs(grid, i + dir[0], j + dir[1]);
      }
    }

    int[][] mem;
    int[][] dirs = {{0, 1}, {1, 0},{0, -1}, {-1, 0}};
  }



}
