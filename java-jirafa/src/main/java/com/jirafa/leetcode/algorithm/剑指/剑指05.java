package com.jirafa.leetcode.algorithm.剑指;

public class 剑指05 {
    public String replaceSpace(String s) {
        if (s.length()==0)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
