package com.feng.leetcode.offer._06查找算法;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 20:09
 * @description: {}
 */
public class 剑指Offer11旋转数组的最小数字 {


    //二分查找
    class Solution {
        public int minArray(int[] nums) {
            int left = 0, right = nums.length - 1;
            int mid;
            while (left < right) {
                mid = right + left >> 1;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    right--;
                }
            }
            return nums[left];
        }
    }
}
