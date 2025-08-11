package com.feng.leetcode.hot100._10前缀和;

public class H238除自身以外数组的乘积 {

    // 前缀数组和后缀数组result[i] = pre[i-1]*aft[i+1]
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n];
            int[] aft = new int[n];
            pre[0] = 1;
            aft[n-1] = 1;
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i-1] * nums[i-1];
            }

            for (int i = n-2; i >= 0; i--) {
                aft[i] = aft[i+1] * nums[i+1];
            }

            int[] result = new int[n];
            result[0] = aft[0];
            result[n-1] = pre[n-1];
            for (int i = 1; i < n-1; i++) {
                result[i] = pre[i] * aft[i];
            }
            return result;
        }
    }


}
