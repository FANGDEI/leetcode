package com.dyw.leetcode.algorithm.doublePointer;

/**
 * @author Devil
 * @since 2022-07-14-10:50
 * <p>
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
@SuppressWarnings("all")
public class L557反转字符串中的单词III {
    public static void main(String[] args) {
        System.out.println(new L557反转字符串中的单词III().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            sb.append(new StringBuffer(split[i]).reverse());
            if (i != split.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
