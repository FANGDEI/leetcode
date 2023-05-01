package com.feng.newline.array;

import java.util.ArrayList;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/26 17:48
 * @description: {}
 */
public class L1031两个非重叠子数组的最大和 {

    //前缀和
    class Solution {
        /**
         * 前面是a子数组，后面是b子数组
         * 从能达到第一个ab数组开始遍历b数组，同时维持sumOfA最大，期间维护sumOfA+sumOfB最大
         *
         * @param nums
         * @param firstLen
         * @param secondLen
         * @return
         */
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int[] preSum = new int[nums.length + 1];
            //左开右闭，preSum[i]表示前i个的前缀和
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            return Math.max(find(firstLen, secondLen, preSum), find(secondLen, firstLen, preSum));
        }

        int find(int lenA, int lenB, int[] preSum) {
            int ans = 0;
            int maxA = 0;
            int curB = 0;
            for (int i = lenA + lenB; i < preSum.length; i++) {
                curB = preSum[i] - preSum[i - lenB];//遍历b的长度
                maxA = Math.max(maxA, preSum[i - lenB] - preSum[i - lenB - lenA]);
                ans = Math.max(ans, curB + maxA);
            }
            return ans;
        }
        ArrayList<Integer> list = new ArrayList<>();



    }


}
