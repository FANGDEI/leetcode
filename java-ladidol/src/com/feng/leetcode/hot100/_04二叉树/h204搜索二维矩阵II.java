/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._04二叉树;

/**
 * @author fengxiaoqiang
 * @since 2025/8/4 11:41
 */
public class h204搜索二维矩阵II {

  class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
      int x = 0, y = matrix[0].length - 1;
      while (x < matrix.length && y >= 0) {
        if (matrix[x][y] == target) {
          return true;
        }
        if (matrix[x][y] < target) {
          x++;
        } else if (matrix[x][y] > target) {
          y--;
        }
      }
      return false;
    }
  }
}
