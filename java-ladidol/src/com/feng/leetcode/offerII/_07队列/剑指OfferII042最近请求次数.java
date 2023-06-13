package com.feng.leetcode.offerII._07队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/12 22:20
 * @description: {}
 */
public class 剑指OfferII042最近请求次数 {


    class RecentCounter {

        Deque<Integer> queue = new ArrayDeque<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }
            queue.offer(t);
            return queue.size();
        }
    }


}
