package com.feng.leetcode.offer._03双指针;

public class 剑指Offer57和为s的两个数字 {

    //双指针
    class Solution {
        /**
         * //两数之和变种，这是有序数组，所以存在更优解。
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            int sum, right = nums.length - 1, left = 0;
            while (right > left) {
                sum = nums[right] + nums[left];
                if (sum == target) return new int[]{nums[left], nums[right]};
                else if (sum > target) right--;
                else left++;
            }
            return new int[]{};
        }
    }


}
