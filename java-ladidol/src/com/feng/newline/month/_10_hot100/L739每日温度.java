package com.feng.newline.month._10_hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.monotonestack
 * @className: L739每日温度
 * @author: Ladidol
 * @description: 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * 提示：
 * <p>
 * 1 <=temperatures.length <= 105
 * 30 <=temperatures[i]<= 100
 * @date: 2022/9/10 15:49
 * @version: 1.0
 */
public class L739每日温度 {

    //单调栈
    class Solution1 {
        // 注意栈的一些操作名称pop，peek，push
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new LinkedList<>();
            int[] res = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();//计算距离
                    stack.pop();
                }
                stack.push(i);//加入角标
            }
            return res;
        }
    }

    // 单调栈
    class Solution {
        //2022年10月2日12:55:59再做。
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[temperatures.length];
            for (int i = 0; i < res.length; i++) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    res[stack.peek()] = i - stack.peek();//计算距离。
                    stack.pop();
                }
                stack.push(i);
            }
            return res;
        }
    }


}
