package com.feng.leetcode.offer._04栈与队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 剑指Offer59_II队列的最大值 {


    //就是实现优先级队列
    //https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/solutions/540181/jian-zhi-offer-59-ii-dui-lie-de-zui-da-z-0pap/?envType=study-plan-v2&envId=coding-interviews
    class MaxQueue {

        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> help = new LinkedList<>();//单调队列(必须用双端队列deque)


        /**
         * 和30题寻找min函数的栈有区别。这刚好是栈和队列最本质的区别啊，栈能保证pop后完全回到上次push前的状态
         */
        public MaxQueue() {

        }

        public int max_value() {
            return help.isEmpty() ? -1 : help.peek();
        }

        /**
         * 对于正常队列，一个最大值，可以影响当前整个队列，需要维护一个单调队列来记录最大值排列。
         *
         * @param value
         */
        public void push_back(int value) {
            queue.offer(value);
            while (!help.isEmpty() && help.peekLast() < value) {
                //维护递减队列
                help.pollLast();
            }
            help.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            int poll = queue.poll();
            if (poll == help.peekFirst()) {
                help.pollFirst();
            }
            return poll;

        }
    }


}
