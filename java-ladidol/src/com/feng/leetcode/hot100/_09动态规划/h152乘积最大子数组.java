/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._09动态规划;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/12 11:05
 */
public class h152乘积最大子数组 {

  class Solution {

    // 存在负数和正数，同时可能会min到max的转换。
    // dpMax[i] 表示以 nums[i] 结尾的子数组的最大乘积
    // dpMin[i] 表示以 nums[i] 结尾的子数组的最小乘积
    public int maxProduct(int[] nums) {
      int[] dpMax = new int[nums.length];
      int[] dpMin = new int[nums.length];
      dpMin[0] = nums[0];
      dpMax[0] = nums[0];
      int ans = nums[0];
      for (int i = 1; i < nums.length; i++) {
        int tmp1 = dpMax[i-1] * nums[i];
        int tmp2 = dpMin[i-1] * nums[i];
        dpMax[i] = Math.max(nums[i], Math.max(tmp1, tmp2));
        dpMin[i] = Math.min(nums[i], Math.min(tmp1, tmp2));
        // 维护最终答案
        ans = Math.max(ans, dpMax[i]);
      }
      return ans;
    }
  }

}
