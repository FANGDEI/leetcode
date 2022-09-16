package com.feng.newline.dp.sub_sequence;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.sub_sequence
 * @className: L392判断子序列
 * @author: Ladidol
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * 致谢：
 * 特别感谢 @pbrother添加此问题并且创建所有测试用例。
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * @date: 2022/9/11 20:52
 * @version: 1.0
 */
public class L392判断子序列 {
    class Solution {
        // dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
        // if (s[i - 1] == t[j - 1])
        //  t中找到了一个字符在s中也出现了
        // if (s[i - 1] != t[j - 1])
        //  相当于t要删除元素，继续匹配
        public boolean isSubsequence(String s, String t) {
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 1; i < dp.length; i++) {//注意dp.length和s.length不一样哦。
                for (int j = 1; j < dp[0].length; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = dp[i][j - 1];
                }
            }
            return dp[s.length()][t.length()] == s.length();
        }
    }
}
