package com.feng.leetcode.offerII._11二分查找;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/29 20:57
 * @description: {}
 */
public class 剑指OfferII070排序数组中只出现一次的数字 {


    //不用二分了，我们用异或（有个缺点就是找不到下标）
    class Solution {
        /**
         * @param nums
         * @return
         */
        public int singleNonDuplicate(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                ans ^= num;
            }
            return ans;
        }
    }
}
