package com.feng.newline.string;

/**
 * @author: ladidol
 * @date: 2022/10/23 16:36
 * @description: 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * 示例 2：
 * <p>
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * 示例 3：
 * <p>
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 */
public class L1768交替合并字符串 {
    //双指针
    class Solution {
        /**
         * 参数：[word1, word2]
         * 返回值：java.lang.String
         * 作者： ladidol
         * 描述：一个一个来，多余的加到后面。
         */
        public String mergeAlternately(String word1, String word2) {
            StringBuilder ans = new StringBuilder();
            int i, j;
            for (i = 0, j = 0; i < word1.length() && j < word2.length(); i++, j++) {
                ans.append(word1.charAt(i)).append(word2.charAt(j));
            }
            while (i < word1.length()) ans.append(word1.charAt(i++));
            while (j < word2.length()) ans.append(word2.charAt(j++));
            return ans.toString();
        }
    }
}