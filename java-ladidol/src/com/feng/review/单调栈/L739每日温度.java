package com.feng.review.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/16 20:11
 * @description: {}
 */
public class L739每日温度 {

    //单调栈模板题
    class Solution {

        public int[] dailyTemperatures(int[] temp) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int[] res = new int[temp.length];

            for (int i = 1; i < temp.length; i++) {
                while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);

            }
//            System.out.println("res = " + Arrays.toString(res));
            return res;
        }
    }


}
