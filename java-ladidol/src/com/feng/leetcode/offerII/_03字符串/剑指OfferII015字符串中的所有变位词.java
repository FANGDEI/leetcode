package com.feng.leetcode.offerII._03字符串;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/22 21:22
 * @description: {}
 */
public class 剑指OfferII015字符串中的所有变位词 {
    class Solution {
        /**
         * 类似于上一个题；
         *
         * @param s
         * @param p
         * @return
         */
        public List<Integer> findAnagrams(String s, String p) {
            if (p.length() > s.length()) {
                return new LinkedList<>();
            }
            List<Integer> res = new LinkedList<>();
            char[] standard = new char[26];
            char[] subChars = new char[26];
            for (int i = 0; i < p.length(); i++) {
                standard[p.charAt(i) - 'a']++;
                subChars[s.charAt(i) - 'a']++;
            }
            if (Arrays.equals(standard, subChars)) {
                res.add(0);
            }
            for (int i = 0; i + p.length() < s.length(); i++) {

                subChars[s.charAt(i) - 'a']--;
                subChars[s.charAt(i + p.length()) - 'a']++;
                if (Arrays.equals(standard, subChars)) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
}
