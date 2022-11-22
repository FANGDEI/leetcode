package com.jirafa.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L17 {
    List<String> result=new LinkedList<>();
    StringBuilder sb=new StringBuilder();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits ==null||digits.length()==0)
            return  result;
        backTracking(digits,0);
        return result;
    }

    public void backTracking(String digits,int num){
        if(sb.length()==digits.length()) {
            result.add(sb.toString());
            return;
        }
        int index = Integer.parseInt(String.valueOf(digits.charAt(num)));
        System.out.println("index:-->"+index);
        System.out.println("sb:"+sb.length());
        System.out.println("l--->"+digits.length());
        String s = numString[index];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backTracking(digits,num+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
