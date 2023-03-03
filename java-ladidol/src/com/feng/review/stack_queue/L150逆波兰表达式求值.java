package com.feng.review.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L150逆波兰表达式求值
 * @author: Ladidol
 * @description:
 * @date: 2022/7/28 11:50 2023年3月3日10:50:23
 * @version: 1.0
 */
public class L150逆波兰表达式求值 {
    public static void main(String[] args) {
    }


    class Solution {
        Deque<Integer> stack = new LinkedList<>();

        public int evalRPN(String[] tokens) {
            for (String ch : tokens) {
                if (ch.equals("+")) {// String用equals
                    stack.push(stack.pop() + stack.pop());
                } else if (ch.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (ch.equals("-")) {
                    //减法和除法有前后顺序的要求, 做特殊处理.
                    stack.push(-stack.pop() + stack.pop());
                } else if (ch.equals("/")) {
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp2 / temp1);
                } else {
                    //放入数据
                    stack.push(Integer.valueOf(ch));
                }
            }
            return stack.peek();
        }
    }

}
