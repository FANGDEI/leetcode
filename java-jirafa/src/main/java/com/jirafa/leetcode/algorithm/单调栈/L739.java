package com.jirafa.leetcode.algorithm.单调栈;

import java.util.LinkedList;
import java.util.Stack;

public class L739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] resault = new int[temperatures.length];
        LinkedList<Integer> stack=new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                Integer pop = stack.pop();
                resault[pop]=i-pop;
            }
            stack.push(i);
        }
        return resault;
    }

    public static void main(String[] args) {
        System.out.println(new L739().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}).toString());
    }
}
