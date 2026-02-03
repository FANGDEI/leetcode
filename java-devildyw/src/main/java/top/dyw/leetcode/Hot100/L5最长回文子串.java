package top.dyw.leetcode.Hot100;

public class L5最长回文子串 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        int maxLen = 0;
        int begin = 0;
        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if (j-i+1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                    if (dp[i][j] && maxLen < j-i+1) {
                        maxLen = j-i+1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
