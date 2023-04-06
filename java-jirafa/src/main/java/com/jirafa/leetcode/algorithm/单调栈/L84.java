package com.jirafa.leetcode.algorithm.单调栈;

import java.util.Arrays;
import java.util.LinkedList;

public class L84 {

    public int largestRectangleArea(int[] heights) {
        int[] temp = new int[heights.length + 2];
        temp[0] =0;
        temp[temp.length-1] =0;
        int i=1;
        for(int num:heights){
            temp[i++] = num;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;

        stack.push(0);

        for (int j = 1; j < temp.length; j++) {
            while (!stack.isEmpty() && temp[stack.peek()]>temp[j]){
                Integer pop = stack.pop();
                if(!stack.isEmpty()){
                    int l=stack.peek();
                    int r=j;
                    result=Math.max((r-l-1)*temp[pop],result);
                }
            }
            stack.push(j);
        }

        return result;
    }
}
