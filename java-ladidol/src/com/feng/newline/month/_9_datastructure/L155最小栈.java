package com.feng.newline.month._9_datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L155最小栈
 * @author: Ladidol
 * @description: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * 示例 1:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 提示：
 * <p>
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push,pop,top, and getMin最多被调用3 * 104 次
 * @date: 2022/9/13 21:26
 * @version: 1.0
 */
public class L155最小栈 {

    public static void main(String[] args) {
    }


}

// 根据题解，我们用双栈模拟：stack和help。其中help同步保存当前加入后的最小值。
class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> help = new Stack<>();


    // 为了避免出现stack.pop完了，min没有恢复初始化的情况，这里就不要把min单独拿出来。
    // 当前min==help.peek()or help的第一个元素。
    public void push(int val) {

        if (stack.isEmpty() || val < help.peek()) {
            help.push(val);
        } else {
            help.push(help.peek());
        }
        stack.push(val);

    }

    public void pop() {
        stack.pop();
        help.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return help.peek();
    }
}

class MinStack1 {
    Deque<Integer> data = new ArrayDeque<>();
    Deque<Integer> help = new ArrayDeque<>();

    public void push(int val) {
        data.addLast(val);
        if (help.isEmpty() || help.peekLast() >= val) {
            help.addLast(val);
        } else {
            help.addLast(help.peekLast());
        }
    }

    public void pop() {
        data.pollLast();
        help.pollLast();
    }

    public int top() {
        return data.peekLast();
    }

    public int getMin() {
        return help.peekLast();
    }
}

