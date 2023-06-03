package com.feng.review.二分;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/3 22:54
 * @description: {}
 */
public class L162寻找峰值 {

    // 上坡则右边比有峰值，下坡则左边必有峰值
    // 二分查找
    class Solution {
        public int findPeakElement(int[] nums) {

            //闭区间
            int left = 0, right = nums.length - 1;

            while(left<right){
                int mid = left + (right - left) / 2;
                // 峰值在左边，向左逼近，且mid可能为峰值
                if (nums[mid] >= nums[mid + 1]) {
                    right = mid;//
                } else {//上坡
                    // 峰值在右边，向右逼近，mid+1可能为峰值
                    left = mid + 1;
                }
            }
            return right;
        }
    }
}
