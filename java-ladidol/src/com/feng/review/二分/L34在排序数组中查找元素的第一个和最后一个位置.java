package com.feng.review.二分;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/3 21:09
 * @description: {}
 */
public class L34在排序数组中查找元素的第一个和最后一个位置 {


    //基础版本二分查找
    class Solution {
        //双闭区间
        int lowerBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;//闭区间[left, right]
            while (left <= right) {//区间不为空
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;//[mid+1, right]
                } else {
                    right = mid - 1;//[left, mid-1]
                }
            }
            return left;//有个循环不变量：left-1永远小于target，right+1永远大于target
        }

        //左闭右开区间 left right相等时停止
        int lowerBound2(int[] nums, int target) {
            int left = 0, right = nums.length;//闭区间[left, right)
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;//[mid+1, right]
                } else {
                    right = mid;//[left, mid-1]
                }
            }
            return right;//left
        }

        //双开区间
        int lowerBound3(int[] nums, int target) {
            int left = -1, right = nums.length;//闭区间(left, right)
            while (left + 1 < right) {//区间不为空
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid;//(mid, right)
                } else {
                    right = mid;//(left, mid)
                }
            }
            return right;
        }


        public int[] searchRange(int[] nums, int target) {
            int start = lowerBound3(nums, target);
            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1};
            }
            int end = lowerBound3(nums, target + 1) - 1;//寻找target+1这个数然后就是他前面的这一个数
            return new int[]{start, end};
        }
    }
}
