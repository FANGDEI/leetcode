package top.dyw.leetcode.Hot100;

public class L5最长回文子串 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        if (n <2) {
            return s;
        }
        // 初始化 从最后一个开始 最后一个单词自己就是回文子串
        // dp[i][j] 表示从i字符到第j个字符是否是回文子串
        dp[n-1][n-1] = true;
        int maxLen = 0;
        int begin = 0;
        for (int i = n-2; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i+1 < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && maxLen < (j-i+1)) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin+maxLen);
    }
}
