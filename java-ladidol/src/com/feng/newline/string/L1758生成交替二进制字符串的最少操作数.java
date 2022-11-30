package com.feng.newline.string;

/**
 * @author: ladidol
 * @date: 2022/11/29 15:08
 * @description: 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 */
public class L1758生成交替二进制字符串的最少操作数 {

    class Solution {
        /**
         * 作者：Ladidol
         * 描述：就两个情况遍历
         */
        public int minOperations(String s) {
            char[] chars = s.toCharArray();
            //01
            int a = 0;
            for (int i = 0; i < s.length(); i++) {
                if ((i & 1) == chars[i] - '0') a++;
            }
            //10
            int b = 0;
            for (int i = 0; i < s.length(); i++) {
                if ((i & 1) != chars[i] - '0') b++;
            }
            return Math.min(a, b);
        }
    }
}