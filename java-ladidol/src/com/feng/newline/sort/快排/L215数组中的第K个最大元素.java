package com.feng.newline.sort.快排;

import java.util.PriorityQueue;

/**
 * @author: ladidol
 * @date: 2022/10/10 9:30
 * @description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class L215数组中的第K个最大元素 {

    //优先级队列
    class Solution1 {
        /**
         * 参数：[nums, k]
         * 返回值：int
         * 作者： ladidol
         * 描述：用库函数中的优先级队列和排序算法都是这样的，能做出来但是时间复杂度都为O（nlogn）不符合题意的O（n）
         */
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            for (int num : nums) {
                queue.offer(num);
            }
            int ans = -1;
            while (k-- > 0) {
                ans = queue.poll();
            }
            return ans;
        }
    }

    // 堆again
    class Solution {// 2022年10月22日14:53:57

        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.offer(num);
            }
            int ans = -1;
            k = nums.length - k + 1;
            while (k-- > 0) {
                ans = queue.poll();
            }
            return ans;
        }
    }


    //基于快排的快速排序，待做。


}