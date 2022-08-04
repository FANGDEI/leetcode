package com.feng.newline.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L225用队列实现栈
 * @author: Ladidol
 * @description: 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 示例：
 *
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 *
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 *
 * @date: 2022/7/27 21:38
 * @version: 1.0
 */
public class L225用队列实现栈 {
    public static void main(String[] args) {
//
//        MyStack myStack = new MyStack();
//        myStack.push(1);
//        myStack.push(2);
//        System.out.println("myStack.top() = " + myStack.top()); // 返回 2
//        System.out.println("myStack.pop() = " + myStack.pop()); // 返回 2
//        System.out.println("myStack.empty() = " + myStack.empty()); // 返回 False
    }
    class MyStack {

        Deque<Integer> stack;

        public MyStack() {
            stack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

}
