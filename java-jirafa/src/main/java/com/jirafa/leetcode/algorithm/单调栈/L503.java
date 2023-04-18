package com.jirafa.leetcode.algorithm.单调栈;

import java.util.Arrays;
import java.util.LinkedList;

public class L503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(0);

        for (int i = 1; i < nums.length * 2; i++) {
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i%nums.length]){
                Integer pop = stack.pop();
                res[pop]=nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }

        return res;
    }
}
