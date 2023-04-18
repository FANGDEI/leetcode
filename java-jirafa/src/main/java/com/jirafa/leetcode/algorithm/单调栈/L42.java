package com.jirafa.leetcode.algorithm.单调栈;

import java.util.Arrays;
import java.util.LinkedList;

public class L42 {
    public int trap(int[] height) {
        int sum=0;
        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(0);

        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty()&&height[stack.peek()]<height[i]){
                Integer pop = stack.pop();
                if(!stack.isEmpty()){
                    int high=Math.min(height[stack.peek()],height[i])-height[pop];
                    int width=i-stack.peek()-1;
                    sum+=high*width;
                }
            }
            stack.push(i);
        }

        return sum;
    }
}
