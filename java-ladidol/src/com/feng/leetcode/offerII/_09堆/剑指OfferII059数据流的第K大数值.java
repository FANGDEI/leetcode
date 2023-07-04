package com.feng.leetcode.offerII._09堆;

import java.util.PriorityQueue;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/14 15:19
 * @description: {}
 */
public class 剑指OfferII059数据流的第K大数值 {


    /**
     * 第k大，或者第k小，一般都是用优先级队列：维护k大小的优先级队列就行了。
     */
    class KthLargest {

        PriorityQueue<Integer> queue = new PriorityQueue();//默认：从小到大，取队列头就行了。
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                queue.offer(num);
            }
            while (queue.size() > k) {
                queue.poll();
            }
        }

        public int add(int val) {
            queue.offer(val);
            if (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }

}
