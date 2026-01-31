package top.dyw.leetcode.Hot100;

import java.util.*;

public class L300最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n==0) {
            return 0;
        }
        // dp[i] 表示到第i个下标数组的最长递增子序列
        int[] dp = new int[n];
        int max = -1;

        for (int i = 0; i<n; i++) {
            // 初始化 每个元素自己就是一个递增序列
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    // 如果 nums[i] > nums[j] 那么就在dp[j] 的基础上 多一个nums[i] 组成子序列了
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;

    }
}