package com.feng.leetcode.hot100._09动态规划;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/18 11:57
 */
public class h647回文子串 {

  // dp[i + 1][j - 1] 在 dp[i][j]的左下角
  class Solution {

    public int countSubstrings(String s) {
      // 当且仅当两个相等的情况，才会和上一个dp相关联
      boolean[][] dp = new boolean[s.length()][s.length()];
      int result = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
        for (int j = i; j < s.length(); j++) {
          if (s.charAt(i) == s.charAt(j) && j - i <= 1 && dp[i + 1][j - 1]) {
            result++;
            dp[i][j] = true;
          }
        }
      }
      return result;
    }
  }
}
