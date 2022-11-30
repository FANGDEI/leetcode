package com.dyw.leetcode.algorithm.monotonic_stack;

import java.awt.font.NumericShaper;
import java.util.Stack;

/**
 * @author Devil
 * @since 2022-11-28-11:30
 */
@SuppressWarnings("all")
public class L84柱状图中最大的矩形 {

    public static void main(String[] args) {
        System.out.println(new L84柱状图中最大的矩形().largestRectangleArea(new int[]{2,1,2}));

    }

    public int largestRectangleArea(int[] heights) {
        int max = -1;

        int[] newHights = new int[heights.length+2];
        newHights[0] = 0;
        newHights[newHights.length-1] = 0;
        for (int i = 0; i < heights.length; i++) {
            newHights[i+1] = heights[i];
        }
        heights = newHights;

        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        max = heights[0];

        for (int i = 1; i < n; i++) {
            if (heights[i]>=heights[stack.peek()]){
                stack.push(i);
                max = Math.max(max,heights[i]);
            }else{
                while (heights[i]<heights[stack.peek()]){
                    int mid = stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int w = right - left -1;
                    int h = heights[mid];
                    max = Math.max(max,w*h);
                }
                stack.push(i);
            }
        }
        return max;
    }

}
