package com.feng.newline.dp.sub_sequence;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/10/14 15:51
 * @description: 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * 示例 2：
 * <p>
 * 输入：s = "aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * 示例 3：
 * <p>
 * 输入：s = "aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 * 提示：
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 */
public class L940不同的子序列II {
    //dp中的子序列问题。
    class Solution {
        /**
         * 参数：[s]
         * 返回值：int
         * 作者： ladidol
         * 描述：dp[i]为前i个字符可以组成的不同的子序列
         * <p>
         * dp[i] = dp[i - 1] + newCount - repeatCount；
         * tips：
         * 子集个数为2^n，所以 newCount = dp[i-1]
         * 重复个数：等于前面才添加相同字母(j)后新增的的数量：dp[j]-dp[j-1]
         * 默认有空串，更方便形成上面的每一次新增数的添加。
         */
        public int distinctSubseqII(String s) {
            int mod = (int) (1e9 + 7);
            int n = s.length();
            long[] dp = new long[n];
            dp[0] = 2;//空字符串加字母自己。

            long[] preAddTheSameLetter = new long[26];
            preAddTheSameLetter[s.charAt(0) - 'a'] = 1;//第一个字符添加也要维护。

            for (int i = 1; i < n; i++) {
                dp[i] = ((dp[i - 1] * 2) % mod - preAddTheSameLetter[s.charAt(i) - 'a'] + mod) % mod;
                //维护一下哈希。
                preAddTheSameLetter[s.charAt(i) - 'a'] = (preAddTheSameLetter[s.charAt(i) - 'a'] + dp[i] - dp[i - 1]) % mod;//注意是累加哦。
            }

            System.out.println("dp = " + Arrays.toString(dp));

            return (int) (dp[n - 1] - 1);//题意时不要空字符串的
        }
    }


    //应该可以直接通过暴力搜索。
}