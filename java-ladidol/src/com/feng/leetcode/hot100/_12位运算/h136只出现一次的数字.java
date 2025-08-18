package com.feng.leetcode.hot100._12位运算;


/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/18 10:34
 */
public class h136只出现一次的数字 {

  // 任何数异或0都是本身，自己和自己异或就等于0
  class Solution {
    public int singleNumber(int[] nums) {
      int result = 0;
      for (int num : nums) {
        result ^= num;
      }
      return result;
    }
  }
}
