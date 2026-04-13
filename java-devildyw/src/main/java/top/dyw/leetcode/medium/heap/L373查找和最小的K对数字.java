package top.dyw.leetcode.medium.heap;
import java.util.*;
public class L373查找和最小的K对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
        });

        int m = nums1.length;
        int n = nums2.length;
        for (int i=0; i<Math.min(m, k); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        while (k>0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int i = cur[0];
            int j = cur[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;
            if (j+1 < nums2.length) {
                minHeap.offer(new int[]{i,j+1});
            }
        }
        return result;
    }
}
