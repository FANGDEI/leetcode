package top.dyw.leetcode.Hot100;

public class L32最长有效括号 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int maxLen = 0;
        // 以 s[i] 这个字符结尾的、最长的有效括号子串长度
        int[] dp = new int[n];
        for (int i=1; i<n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
                } else if (i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    int prevVaild = (i-dp[i-1] >= 2) ? dp[i-dp[i-1]-2] : 0;
                    dp[i] = prevVaild + 2 + dp[i-1];
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}

