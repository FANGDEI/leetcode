package top.dyw.leetcode.Hot100;

import java.util.*;
public class L84柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[n+2];
        System.arraycopy(heights, 0, newHeights, 1, n);
        int result = 0;
        for (int i=0; i<newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int preIndex = stack.pop();
                int height = newHeights[preIndex];

                int leftIndex = stack.peek();
                int width = i - leftIndex - 1;

                result = Math.max(result, height * width);
            }
            stack.push(i);
        }
        return result;
    }
}
