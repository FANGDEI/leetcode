package com.feng.review.stack_queue;



import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L347前K个高频元素
 * @author: Ladidol
 * @description:
 * @date: 2022/7/28 15:46 2023年3月3日10:53:47
 * @version: 1.0
 */
public class L347前K个高频元素 {


    //优先级队列
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            //构建大顶堆
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.offer(entry);
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll().getKey();
            }
            return res;
        }
    }
}
