package com.feng.newline.monotonestack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/10/3 20:32
 * @description: 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class L42接雨水 {
    //单调栈
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            Deque<Integer> stack = new ArrayDeque<>();
            int ans = 0;
            //先初始化
            stack.push(0);
            for (int i = 1; i < n; i++) {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int right = i;
                        int width = right - left - 1;
                        int high = Math.min(height[left], height[right]) - height[mid];//取最短的边。
                        ans += width * high;
                    }
                }
                // 很细节的一个相等处理，相等的时候也会push进栈，// 因为相等的相邻墙，左边一个是不可能存放雨水的。
                stack.push(i);
            }

            return ans;
        }
    }


}