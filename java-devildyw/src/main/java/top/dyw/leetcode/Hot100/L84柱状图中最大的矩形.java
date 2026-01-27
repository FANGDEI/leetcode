package top.dyw.leetcode.Hot100;

import java.util.*;
public class L84柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = heights.length;
        //添加哨兵节点
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, n);

        for (int i=0; i<newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                // 出栈
                int curIndex = stack.pop();

                int height = newHeights[curIndex];

                int rightIndex = i;

                int leftIndex = stack.peek();

                int width = rightIndex - leftIndex - 1;

                maxArea = Math.max(width * height, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
