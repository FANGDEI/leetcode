package com.dyw.leetcode.TOP面试题;

/**
 * @author Devil
 * @since 2022-12-05-13:52
 */
@SuppressWarnings("all")
public class L10正则表达式匹配 {

    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        /**
         * dp[i][j]:表示s的前i个字符，p的前j个字符是否能够匹配
         */
        boolean[][] dp = new boolean[m + 1][n + 1];

        /**
         * 初始化 s为空 p为空能匹配上
         */
        dp[0][0] = true;

        //p为空，s不为空，必为false 而java种 boolean数组默认为false
        //s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                //文本串和模式串末尾能匹配上
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {//模式串末尾是‘*’
                    //模式串*前一个字符能够跟文本串的末尾匹配上
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] //*匹配0次的情况
                                || dp[i - 1][j]; //*匹配1次或多次的情况
                    } else {
                        dp[i][j] = dp[i][j - 2]; //只能匹配0次
                    }
                }
            }
        }
        return dp[m][n];
    }
}
