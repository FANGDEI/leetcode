package com.feng.leetcode.offerII._02数组;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/6 0:03
 * @description: {}
 */
public class 剑指OfferII008和大于等于target的最短子数组 {

    //滑动窗口
    class Solution {
        /**
         * 维护一个窗口，当窗口值大于等于target时就进行ans更新
         *
         * @param target
         * @param nums
         * @return
         */
        public int minSubArrayLen(int target, int[] nums) {

            int left = 0;
            int right = 0;
            int winSum = nums[left];
            int ans = Integer.MAX_VALUE;

            while (right < nums.length) {
                if (winSum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    winSum -= nums[left];
                    left++;//从左开始收缩窗口
                }
                while (winSum < target) {
                    right++;
                    if (right >= nums.length) break;
                    winSum += nums[right];
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
