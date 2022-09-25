package com.feng.newline.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L745前缀和后缀搜索
 * @author: Ladidol
 * @description: 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 * <p>
 * 实现 WordFilter 类：
 * <p>
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 * <p>
 * 示例:
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
 * @date: 2022/7/14 10:02
 * @version: 1.0
 */
//每日一题2022年7月14日10:16:49
public class L745前缀和后缀搜索 {

    class WordFilter1 {

        int len;
        String[] words;

        public WordFilter1(String[] words) {
            this.len = words.length;
            this.words = words;
        }

        public int f(String pref, String suff) {
            //返回最大角标, 就从后面往前遍历.
            for (int i = len - 1; i >= 0; i--) {
                if (words[i].startsWith(pref) && words[i].endsWith(suff)) {
                    return i;
                }
            }
            return -1;
        }
    }

    // 2022年9月25日20:04:40重做这题
    // 前缀树Trie树来做。
    class WordFilter {

        //这一题其实就是两个前缀树来做，其中一个倒序就行。

        public WordFilter(String[] words) {
            TrieNode curPre = rootPre;
            TrieNode curEnd = rootEnd;


            for (int idx = 0; idx < words.length; idx++) {
                curPre.idxs.add(idx);
                curEnd.idxs.add(idx);

                char[] chars = words[idx].toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i] - 'a';
                    if (curPre.next[index] == null) curPre.next[index] = new TrieNode();
                    curPre = curPre.next[index];
                    curPre.idxs.add(idx);//加入当前字符串的下标。
                }
                curPre.isWord = true;

                for (int i = chars.length - 1; i >= 0; i--) {
                    int index = chars[i] - 'a';
                    if (curEnd.next[index] == null) curEnd.next[index] = new TrieNode();
                    curEnd = curEnd.next[index];
                    curEnd.idxs.add(idx);//加入当前字符串的下标。
                }
                curEnd.isWord = true;
            }
        }

        public int f(String pref, String suff) {
            TrieNode curPre = rootPre;
            TrieNode curEnd = rootEnd;
            char[] chars = pref.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (curPre.next[index] == null) return -1;
                curPre = curPre.next[index];
            }
            List<Integer> listPre = curPre.idxs;

            chars = suff.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                int index = chars[i] - 'a';
                if (curEnd.next[index] == null) return -1;
                curEnd = curEnd.next[index];
            }
            List<Integer> listEnd = curEnd.idxs;

            System.out.println("listPre = " + listPre);
            System.out.println("listEnd = " + listEnd);

            for (int i = listPre.size() - 1, j = listEnd.size() - 1; i >= 0 && j >= 0; ) {
                if (listPre.get(i) > listEnd.get(j)) i--;
                else if (listPre.get(i) < listEnd.get(j)) j--;
                else return listPre.get(i);
            }
            return -1;
        }

        class TrieNode {
            boolean isWord;
            TrieNode[] next = new TrieNode[26];
            List<Integer> idxs = new ArrayList<>();
        }

        TrieNode rootPre = new TrieNode();
        TrieNode rootEnd = new TrieNode();


    }


/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
}
