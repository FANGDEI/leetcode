package com.feng.leetcode.offer._04栈与队列;

import java.util.PriorityQueue;

public class 剑指Offer59_I滑动窗口的最大值 {


    //优先队列
    class Solution {
        /**
         * 注意默认是小顶堆。
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
                return b[1] - a[1];
            });//大顶堆
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                queue.offer(new int[]{i, nums[i]});
                if (i + 1 >= k) {
                    int[] max = queue.peek();
                    while (i - max[0] >= k) {
                        queue.poll();
                        max = queue.peek();
                    }
                    res[i - k + 1] = max[1];
                }
            }
            return res;
        }
    }

}
