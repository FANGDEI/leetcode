package com.jirafa.leetcode.algorithm.剑指;

public class 剑指58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int cnt=0,i=n; cnt <s.length(); cnt++,i++) {
            i%=s.length();
            sb.append(s.charAt(i));
        }
        return sb.toString();

        //切片写法
//        return s.substring(n, s.length()) + s.substring(0, n);
    }


}
