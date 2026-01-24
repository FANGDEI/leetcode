package top.dyw.leetcode.Hot100;

import java.util.*;

public class L155最小栈 {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> temp;

        public MinStack() {
            stack = new LinkedList<>();
            temp = new LinkedList<>();
        }

        public void push(int val) {
            stack.push(val);
            if (temp.isEmpty()) {
                temp.push(val);
            } else {
                int minVal = Math.min(val, temp.peek());
                temp.push(minVal);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                temp.pop();
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            return -1;
        }

        public int getMin() {
            if (!temp.isEmpty()) {
                return temp.peek();
            }
            return -1;
        }
    }
}
