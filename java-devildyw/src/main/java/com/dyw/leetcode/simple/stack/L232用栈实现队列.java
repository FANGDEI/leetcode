package com.dyw.leetcode.simple.stack;

import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-07-19-11:20
 * <p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * <p>
 * 你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * Your MyQueue object will be instantiated and called as such:
 * <p>
 * MyQueue obj = new MyQueue();
 * <p>
 * obj.push(x);
 * <p>
 * int param_2 = obj.pop();
 * <p>
 * int param_3 = obj.peek();
 * <p>
 * boolean param_4 = obj.empty();
 */
@SuppressWarnings("all")
public class L232用栈实现队列 {
    /**
     * 使用两个栈来构成栈
     */
    class MyQueue {
        //使用两个链表模拟栈 stack1是真正的队列 儿stack2只是辅助
        LinkedList<Integer> stackIn;
        LinkedList<Integer> stackOut;
        //队首元素
        private int front;

        public MyQueue() {
            stackIn = new LinkedList<>(); //负责进栈
            stackOut = new LinkedList<>(); //负责出栈
        }

        //push
        public void push(int x) {
            stackIn.push(x);
        }

        //pop
        public int pop() {
            dumpstackIn();
            return stackOut.pop();
        }

        //peek 返回队首元素
        public int peek() {
            dumpstackIn();
            return stackOut.peek();
        }

        //因为stack1是主体 所以返回stack1是否为空即可
        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        private void dumpstackIn() {
            if (!stackOut.isEmpty()) {
                return;
            }
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}

