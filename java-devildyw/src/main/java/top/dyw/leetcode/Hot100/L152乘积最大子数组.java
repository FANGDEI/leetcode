package top.dyw.leetcode.Hot100;

import java.util.*;
public class L152乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int maxF = nums[0]; // 当前最大值
        int minF = nums[0]; // 当前最小值
        int ans = nums[0]; // 最终结果 全局最大
        // 因为负数可以让最大变为最小 也可能让最小变为最大 我们需要同时保留最大和最小 以便状态转移。
        for (int i=1; i<nums.length; i++) {
            // 1. 延续之前的情况 最大值 最小值
            int c1 = maxF * nums[i];
            int c2 = minF * nums[i];
            // 2. 当前独立成子数组

            maxF = Math.max(c1, Math.max(nums[i], c2));
            minF = Math.min(c2, Math.min(nums[i], c1));
            ans = Math.max(ans, maxF);
        }

        return ans;
    }
}
