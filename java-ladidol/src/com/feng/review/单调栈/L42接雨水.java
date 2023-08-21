package com.feng.review.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/16 20:52
 * @description: {}
 */
public class L42接雨水 {


    class Solution1 {
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
//                        System.out.println("area = " + area);
                        ans += area;
                    }
                }
                stack.push(i);
            }
            return ans;
        }
    }
    //单调栈复习来咯
    class Solution {
        /**
         * 解：先用单调栈来做，需要三个指针，底和两边的高
         * 维护一个单调递减的栈，栈顶是底，栈顶第二个元素师左边的高，当前大于栈底的元素为右边的高
         *
         * @param h
         * @return
         */
        public int trap(int[] h) {
            Stack<Integer> stack = new Stack<>();
            int n = h.length;
            stack.push(0);//初始化左边的高(可能为高

            int ans = 0;

            for (int i = 1; i < n; i++) {
                int right = i;
                while (!stack.isEmpty() && h[stack.peek()] < h[right]) {
                    int di = stack.pop();
                    if (stack.isEmpty()) {
                        continue;
                    }
                    int left = stack.peek();
                    ans += (Math.min(h[left], h[right]) - h[di]) * (right - left - 1);
                }
                stack.push(right);
            }
            return ans;
        }
    }
}
