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
        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;
        //队首元素
        private int front;

        public MyQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        //push
        public void push(int x) {
            //如果此时队列为空 那么队首元素就是这个第一个加入的元素 如果不为空队首元素依旧是原来的那个队首元素不会改变
            if (empty()) {
                front = x;
            }
            //如果stack1不为空 将stack1的元素存入stack2 改变原来的顺序 因为需要将新的元素存入队列末尾 而栈只会将元素添加进队首
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            //这样之后将x添加进stack2中
            stack2.push(x);
            //再将stack2的元素回填进stack1中 这样新添加的元素就会跑到stack1的底层
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        //pop
        public int pop() {
            //pop后更新front(队首元素)
            Integer pop = stack1.pop();
            if (!empty()) {
                front = stack1.peek();
            }
            return pop;
        }

        //peek 返回队首元素
        public int peek() {
            return front;
        }

        //因为stack1是主体 所以返回stack1是否为空即可
        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}
