package com.feng.leetcode.offerII._09堆;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/14 15:44
 * @description: {}
 */
public class 剑指OfferII061和最小的k个数对 {


    class Solution {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
                (a, b) -> {
                    return (a.get(0) + a.get(1)) - (b.get(0) + b.get(1));
                }
        );


        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    queue.offer(Arrays.asList(nums1[i], nums2[j]));
                }
            }
            List<List<Integer>> res = new LinkedList<>();
            k = Math.min(queue.size(), k);
            for (int i = 0; i < k; i++) {
                res.add(queue.poll());
            }

            return res;
        }
    }
}
