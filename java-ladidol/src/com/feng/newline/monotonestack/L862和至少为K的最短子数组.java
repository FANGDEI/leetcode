package com.feng.newline.monotonestack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/10/26 16:28
 * @description: 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，
 * 并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 * 子数组 是数组中 连续 的一部分。
 * 示例 1：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * 1 <= k <= 109
 * 通过次数35,116提交次数144,979
 */
public class L862和至少为K的最短子数组 {
    //滑动窗口，有个问题就是，为啥滑动窗口做不出来。
//    class Solution {
//        /**
//         * 参数：[nums, k]
//         * 返回值：int
//         * 作者： ladidol
//         * 描述：右指针一直往右边移动，左指针在超过目标和k就开始收缩。
//         */
//        public int shortestSubarray(int[] nums, int k) {
//            int n = nums.length;
//            int left = 0;
//            int right = 0;
//            int winSum = 0;
//
//            int ans = Integer.MAX_VALUE;
//            while (right < n) {
//
//                if (winSum >= k && left <= right) {
//                    System.out.println("(right + 1 - left) = " + (right + 1 - left));
//                    System.out.println("left = " + left);
//                    System.out.println("right = " + right);
//                    ans = Math.min(ans, right + 1 - left);
//                    winSum -= nums[left++];
//                } else {
//                    winSum += nums[right];
//                }
//            }
//            return ans == Integer.MAX_VALUE ? -1 : ans;
//        }
//    }

    //单调队列!!!!
    class Solution {
        /**
         * 参数：[nums, k]
         * 返回值：int
         * 作者： ladidol
         * 描述：
         * <p>
         * 首先要想到要用前缀和来做，然后开始分析前缀和。
         * <p>
         * 用某个合适的数据结构来维护遍历过的 s[i]，并及时移除无用的 s[i]。
         * 优化一：只要用过的s[j]都是可以抛弃的。
         * 优化二：只要维护单调队列，就一定能找到更短的长度。
         * <p>
         * <p>
         * <p>
         * 当sum[i] - sum[j] >= k时，j这个位置有可能作为答案的左端点，
         * 但是也有可能后面会有更小的，所以记录当前这个值，并且将s[j]弹出队列，这样比较好，比较符合代码里写的
         */
        public int shortestSubarray(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();


            int ans = Integer.MAX_VALUE;
            //前缀和初始化
            long[] sum = new long[nums.length + 1];
            for (int i = 1; i < nums.length + 1; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }


            for (int i = 0; i < sum.length; i++) {
                while (!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= k) {
                    ans = Math.min(ans, i - deque.pollFirst());//用过的sum[j]就可以去掉了。优化一
                }
                while (!deque.isEmpty() && sum[i] <= sum[deque.peekLast()]) {
                    deque.pollLast();//优化二
                }
                deque.addLast(i);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }


}