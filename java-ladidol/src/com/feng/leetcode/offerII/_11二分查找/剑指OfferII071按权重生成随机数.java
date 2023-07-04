package com.feng.leetcode.offerII._11二分查找;

import java.util.Random;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/29 21:39
 * @description: {}
 */
public class 剑指OfferII071按权重生成随机数 {
    class Solution {
        int[] preSum;
        int sum;
        Random ran = new Random();

        //前缀和+二分查找
        public Solution(int[] w) {
            //前缀和后的数组是递增的，所以我们用二分查找。
            preSum = new int[w.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + w[i - 1];
            }
            sum = preSum[w.length];
        }

        public int pickIndex() {
            int target = ran.nextInt(sum)+1;
            int left = 1, right = preSum.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left-1;
        }
    }
}
