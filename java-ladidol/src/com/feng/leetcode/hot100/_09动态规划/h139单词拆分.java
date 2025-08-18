package com.feng.leetcode.hot100._09动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/18 11:11
 */
public class h139单词拆分 {

  class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      int maxLen = 0;
      Set<String> wordSet = new HashSet<>();
      for (String word : wordDict) {
        maxLen = Math.max(maxLen, word.length());
        wordSet.add(word);
      }
      int n = s.length();
      boolean[] dp = new boolean[n + 1];
      dp[0] = true;
      for (int i = 1; i < n; i++) {
        for (int j = i-1; j >= Math.max(i - maxLen, 0) ; j--) {
          if (dp[j] && wordSet.contains(s.substring(j,i))){
            dp[i] = true;
            break;
          }
        }
      }
      return dp[n];
    }
  }

}
