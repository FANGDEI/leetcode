package top.dyw.leetcode.剑指Offer;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author Devildyw
 * @date 2023/08/07 13:02
 **/
@SuppressWarnings("all")
public class O061查找和最小的K对数字 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1));

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length ; j++) {
                List<Integer> list = Arrays.asList(nums1[i], nums2[j]);
                if (priorityQueue.size() < k) {
                    priorityQueue.offer(list);
                } else {
                    if (list.get(0) + list.get(1) < priorityQueue.peek().get(0) + priorityQueue.peek().get(1)) {
                        priorityQueue.poll();
                        priorityQueue.offer(list);
                    }
                }
            }
        }

        List<List<Integer>> res = priorityQueue.stream().map((item) -> item).collect(Collectors.toList());
        return res;
    }
}
