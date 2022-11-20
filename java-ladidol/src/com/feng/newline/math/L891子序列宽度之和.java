package com.feng.newline.math;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/11/19 0:58
 * @description:
 */
public class L891子序列宽度之和 {
    //灵神的解法，先排序直接的。
    class Solution {
        private static final int MOD = (int) 1e9 + 7;

        public int sumSubseqWidths(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int[] pow2 = new int[n];
            pow2[0] = 1;
            for (int i = 1; i < n; ++i)
                pow2[i] = pow2[i - 1] * 2 % MOD; // 预处理 2 的幂次
            long ans = 0L;
            for (int i = 0; i < n; ++i)
                ans += (long) (pow2[i] - pow2[n - 1 - i]) * nums[i]; // 在题目的数据范围下，这不会溢出
            return (int) (ans % MOD + MOD) % MOD; // 注意上面有减法，ans 可能为负数
        }
    }
}