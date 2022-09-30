package com.feng.newline.dp.sub_sequence;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.sub_sequence
 * @className: L1143最长公共子序列
 * @author: Ladidol
 * @description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * 提示：
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 和text2 仅由小写英文字符组成。
 * @date: 2022/9/9 19:06
 * @version: 1.0
 */
public class L1143最长公共子序列 {


    //dp （重复子序列不需要连续）(说实话这一题才是正宗的dp状态题。)
    class Solution {
        // dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        // s1[i]==s2[j] : f[i][j]=f[i-1][j-1]+1。代表必然使用 s1[i] 与 s2[j] 时 LCS 的长度。
        // s1[i]!=s2[j] : f[i][j]=max(f[i-1][j], f[i][j-1])。如果s1[i] 与 s2[j]不相等时，就需要和它原来的对比一下了。分别单自考虑的时候。
        public int longestCommonSubsequence(String text1, String text2) {
            char[] text1s = text1.toCharArray();
            char[] text2s = text2.toCharArray();
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    if (text1s[i - 1] == text2s[j - 1])
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else if (text1s[i - 1] != text2s[j - 1])// 不相等的话，可能就出现在之前
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            // 不是单条路的斜线传递，所以取最后一个数值就行。
            return dp[text1.length()][text2.length()];

        }
    }







}
