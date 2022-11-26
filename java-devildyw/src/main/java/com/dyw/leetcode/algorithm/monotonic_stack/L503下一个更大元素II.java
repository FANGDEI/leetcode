package com.dyw.leetcode.algorithm.monotonic_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-11-26-19:45
 */
@SuppressWarnings("all")
public class L503下一个更大元素II {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums==null||nums.length<=1){
            return new int[]{-1};
        }

        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        //虽然是循环但起始完整走两趟即可
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty()&&nums[i%n]>nums[stack.peek()]){
                res[stack.peek()] = nums[i%n];
                stack.pop();
            }
            stack.push(i%n);
        }
        return res;
    }
}
