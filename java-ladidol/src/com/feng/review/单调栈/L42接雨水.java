package com.feng.review.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/16 20:52
 * @description: {}
 */
public class L42接雨水 {


    class Solution {
        /**
         * 左边为高，记录右边界左邻居一个为底。
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int ans = 0;
            for (int i = 1; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int end = stack.pop();
                    if (!stack.isEmpty()) {
                        int hight = Math.min(height[stack.peek()], height[i]) - height[end];
                        int width = i - stack.peek() - 1;
                        int area = hight * width;
                        System.out.println("area = " + area);
                        ans += area;
                    }
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
