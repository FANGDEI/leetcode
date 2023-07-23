package com.feng.leetcode.offer._06查找算法;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/22 11:56
 * @description: {}
 */
public class 剑指Offer03数组中重复的数字 {


    //哈希
    class Solution {
        /**
         * 很显然这里的nums[i]属于0~n-1，直接哈希模板题
         *
         * @param nums
         * @return
         */
        public int findRepeatNumber(int[] nums) {
            int[] tmp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (tmp[nums[i]] == 0) tmp[nums[i]]++;
                else return nums[i];
            }
            return -1;
        }
    }

    //正宗要用二分查找来做，这里偷懒了。



}
