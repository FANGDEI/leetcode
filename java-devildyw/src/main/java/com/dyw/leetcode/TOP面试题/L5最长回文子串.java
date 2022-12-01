package com.dyw.leetcode.TOP面试题;

/**
 * @author Devil
 * @since 2022-12-01-11:40
 */
@SuppressWarnings("all")
public class L5最长回文子串 {
    public static void main(String[] args) {
        System.out.println(new L5最长回文子串().longestPalindrome("babad"));
    }

    /**
     * 动态规划
     */
    public String longestPalindrome(String s) {
        int n = s.length();

        if (n<2){
            return s;
        }
        /**
         * dp数组 dp[i][j]: 表示s字符串中 从 i 到 j 的字符串子串是否是回文串
         */
        boolean[][] dp = new boolean[n][n];

        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        //方便后续返回结果
        int maxLen = 1;
        int begin = 0;
        //result = s[begin:begin+maxLen]

        //子字符串的长度
        for (int len = 2; len <= n; len++) {
            //子字符串起始长度
            for (int start = 0; start < n; start++) {
                int end = len+start-1;
                if (end>=n){
                    break;
                }

                //如果两端点都不匹配那么直接置为 false
                if (s.charAt(end) != s.charAt(start)){
                    dp[start][end] =false;
                }else{
                    //如果两端点相同 要分情况 如果字符长度小于3 则代表只有两个字符则相同则为回文串
                    if ((end-start)<3){
                        dp[start][end] = true;
                    }else{
                        //如果大于等于 3 不仅要相同还要判断该子字符串内是否为回文串
                        dp[start][end] = dp[start+1][end-1];
                    }
                }

                //最后更新 maxLen 和 begin
                if (dp[start][end]&&(end-start+1)>maxLen){
                    maxLen = end-start+1;
                    begin = start;
                }
            }
        }
        return s.substring(begin,begin+maxLen);

    }


}
