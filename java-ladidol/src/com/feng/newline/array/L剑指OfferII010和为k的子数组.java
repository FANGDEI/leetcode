package com.feng.newline.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ladidol
 * @date: 2022/10/9 15:05
 * @description: 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * 示例 1：
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * 示例 2：
 * <p>
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class L剑指OfferII010和为k的子数组 {//就是560. 和为 K 的子数组
    //前缀和(听说这是一个很经典的题)
    class Solution {
        /**
         * 参数：[nums, k]
         * 返回值：int
         * 作者： ladidol
         * 描述：看题目注意nums[i]的取值范围，有负数。这题主要理解前缀数组的使用。标记已经出现过的前缀和个数。
         */
        public int subarraySum(int[] nums, int k) {
            int[] prefixSum = new int[nums.length + 1];
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 1; i <= nums.length; i++) prefixSum[i] = prefixSum[i - 1] + nums[i - 1];

            int ans = 0;
            for (int i = 0; i <= nums.length; i++) {
                int needSum = prefixSum[i] - k;//需要一个减去的个数。
                ans += map.getOrDefault(needSum, 0);
                //维护已出现的前缀和
                map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
            }
            return ans;
        }
    }
}