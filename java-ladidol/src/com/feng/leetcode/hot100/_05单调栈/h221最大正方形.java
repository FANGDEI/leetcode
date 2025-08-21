/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._05单调栈;

import java.util.Stack;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/8 11:51
 */
public class h221最大正方形 {


  class Solution {

    /**
     * 求最大正方形面积
     *
     * @param matrix 字符矩阵
     * @return 最大正方形面积
     */
    public int maximalSquare(char[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return 0;
      }
      int m = matrix.length, n = matrix[0].length;
      int[] heights = new int[n];
      int maxSide = 0;
      // 每一行都更新高度数组
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
        }
        // 用单调栈求每一行的最大正方形边长
        maxSide = Math.max(maxSide, getMaxSquareSide(heights));
      }
      return maxSide * maxSide;
    }

    /**
     * 单调栈求最大正方形边长
     *
     * @param heights 高度数组
     * @return 最大边长
     */
    private int getMaxSquareSide(int[] heights) {
      int n = heights.length;
      Stack<Integer> stack = new Stack<>();
      int[] left = new int[n];
      int[] right = new int[n];
      // 寻找最左边
      for (int i = 0; i < n; i++) {
        // 寻找左边第一个小于当前值高的
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
          stack.pop();
        }
        left[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(i);
      }
      stack.clear();
      // 寻找最右边
      for (int i = n - 1; i >= 0; i--) {
        // 寻找右边第一个小于当前值高的
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
          stack.pop();
        }
        right[i] = stack.isEmpty() ? n : stack.peek();
        stack.push(i);
      }

      // 计算当前i的最大正方形边长
      int maxSide = 0;
      for (int i = 0; i < n; i++) {
        int side = Math.min(heights[i], (right[i] - left[i] - 1));
        maxSide = Math.max(maxSide, side);

      }

      return maxSide;
    }

  }

}
