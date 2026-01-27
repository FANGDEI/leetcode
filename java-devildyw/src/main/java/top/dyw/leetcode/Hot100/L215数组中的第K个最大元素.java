package top.dyw.leetcode.Hot100;
import java.util.*;
public class L215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆 堆里面维护最大元素 一旦到达k个 那么就绪要出堆 一旦下一个元素大于堆顶元素 那么就出堆并入堆 这样小顶堆里面留着的就是k个最大元素 并且堆顶是最小的最大元素 恰好是第k个
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> {return a-b;});
        for (int i=0; i<nums.length; i++) {
            if (heap.size() >= k) {
                if (heap.peek() < nums[i]) {
                    heap.poll();
                    heap.offer(nums[i]);
                }
            } else {
                heap.offer(nums[i]);
            }

        }
        return heap.peek();
    }
}
