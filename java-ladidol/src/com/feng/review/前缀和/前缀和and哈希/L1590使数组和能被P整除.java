package com.feng.review.前缀和.前缀和and哈希;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/11 11:06
 * @description: {}
 */
public class L1590使数组和能被P整除 {

    //前缀和+暴力
    class Solution {

        public int minSubarray(int[] nums, int p) {
            int[] sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = (sum[i] + nums[i]) % p;
            }
            //所有元素和刚好满足
            if (sum[sum.length - 1] % p == 0) {
                return 0;
            }
            //按步长遍历，外层为步长
            for (int i = 1; i < sum.length - 1; i++) {
                for (int j = 0; j < sum.length - i; j++) {
                    int num = sum[sum.length - 1] - (sum[j + i] - sum[j]);
                    if (num % p == 0) return i;
                }
            }
            return -1;
        }
    }
    // TODO: 2023/3/11 前缀和+哈希 
    
    
    
    
    
}
