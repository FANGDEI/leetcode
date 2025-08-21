package com.feng.leetcode.hot100._05单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author fengxiaoqiang
 * @since 2025/8/6 10:32
 */
public class h739每日温度 {

  static class Solution {

    // 保证栈从下到上单调递减
    public int[] dailyTemperatures(int[] temperatures) {

      int[] answer = new int[temperatures.length];
      Stack<Integer> stack = new Stack<>();
      // 存在压栈和弹出两种场景，都需要更新对应天的温度。
      for (int i = 0; i < temperatures.length; i++) {
        if (stack.isEmpty()) {
          stack.push(i);
          continue;
        }
        int curTemp = temperatures[stack.peek()];
        if (curTemp >= temperatures[i]) {
          stack.push(i);
        } else {
          while ((!stack.isEmpty()) && temperatures[stack.peek()] < temperatures[i]) {
            int cur = stack.pop();
            answer[cur] = i - cur;
          }
          stack.push(i);
        }
      }
      while (!stack.isEmpty()) {
        int cur = stack.pop();
        answer[cur] = 0;
      }
      return answer;
    }
  }


  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
    int[] ints = solution.dailyTemperatures(temp);
    System.out.println("ints = " + Arrays.toString(ints));
  }

}
