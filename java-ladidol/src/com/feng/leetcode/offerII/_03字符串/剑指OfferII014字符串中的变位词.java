package com.feng.leetcode.offerII._03字符串;

import java.util.Arrays;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/12 14:22
 * @description: {}
 */
public class 剑指OfferII014字符串中的变位词 {

    class Solution {
        /**
         * 对题意进行理解，只需要数一下字母出现的个数，按照26个字母的顺序等于数组下标的顺序，就不需要排序啦
         *
         * @param s1
         * @param s2
         * @return
         */
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            char[] standard = new char[26];
            char[] subChars = new char[26];
            for (int i = 0; i < s1.length(); i++) {//需要注意这里
                standard[s1.charAt(i) - 'a']++;
                subChars[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(standard, subChars)) {
                return true;
            }
            for (int i = 0; i + s1.length() < s2.length(); i++) {

                subChars[s2.charAt(i) - 'a']--;
                subChars[s2.charAt(i + s1.length()) - 'a']++;
                if (Arrays.equals(standard, subChars)) {
                    return true;
                }
            }
            return false;
        }
    }

    //高复杂度的
    class Solution2 {
        /**
         * 题中的子串，是必须连续的，不是之前以为的子串
         * 滑动窗口看一下排序后的子串（长度为s1.length）和s1是否相等
         *
         * @param s1
         * @param s2
         * @return
         */
        public boolean checkInclusion(String s1, String s2) {
            char[] char1 = s1.toCharArray();
            Arrays.sort(char1);
            for (int left = 0, right = s1.length() - 1; right < s2.length(); right++, left++) {
                if (checkRight(char1, s2.substring(left, right + 1))) {
                    return true;
                }
            }
            return false;
        }

        public boolean checkRight(char[] char1, String b) {
            char[] char2 = b.toCharArray();
            Arrays.sort(char2);
            return Arrays.equals(char1, char2);
        }


    }

}
