package com.feng.leetcode.offerII._02数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/10 0:08
 * @description: {}
 */
public class 剑指OfferII011_0和1个数相同的子数组 {


    //前缀和+哈希
    class Solution {
        /**
         * 这里通过将0变成-1，就可以进行巧妙地前缀和了，只要遇到preSum[i] == preSum[j]就说明i到j-1这个下标范围的0和1个数相等。
         *
         * @param nums
         * @return 返回最长的子数组就行了，只用记录最前面的值。
         */
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) nums[i] = -1;
                preSum[i + 1] = preSum[i] + nums[i];//注意这里不能等价于preSum[i + 1] += nums[i];
            }
            int ans = 0;
            for (int i = 0; i <= n; i++) {//需要从零开始，保证从第一位开始的情况
                if (map.containsKey(preSum[i])) {
                    ans = Math.max(ans, i - map.get(preSum[i]));
                } else {
                    map.put(preSum[i], i)   ;
                }
            }


            return ans;
        }
    }


}
