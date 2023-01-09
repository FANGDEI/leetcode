package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-12-27-13:01
 */
@SuppressWarnings("all")
public class L2027转换字符串的最少操作次数 {

    public static void main(String[] args) {
        System.out.println(new L2027转换字符串的最少操作次数().minimumMoves("XXOX"));
    }

    public int minimumMoves(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='X'){
                count++;
                i+=2;
            }
        }
        return count;
    }
}
