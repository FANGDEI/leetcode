package com.feng.review.优先级队列;

import java.util.PriorityQueue;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L239滑动窗口最大值
 * @author: Ladidol
 * @description: 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * @date: 2022/7/28 14:48 2023年2月24日22:43:21 很久以前yy给我做过，然后就是这次新希望六和面试官问到了，然后没做出来
 * @version: 1.0
 */
public class L239滑动窗口最大值 {


    // 2022年9月22日23:59:05今天再来重新做一下
    // 2023年2月27日21:13:34说实话那个单调栈有点模糊，我们就用这个优先级队列来做吧。

    // 方法一：优先队列（堆）
    // 根据题意，容易想到优先队列（大根堆），同时为了确保滑动窗口的大小合法性，我们以二元组 (idx, nums[idx])(idx,nums[idx]) 的形式进行入队。
    //    当下标达到首个滑动窗口的右端点后，每次尝试从优先队列（大根堆）中取出最大值（若堆顶元素的下标小于当前滑动窗口左端点时，则丢弃该元素）。
    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 只在取出的时候判断它是不是符合在这个范围里面
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);//二元组 0：下标 1：数值。
            int[] res = new int[nums.length - k + 1];//答案数组大小和k的关系
            int index = 0;

            for (int i = 0; i < nums.length; i++) {
                queue.offer(new int[]{i, nums[i]});
                if (i >= k - 1) {
                    while (queue.peek()[0] < i - k + 1) queue.poll();//丢去不在框框里面的元素。
                    res[index++] = queue.peek()[1];
                }
            }
            return res;
        }
    }

    static class Solution {
        /**
         * 维护单调队列，本题队列First元素有用，但是一个队列中不只一个数字，可以从队列First添加Max，队列Last是以前入队列的，但是还是可以当候选者（候选者可能会被淘汰）
         * ！！！！！ 注意理解队列最前面元素表示的当前区间的最大值！！！！
         * @param nums
         * @param k
         * @return
         */
//        public int[] maxSlidingWindow(int[] nums, int k) {
            //这边建议不要用单调队列，直接用优先级队列就行。
//            ArrayDeque<Integer> queue = new ArrayDeque<>();
//            int[] res = new int[nums.length - k + 1];
//            int index = 0;
//            for (int i = 0; i < nums.length; i++) {
//                //1.维护队列中的数都在k区间中
//                if (!queue.isEmpty() && queue.peekLast() < i - k + 1) {
//                    queue.pollLast();
//                }
//                //2.维护队列最大值（维护k区间的最大值）
//                while (!queue.isEmpty() && nums[queue.peekFirst()] < nums[i]) {
//                    queue.pollFirst();
//                }
//                queue.offerFirst(i);//从队列前面添加
//                //第2步到此结束
//
//                //维护队列末尾的最大值咯
//                if (i >= k - 1) {
//                    res[index++] = nums[queue.peekLast()];
//                }
//            }
//            return res;
//        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,1,2,0,5};
//        int[] ints = solution.maxSlidingWindow(nums, 3);
//        System.out.println("ints = " + Arrays.toString(ints));
    }


}
