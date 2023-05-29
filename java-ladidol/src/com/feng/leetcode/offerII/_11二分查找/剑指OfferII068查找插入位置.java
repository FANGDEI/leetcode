package com.feng.leetcode.offerII._11二分查找;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/27 17:38
 * @description: {
 * 二分查找详解：https://leetcode.cn/circle/discuss/ooxfo8/#java
 * }
 */
public class 剑指OfferII068查找插入位置 {
    class Solution {
        /**
         * 本题解释：https://leetcode.cn/problems/N6YdxV/solutions/2264980/yi-bu-yi-bu-dai-ni-gao-ming-bai-ben-ti-y-lcp1/
         *
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
