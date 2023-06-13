package com.feng.leetcode.offerII._07队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/11 18:44
 * @description: {}
 */
public class 剑指OfferII041滑动窗口的平均值 {


    class MovingAverage {

        Deque<Integer> deque = new ArrayDeque<>();
        int size;
        int sum = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            if (size == deque.size()) {
                int poll = deque.poll();
                sum -= poll;
            }
            deque.offer(val);
            sum += val;
            return sum / (double) deque.size();//求的是平均值，不是平摊值
        }
    }

}
