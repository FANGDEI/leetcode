package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L1455检查单词是否为句中其他单词的前缀
 * @author: Ladidol
 * @description: 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
 * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
 * 字符串 s 的 前缀 是 s 的任何前导连续子字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "i love eating burger", searchWord = "burg"
 * 输出：4
 * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
 * @date: 2022/8/21 19:58
 * @version: 1.0
 */
public class L1455检查单词是否为句中其他单词的前缀 {
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");
            int index = 0;
            for (String word : words) {
                if (word.startsWith(searchWord)) {//注意是前缀；
                    return index + 1;
                }
                index++;
            }
            return -1;
        }
    }
}
