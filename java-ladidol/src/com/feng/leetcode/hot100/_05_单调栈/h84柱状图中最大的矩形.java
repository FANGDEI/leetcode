/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._05_单调栈;

import java.util.Stack;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/8 11:29
 */
public class h84柱状图中最大的矩形 {


  static class Solution {

    // 用原始的三次遍历，获取到当前i的最左边和最右边。
    public int largestRectangleArea(int[] heights) {
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

      // 计算当前i的最大矩形面积
      int maxArea = -1;
      for (int i = 0; i < n; i++) {
        maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));

      }
      return maxArea;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] heights = {0,9};
    int i = solution.largestRectangleArea(heights);
    System.out.println("i = " + i);
  }


}
