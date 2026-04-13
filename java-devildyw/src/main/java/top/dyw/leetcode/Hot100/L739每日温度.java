package top.dyw.leetcode.Hot100;

import java.util.*;
public class L739每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque();
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i-index;
            }
            stack.push(i);
        }

        return result;
    }
}
