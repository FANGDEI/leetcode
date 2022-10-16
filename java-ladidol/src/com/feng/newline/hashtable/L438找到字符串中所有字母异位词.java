package com.feng.newline.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L438找到字符串中所有字母异位词
 * @author: Ladidol
 * @description: 用滑动窗口来解题.
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * @date: 2022/7/10 21:11
 * @version: 1.0
 */
public class L438找到字符串中所有字母异位词 {

    class Solution1 {
        public List<Integer> findAnagrams(String s, String p) {
            int[] need = new int[26];//用于存p中需要的每种字母数.
            for (char c : p.toCharArray()) {
                need[c - 'a']++;
            }
            int start = 0, end = 0;
            int[] window = new int[26];//表示窗口中的数据
            List<Integer> result = new ArrayList<>();
            while (end < s.length()) {
                window[s.charAt(end) - 'a']++;//更新窗口数据
                if (end - start + 1 == p.length()) {//维护一个p.length()长度的窗口,并更新答案,并更新窗口中的数据.
                    if (Arrays.equals(window, need)) {//通过数组比较!
                        result.add(start);//添加地址
                    }
                    window[s.charAt(start) - 'a']--;//收缩的同时改变窗口中的数据
                    start++;//收缩窗口
                }
                end++;
            }
            return result;
        }
    }


    //滑动窗口+哈希+数组值相等比较。
    class Solution {//2022年10月13日20:12:46再做。

        /**
         * 参数：[s, p]
         * 返回值：java.util.List<java.lang.Integer>
         * 作者： ladidol
         * 描述：判断
         */
        public List<Integer> findAnagrams(String s, String p) {
            int[] need = new int[26];
            int[] window = new int[26];
            for (int i = 0; i < p.length(); i++) {
                need[p.charAt(i) - 'a']++;
            }
            List<Integer> res = new ArrayList<>();
            int n = s.length();
            int left = 0, right = 0;
            while (right < n) {
                if (right - left + 1 <= p.length()) {
                    window[s.charAt(right) - 'a']++;
                }
                if (right - left + 1 == p.length()) {//到了p的长度了，就来验证一下。
                    if (Arrays.equals(window, need)) {
                        res.add(left);//存入窗口开始坐标
                    }
                    window[s.charAt(left) - 'a']--;//维护滑动窗口。
                    left++;
                }
                right++;
            }
            return res;
        }
    }


    //上面的通过不了，
    //滑动窗口+哈希+数组值相等比较。
    class Solution23 {//2主要差别是if else的切换导致的。2022年10月13日20:12:46再做。

        /**
         * 参数：[s, p]
         * 返回值：java.util.List<java.lang.Integer>
         * 作者： ladidol
         * 描述：判断
         */
        public List<Integer> findAnagrams(String s, String p) {
            int[] need = new int[26];
            int[] window = new int[26];
            for (int i = 0; i < p.length(); i++) {
                need[p.charAt(i) - 'a']++;
            }

            List<Integer> res = new ArrayList<>();

            int n = s.length();
            int left = 0, right = 0;
            while (right < n) {
                window[s.charAt(right) - 'a']++;
                if (right - left + 1 == p.length()) {//到了p的长度了，就来验证一下。
                    if (Arrays.equals(window, need)) {
                        res.add(left);//存入窗口开始坐标
                    }
                    window[s.charAt(left) - 'a']--;//维护滑动窗口。
                    left++;
                }
                right++;
            }
            return res;
        }
    }


}
