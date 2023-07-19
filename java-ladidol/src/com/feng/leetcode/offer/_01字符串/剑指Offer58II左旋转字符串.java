package com.feng.leetcode.offer._01字符串;

public class 剑指Offer58II左旋转字符串 {

    //取模
    class Solution {
        public String reverseLeftWords(String s, int n) {
            int len = s.length();
            StringBuilder ans = new StringBuilder();
            for (int i = n; i < len + n; i++) {
                ans.append(s.charAt(i % len));
            }
            return ans.toString();
        }
    }
}
