package top.dyw.leetcode.Hot100;

import java.util.*;

public class L139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 表示以i结尾的字符串能否用wordDict的字符串组成
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        // 初始化
        dp[0] = true;

        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}