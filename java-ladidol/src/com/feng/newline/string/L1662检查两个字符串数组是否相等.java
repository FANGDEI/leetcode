package com.feng.newline.string;

/**
 * @author: ladidol
 * @date: 2022/11/1 13:14
 * @description:给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * 数组表示的字符串是由数组中的所有元素 按顺序 连接形成的字符串。
 * 示例 1：
 * <p>
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 * <p>
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] 和 word2[i] 由小写字母组成
 */
public class L1662检查两个字符串数组是否相等 {

    //双指针
    class Solution1 {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

            int N = 1000005;
            StringBuilder str1 = new StringBuilder(word1[0]);
            StringBuilder str2 = new StringBuilder(word2[0]);
            for (int i = 0, i1 = 1, i2 = 1; i < str1.length() && i < str2.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) return false;
                if (i1 < word1.length)
                    str1.append(word1[i1++]);
                if (i2 < word2.length)
                    str2.append(word2[i2++]);
            }

            return str1.length() == str2.length();
        }
    }

    //直接拼接再比较
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            for (int i = 0; i < word1.length; i++) {
                str1.append(word1[i]);
            }
            for (int i = 0; i < word2.length; i++) {
                str2.append(word2[i]);
            }
            return str1.toString().equals(str2.toString());
        }
    }
}