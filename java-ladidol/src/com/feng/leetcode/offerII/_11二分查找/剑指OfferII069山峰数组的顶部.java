package com.feng.leetcode.offerII._11二分查找;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/27 18:29
 * @description: {
 *     三分
 * }
 */
public class 剑指OfferII069山峰数组的顶部 {
    //灵活的二分查找
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int i = 1, j = arr.length - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (arr[mid] > arr[mid - 1]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            return j;
        }
    }
}
