package com.feng.newline.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1260二维网格迁移
 * @author: Ladidol
 * @description: 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j]的元素将会移动到grid[i][j + 1]。
 * 位于grid[i][n- 1] 的元素将会移动到grid[i + 1][0]。
 * 位于 grid[m- 1][n - 1]的元素将会移动到grid[0][0]。
 * 请你返回k 次迁移操作后最终得到的 二维网格。
 * <p>
 * <p>
 * 简而言之就是: 一行一行网右边走,到最后一个就走到下一排.
 * @date: 2022/7/20 9:56
 * @version: 1.0
 */
public class L1260二维网格迁移 {

    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {

            //index = i * n + j;
            int m = grid.length;
            int n = grid[0].length;
            int len = n * m;
            k = k % len;
            List<List<Integer>> result = new ArrayList<>();
            int[] yiwei = new int[len];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int index = (i * n + j + k) % len;//转化为一维的坐标.
                    yiwei[index] = grid[i][j];
                }
            }
            for (int i = 0; i < m; i++) {
                List<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    tmp.add(yiwei[i * n + j]);//一层一层遍历出一维的数组.
                }
                result.add(tmp);
            }
            return result;
        }
    }
}
