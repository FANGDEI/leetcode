package com.feng.leetcode.offer._06查找算法;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/23 9:48
 * @description: {}
 */
public class 剑指Offer53_II0到n_1中缺失的数字 {


    //排序数组用二分法
    static class Solution {
        /**
         * 找右数组第一个数字
         *
         * @param nums
         * @return
         */
        public int missingNumber(int[] nums) {
//            if (nums.length == 1 && nums[0] == 0) return 1;
//            if (nums[nums.length - 1] == nums.length - 1) return nums.length;

            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + right >> 1;
                if (nums[mid] == mid) left = mid + 1;
                else right = mid - 1;
            }
//            System.out.println("right = " + right);
//            System.out.println("left = " + left);
            return left;

        }
    }

    public static void main(String[] args) {
        new Solution().missingNumber(new int[]{0});
    }


}
