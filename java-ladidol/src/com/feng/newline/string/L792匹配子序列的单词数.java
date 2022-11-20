package com.feng.newline.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ladidol
 * @date: 2022/11/17 21:44
 * @description: 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * 例如， “ace” 是 “abcde” 的子序列。
 * 示例 1:
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 */
public class L792匹配子序列的单词数 {

    //copy 的
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            int n = s.length(), ans = 0;
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
                list.add(i);
                map.put(s.charAt(i), list);
            }
            for (String w : words) {
                boolean ok = true;
                int m = w.length(), idx = -1;
                for (int i = 0; i < m && ok; i++) {
                    List<Integer> list = map.getOrDefault(w.charAt(i), new ArrayList<>());
                    int l = 0, r = list.size() - 1;
                    while (l < r) {
                        int mid = l + r >> 1;
                        if (list.get(mid) > idx) r = mid;
                        else l = mid + 1;
                    }
                    if (r < 0 || list.get(r) <= idx) ok = false;
                    else idx = list.get(r);
                }
                if (ok) ans++;
            }
            return ans;
        }
    }
}