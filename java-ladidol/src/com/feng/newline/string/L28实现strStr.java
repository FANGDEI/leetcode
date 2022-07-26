package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L28实现strStr
 * @author: Ladidol
 * @description: 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 题解: https://programmercarl.com/0028.%E5%AE%9E%E7%8E%B0strStr.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 * kmp,前缀表,滑动窗口
 * @date: 2022/7/26 18:37
 * @version: 1.0
 */
public class L28实现strStr {
    class Solution2 {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }

    class Solution {
        //前缀表（不减一, 也不后移）Java实现
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) return 0;
            int[] next = new int[needle.length()];
            getNext(next, needle);//构造模式串的next数组.

            int j = 0;
            for (int i = 0; i < haystack.length(); i++) {//类似于getNext中字符串匹配的过程
                while (j > 0 && needle.charAt(j) != haystack.charAt(i))//不匹配就回退.
                    j = next[j - 1];
                if (needle.charAt(j) == haystack.charAt(i))//相等就后面移动
                    j++;
                if (j == needle.length())//移动至模式串尾部就返回index;
                    return i - needle.length() + 1;
            }
            return -1;
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
