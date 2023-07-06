package com.feng.leetcode.offerII._02数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/7 14:48
 * @description: {}
 */
public class 剑指OfferII010和为k的子数组 {

    //这是朴素做法
    class Solution1 {
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int curSum = 0;
                for (int j = i; j < nums.length; j++) {
                    curSum += nums[j];
                    if (curSum == k) {
                        ans++;
                    }


                }
            }
            return ans;
        }
    }

    //还有一种前缀和+哈希的做法 https://leetcode.cn/problems/QTMn0o/solutions/1764672/by-ac_oier-hr6k/
    //还有一种前缀和+哈希的做法 https://leetcode.cn/problems/subarray-sum-equals-k/solutions/562174/de-liao-yi-wen-jiang-qian-zhui-he-an-pai-yhyf/

    //前缀和+哈希
    class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums.length == 0) return 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);//前缀和为零的情况。
            int preSum = 0, ans = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                ans += map.getOrDefault(preSum - k, 0);
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
            return ans;
        }
    }


}
