package com.feng.newline.string;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L151颠倒字符串中的单词
 * @author: Ladidol
 * @description: 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 无聊再看一下这个其他更高效的解法吧.
 * https://programmercarl.com/0151.%E7%BF%BB%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2%E9%87%8C%E7%9A%84%E5%8D%95%E8%AF%8D.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 * @date: 2022/7/26 17:16
 * @version: 1.0
 */
public class L151颠倒字符串中的单词 {
    public static void main(String[] args) {
//        System.out.println(new Solution().reverseWords("  hello world  "));
    }

    //我是用trim和split的弱鸡.
    class Solution {
        public String reverseWords(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            String[] str = s.split("\\s+");//等价于" ", 正则匹配.
            StringBuilder sb = new StringBuilder();
            for (int i = str.length - 1; i > 0; i--) {
                sb.append(str[i]).append(" ");
            }
            sb.append(str[0]);
            return sb.toString();
        }
    }
}

