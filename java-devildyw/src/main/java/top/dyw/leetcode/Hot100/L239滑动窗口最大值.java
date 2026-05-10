package top.dyw.leetcode.Hot100;

import java.util.PriorityQueue;
// 堆来做 这种滑动取最大值的场景 惰性删除
public class L239滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> {
            return b[0] - a[0];
        });

        for (int i=0; i<k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        int index = 0;
        result[index++] = maxHeap.peek()[0];

        for (int i=k; i<n; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            while (maxHeap.peek()[1] < index) {
                maxHeap.poll();
            }
            result[index++] = maxHeap.peek()[0];
        }

        return result;
    }
}
