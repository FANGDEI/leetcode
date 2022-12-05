package com.jirafa.leetcode.algorithm.greedy;

import org.junit.Test;

public class L738 {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = chars.length-1; i > 0; i--) {
            if(chars[i]<chars[i-1]) {
                chars[i]='9';
                chars[i-1]-='1'-'0';
            }
        }
        for (int i = 0; i < chars.length-1; i++) {
            if(chars[i]>chars[i+1]) {
                chars[i+1]='9';
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    private boolean check(int n) {
        String s = String.valueOf(n);
        if(s.length()==1)
            return true;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)<s.charAt(i-1))
                return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(new L738 ().monotoneIncreasingDigits(777616726));
    }
}
