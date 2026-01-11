package top.dyw.leetcode.Hot100;

import java.util.PriorityQueue;
// 堆来做 这种滑动取最大值的场景 惰性删除
public class L239滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {


        int start = 0;
        int[] result = new int[nums.length-k+1];
        int index = 0;
        // 大顶堆 堆顶是整个堆的最大值
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b)->{
            return b[0] - a[0];
        });

        for(int i=0; i<k; i++) {
            maxHeap.offer(new int[]{nums[i],i});
        }

        result[index++] = maxHeap.peek()[0];

        for(int i=k; i<nums.length; i++) {
            maxHeap.offer(new int[]{nums[i],i});
            start++;
            while(start > maxHeap.peek()[1]) {
                maxHeap.poll();
            }
            result[index++] = maxHeap.peek()[0];
        }

        return result;
    }
}
