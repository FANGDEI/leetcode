package com.feng.面试题;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/21 13:28
 * @description: {}
 */
public class Solution6 {
    //单调栈


    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int left = stack.peek();
                    int right = i;
                    int width = right - left - 1;//注意底部的宽是需要减一的
                    int high = Math.min(height[right], height[left]) - height[mid];
                    ans += width * high;
                }
            }
            stack.push(i);
        }
        return ans;
    }


}
