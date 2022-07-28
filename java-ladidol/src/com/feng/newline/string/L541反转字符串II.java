package com.feng.newline.string;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L541反转字符串II
 * @author: Ladidol
 * @description: 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * @date: 2022/7/26 15:42
 * @version: 1.0
 */
public class L541反转字符串II {
    class Solution {
        //因为要找的也就是每2 * k 区间的起点，这样写，程序会高效很多。
        //所以当需要固定规律一段一段去处理字符串的时候，要想想在在for循环的表达式上做做文章。
        public String reverseStr(String s, int k) {
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i += (2 * k)) {
                int left = i;
                int right = Math.min(ch.length - 1, left + k - 1);
                while (left < right) {
                    char tmp = ch[left];
                    ch[left++] = ch[right];
                    ch[right--] = tmp;
                }
            }
            return new String(ch);//char[]通过这个方法变成字符串
        }
    }
}
