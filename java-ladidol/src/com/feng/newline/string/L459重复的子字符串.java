package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L459重复的子字符串
 * @author: Ladidol
 * @description: 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * @date: 2022/7/26 23:27
 * @version: 1.0
 */
public class L459重复的子字符串 {

    public static void main(String[] args) {
//        System.out.println(new Solution().repeatedSubstringPattern("abab"));
    }
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s.equals("")) {
                return false;
            }
            int[] next = new int[s.length()];
            getNext(next, s);
            int len = s.length();
            if (next[len - 1] != 0 && len % (len - (next[len - 1])) == 0) {//当且仅当这时候满足题意.
                return true;
            }
            return false;
        }

        private void getNext(int[] next, String s) {
            int j = 0;//默认next的值是0;
            next[0] = j;//默认next第一位下标是0;
            for (int i = 1; i < s.length(); i++) {//默认next从下标1开始慢慢修改.
                while (j > 0 && s.charAt(j) != s.charAt(i))//只要不匹配,就回退.
                    j = next[j - 1];
                if (s.charAt(j) == s.charAt(i))//相等就往后面移动
                    j++;
                next[i] = j;//记录当前j的值作为next的值.
            }
        }
    }
}

