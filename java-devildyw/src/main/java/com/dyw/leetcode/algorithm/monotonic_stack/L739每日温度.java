package com.dyw.leetcode.algorithm.monotonic_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-11-25-11:13
 */
@SuppressWarnings("all")
public class L739每日温度 {
    public static void main(String[] args) {
        int[] ints = new L739每日温度().dailyTemperatures01(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

    /**
     * 单调栈：通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        /**
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */
        Deque<Integer> stack = new LinkedList<>();
        //先将首元素的第一个下标值push
        stack.push(0);
        for (int i = 1; i < n; i++) {
            //如果当前遍历的元素 小于 栈顶元素 直接入栈 当前栈还是单调的
            if (temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else{
                //如果大于栈顶元素且此时栈不为空（当前遍历的元素T[i]大于栈顶元素T[st.top()]的情况） 代表此时栈不为单调 需要出栈 表示当前元素就是大于栈顶元素的第一个元素 所以记录结果
                while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()] = i-stack.peek();
                    stack.pop();
                }
                //如果此时栈为空则入栈
                stack.push(i);
            }
        }
        return res;
    }

    /**
     * 暴力 会超时
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures01(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (temperatures[j]>temperatures[i]){
                    ans[i] = j-i;
                    break;
                }
            }
        }
        return ans;
    }
}
