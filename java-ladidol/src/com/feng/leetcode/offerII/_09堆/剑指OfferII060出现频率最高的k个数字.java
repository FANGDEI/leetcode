package com.feng.leetcode.offerII._09堆;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/14 15:31
 * @description: {}
 */
public class 剑指OfferII060出现频率最高的k个数字 {


    //用哈希计数，entry入堆
    class Solution {

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (a, b) -> {
                    return b.getValue() - a.getValue();
                }
        );

        int k;
        Map<Integer, Integer> map = new HashMap<>();


        public int[] topKFrequent(int[] nums, int k) {
            this.k = k;
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                queue.offer(integerIntegerEntry);
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll().getKey();
            }
            return res;
        }
    }


}
