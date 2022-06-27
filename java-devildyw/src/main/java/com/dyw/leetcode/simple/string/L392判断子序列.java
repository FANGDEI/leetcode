package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-27-23:06
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
@SuppressWarnings("all")
public class L392判断子序列 {
    public static void main(String[] args) {
        System.out.println(new L392判断子序列().isSubsequence("aaaaaa", "bbaaaa"));
    }

    /**
     * 使用双指针 如果两个字符中有相等的就将s的指针加一 如此顺序执行就不会出现（例如，"ace"是"abcde"的一个子序列，而"aec"不是）的情况
     * 最后返回 i==n的结果
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int i = 0, j = 0;

        while (i<n&&j<m){
            if (s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==n;
    }
}
