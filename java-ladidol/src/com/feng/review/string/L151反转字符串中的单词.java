package com.feng.review.string;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L151颠倒字符串中的单词
 * @author: Ladidol
 * @description:
 * @date: 2022/7/26 17:16 2023年3月2日15:04:02
 * @version: 1.0
 */
public class L151反转字符串中的单词 {


    class Solution {
        /**
         * 通过正则匹配一波，\\s+表示" "
         * @param s
         * @return
         */
        public String reverseWords(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            String[] str = s.split("\\s+");//等价于" ", 正则匹配，但是不失多个空格的bug
            StringBuilder sb = new StringBuilder();
            for (int i = str.length - 1; i > 0; i--) {
                sb.append(str[i]).append(" ");
            }
            sb.append(str[0]);
            return sb.toString();
        }
    }
}

