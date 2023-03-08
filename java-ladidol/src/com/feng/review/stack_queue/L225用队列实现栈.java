package com.feng.review.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
 * @date: 2022/7/27 21:38 2023年3月3日10:24:37
 * @version: 1.0
 */
public class L225用队列实现栈 {

    class MyStack {

        Queue<Integer> queueMaster = new LinkedList<>();
        Queue<Integer> queueslave = new LinkedList<>();


        public MyStack() {
        }

        public void push(int x) {
            queueMaster.offer(x);

        }

        /**
         * 通过去除最后一个进去的元素，出stack顶元素pop。
         *
         * @return
         */
        public int pop() {
            int size = queueMaster.size();
            while (size-- > 1) {
                queueslave.offer(queueMaster.poll());
            }
            int res = queueMaster.poll();
            queueMaster = queueslave;
            queueslave = new LinkedList<>();
            return res;
        }

        /**
         * 用双端队列可能就不需要这样了，就可以直接返回addLast元素就行
         *
         * @return
         */
        public int top() {
            int size = queueMaster.size();
            while (size-- > 1) {
                queueslave.offer(queueMaster.poll());
            }
            int res = queueMaster.poll();
            queueslave.offer(res);
            queueMaster = queueslave;
            queueslave = new LinkedList<>();
            return res;
        }

        public boolean empty() {
            return queueMaster.size() == 0;
        }
    }

}
