package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author Devildyw
 * @date 2023/04/18 20:25
 **/
@SuppressWarnings("all")
public class O59II队列的最大值 {

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }

    /**
     * 单调队列 维护一个单调递减的队列
     */
    static class MaxQueue {
        Deque<Integer> queue = null;
        Deque<Integer> deque = null;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            deque = new ArrayDeque<>();
        }

        public int max_value() {
            return deque.isEmpty()?-1:deque.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty()&&deque.peekLast()<value){
                deque.removeLast();
            }
            deque.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            if (queue.peekFirst().equals(deque.peekFirst())){
                deque.pollFirst();
            }
            return queue.pollFirst();
        }
    }
}
