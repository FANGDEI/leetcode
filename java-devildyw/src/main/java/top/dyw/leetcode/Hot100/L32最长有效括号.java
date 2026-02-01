package top.dyw.leetcode.Hot100;

public class L32最长有效括号 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n<=1) {
            return 0;
        }
        int[] dp = new int[n];
        int maxLen = 0;
        // dp[i] 表示以s[i]结尾的最长有效括号数量
        dp[0] = 0;
        for (int i=1; i<n; i++) {
            if (s.charAt(i)==')') {
                if (s.charAt(i-1)=='(') {
                    dp[i] = (i-2>=0 ? dp[i-2] : 0) + 2;
                } else if (i-dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    // 需要把前面的括号数量加在一起
                    int prevVaild = (i-dp[i-1]>=2) ? dp[i-dp[i-1]-2] : 0;
                    dp[i] = dp[i-1] + 2 + prevVaild;
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}

