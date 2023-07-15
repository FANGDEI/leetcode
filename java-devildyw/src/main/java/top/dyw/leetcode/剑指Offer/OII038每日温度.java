package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/07/13 11:48
 **/
@SuppressWarnings("all")
public class OII038每日温度 {

    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n]; //默认元素为0

        //单调栈 存储下表 递减
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return ans;
    }
}
