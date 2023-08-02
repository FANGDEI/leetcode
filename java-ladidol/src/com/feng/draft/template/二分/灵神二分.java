package com.feng.draft.template.二分;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/28 13:30
 * @description: {}
 */
public class 灵神二分 {


    //基础版本二分查找
    class Solution {
        /**
         * 双闭区间：[left,right]
         * 寻找元素出现的第一个位置。
         *
         * @param nums
         * @param target
         * @return
         */
        int lowerBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;//闭区间[left, right]
            while (left <= right) {//区间不为空
                int mid = left + right >> 1;
                if (nums[mid] < target) {
                    //将确定的分割出来
                    left = mid + 1;//[mid+1, right]
                } else {
                    right = mid - 1;//[left, mid-1]
                }
            }

            return right + 1;//有个循环不变量：left-1永远小于target，right+1永远大于target
        }


        public int[] searchRange(int[] nums, int target) {
            int start = lowerBound(nums, target);
            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1};
            }
            int end = lowerBound(nums, target + 1) - 1;//寻找target+1这个数然后就是他前面的这一个数
            return new int[]{start, end};
        }
    }


}
