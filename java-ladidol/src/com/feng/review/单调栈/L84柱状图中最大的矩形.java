package com.feng.review.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/16 21:16
 * @description: {}
 */
public class L84柱状图中最大的矩形 {

    class Solution {
        public int largestRectangleArea(int[] heights) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            //这里需要做一下特殊处理，因为这只要有高度就一定有面积，所以左右可以加一个0高的虚拟柱状图
            int[] newHeights = new int[heights.length + 2];
            newHeights[newHeights.length - 1] = 0;
            newHeights[0] = 0;
            //数组向右边移动一位；
            for (int i = 0; i < heights.length; i++) {
                newHeights[i + 1] = heights[i];
            }
//            System.out.println("newHeights = " + Arrays.toString(newHeights));
            int ans = 0;
            for (int i = 1; i < newHeights.length; i++) {
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    int mid = stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int h = newHeights[mid];
                    int w = right - left - 1;
                    int area = h * w;
                    ans = Math.max(area, ans);
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
