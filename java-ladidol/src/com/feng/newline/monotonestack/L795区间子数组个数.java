package com.feng.newline.monotonestack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/11/24 12:46
 * @description: 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * 示例 1：
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * 示例 2：
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 */
public class L795区间子数组个数 {


    //单调栈+乘法原理
    class Solution {
        //求每一个数最为最大值的贡献，感觉可以用单调栈来做。
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int n = nums.length;
            int[] leftEdge = new int[n];
            int[] rightEdge = new int[n];
            Arrays.fill(leftEdge, -1);
            Arrays.fill(rightEdge, n);
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                    rightEdge[stack.poll()] = i;
                }
                stack.push(i);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    leftEdge[stack.poll()] = i;
                }
                stack.push(i);
            }
            int ans = 0;
            //乘法原理
            for (int i = 0; i < n; i++) {
                if (nums[i] >= left && nums[i] <= right) {
                    ans += (i - leftEdge[i]) * (rightEdge[i] - i);
                }
            }
            return ans;
        }
    }
}