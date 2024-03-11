package com.feng.leetcode.offerII._11二分查找;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/28 17:41
 * @description: {}
 */
public class L162寻找峰值 {


    class Solution {


        public int findPeakElement(int[] nums) {

            int n = nums.length;
            int left = 0, right = n - 1;
            int mid = 0;
            while (left < right) {

                mid = (right + left + 1) / 2;
//                if (mid - 1 < 0) {
//                    System.out.println(mid);
//                    return mid;
//                }
                if (nums[mid - 1] < nums[mid]) {

                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

}
