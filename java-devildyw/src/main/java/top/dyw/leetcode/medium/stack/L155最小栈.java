package top.dyw.leetcode.medium.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-08-09-11:28
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
@SuppressWarnings("all")
public class L155最小栈 {
    /**
     * 辅助栈 使用一个辅助栈来存储栈中的最小值
     */
    class MinStack {
        Deque<Integer> xStack;

        Deque<Integer> minStack;

        public MinStack() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        /**
         * 每次push元素时,都会将元素值与辅助栈中的值做比较 去最小值在push进辅助栈
         * @param val
         */
        public void push(int val) {
            xStack.push(val);
            minStack.push(Math.min(minStack.peek(), val)); //即如果当前值不小于辅助栈顶 就会将原来的栈顶再push一遍 这也是方便后续pop时pop最小值时同时辅助栈中的最小值也会被pop
        }

        /**
         * pop时 pop元素栈时也会pop 辅助栈
         */
        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
