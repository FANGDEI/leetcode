package com.feng.leetcode.offer._03双指针;

public class 剑指Offer21调整数组顺序使奇数位于偶数前面 {




    //首尾双指针
    class Solution {
        public int[] exchange(int[] nums) {
            int i = 0, j = nums.length - 1, tmp;
            while(i < j) {
                while(i < j && (nums[i] & 1) == 1) i++;
                while(i < j && (nums[j] & 1) == 0) j--;
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            return nums;
        }
    }


}
