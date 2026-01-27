package top.dyw.leetcode.Hot100;
import java.util.*;
public class L347前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        // 大顶堆
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b)->(a[1] - b[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (heap.size() >= k) {
                if (heap.peek()[1] < map.get(key)) {
                    heap.poll();
                    heap.offer(new int[]{key, map.get(key)});
                }
            } else {
                heap.offer(new int[]{key, map.get(key)});
            }
        }
        int[] result = new int[k];

        while (!heap.isEmpty()) {
            result[k-1] = heap.poll()[0];
            k--;
        }
        return result;
    }
}
