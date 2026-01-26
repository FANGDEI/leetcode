package top.dyw.leetcode.Hot100;

import java.util.*;
public class L739每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        // 单调栈 这里记录的是下标
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                result[preIndex] = i-preIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
