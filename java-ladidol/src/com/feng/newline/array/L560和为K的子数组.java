package com.feng.newline.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L560和为K的子数组
 * @author: Ladidol
 * @description: 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * @date: 2022/7/23 22:33
 * @version: 1.0
 */
public class L560和为K的子数组 {
    //前缀和
    class Solution1 {
        int[] preSum;
        int count = 0;

        public int subarraySum(int[] nums, int k) {
            preSum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];//正常初始化数组
            }

            for (int left = 1; left <= nums.length; left++) {//通过遍历区间和
                for (int right = left; right <= nums.length; right++) {
                    //遍历区间和[left,right], 注意下标偏移.
                    if (preSum[right] - preSum[left - 1] == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }


    //前缀和+哈希表优化
    class Solution {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();

        public int subarraySum(int[] nums, int k) {
            preSumFreq.put(0, 1);// 对于下标为 0 的元素，前缀和为 0，个数为 1

            int preSum = 0;//当前前缀和
            int count = 0;
            for (int num : nums) {
                preSum += num;//维护前缀和.
                if (preSumFreq.containsKey(preSum - k)) {
                    //满足 preSum - (preSum - k) == k 其实就是preSum(当前)-preSum(以前) == k
                    count += preSumFreq.get(preSum-k);//注意这里
                }
                //维护preSumFreq
                preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
            }
            return count;
        }
    }
}
