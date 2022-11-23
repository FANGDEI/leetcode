package com.jirafa.leetcode.algorithm.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L131 {
    List<List<String>> result=new LinkedList<>();
    LinkedList<String> path=new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return result;
    }

    public void backTracking(String s,int index){
        if(index>=s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if(isPalindrome(substring)){
                path.add(substring);
                backTracking(s,i+1);
                path.removeLast();
            }
        }

    }

    public boolean isPalindrome(String s){
        boolean flag=true;
        for (int i = 0,j=s.length()-1; i <= j ; i++,j--) {
            if(s.charAt(i)!=s.charAt(j)){
                flag=false;
                break;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        System.out.println(new L131().partition("aab"));
    }
}
