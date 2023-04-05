package top.dyw.leetcode.剑指Offer;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Devil
 * @since 2023-02-28-11:00
 */
@SuppressWarnings("all")
public class O30包含min函数的栈 {

    class MinStack {
        private final Stack<Integer> stack;

        private final LinkedList<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            //辅助栈
            min = new LinkedList<>();
            min.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            min.push(Math.min(x,min.peek()));
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
