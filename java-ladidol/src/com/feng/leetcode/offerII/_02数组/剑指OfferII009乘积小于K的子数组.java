package com.feng.leetcode.offerII._02数组;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/7 14:29
 * @description: {}
 */
public class 剑指OfferII009乘积小于K的子数组 {


    //朴素做法，容易错觉感觉差不多
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {

            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int curMulti = 1;
                for (int j = i; j < nums.length; j++) {
                    curMulti *= nums[j];
                    if (curMulti >= k) break;
                    ans++;
                }
            }
            return ans;
        }
    }

    //滑动窗口只能用于非负数的情况
    //滑动窗口做法，https://leetcode.cn/problems/ZVAVXX/solutions/2087259/yi-xie-jiu-cuo-qing-kan-zhe-pythonjavacg-qtx2/



}
