package com.feng.newline.dp.sub_sequence;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.sub_sequence
 * @className: L115不同的子序列
 * @author: Ladidol
 * @description: 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 * 示例1：
 * <p>
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 示例2：
 * <p>
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 * @date: 2022/9/11 22:06
 * @version: 1.0
 */
public class L115不同的子序列 {
    class Solution {
        /**
         * 参数：[s, t]
         * 返回值：int
         * 作者： ladidol
         * 描述：就是删除元素。
         * dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
         * <p>
         * 分类：
         * 1. s[i-1] != t[i-1]：直接不考虑当前s[i-1],dp[i - 1][j]
         * 2. s[i-1] == t[i-1]：就说明又有两条路可以到达t串了。dp[i - 1][j - 1]（都用到了s、t的最后一个字母） + dp[i - 1][j]（没用到s的最后一个字母）
         */
        public int numDistinct(String s, String t) {
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            //初始化，由转台转移方程得知，必须初始化dp[i][0],dp[0][j]
            for (int i = 0; i < s.length() + 1; i++) {
                dp[i][0] = 1;//删除全部元素就能得到空传t[0].
            }
            for (int j = 1; j < t.length() + 1; j++) {
                dp[0][j] = 0;//空传s不可能得到t的。
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {//依旧是一层一层的更新。从上到下。
                    dp[i][j] = dp[i - 1][j];//默认不考虑当前的s[i-1];维护传递性。
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] += dp[i - 1][j - 1];//类似找最长公共子序列，相等的时候dp[i][j]是由dp[i - 1][j - 1]演化来的
                    }
                }
            }
            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
}
