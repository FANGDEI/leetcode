package com.feng.newline.string;

/**
 * @author: ladidol
 * @date: 2022/11/3 14:01
 * @description: 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，
 * 那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
 * 如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 * 示例 1：
 * <p>
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * 示例 2：
 * <p>
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * 示例 3：
 * <p>
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和 word 都只包含小写英文字母。
 */
public class L1668最大重复子字符串 {
    //简单的双指针。
    class Solution {
        /**
         * 参数：[sequence, word]
         * 返回值：int
         * 作者： ladidol
         * 描述：直接遍历sequence，碰见第一个相等的就开始一直遍历回滚word计数
         */
        public int maxRepeating(String sequence, String word) {
            int n = sequence.length();
            int m = word.length();

            int index = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (sequence.charAt(i) == word.charAt(index)) {
                    int tmp = 0;
                    int j = i;
                    while (j < n && sequence.charAt(j) == word.charAt(index)) {
                        if (index == m - 1) {
                            tmp++;
                            j++;
                            index = 0;
                            continue;
                        }
                        j++;
                        index++;
                    }
                    ans = Math.max(ans, tmp);
                    index = 0;

                }
            }
            return ans;
        }
    }
}