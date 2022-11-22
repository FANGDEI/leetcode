package com.jirafa.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L93 {
    List<String> result=new LinkedList<>();
    List<String> tmp=new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12||s.length()<4)
            return result;
        backTracking(s,0);
//        backTracking(s,0,0);
        return result;
    }

    public void backTracking(String s,int index){
        if(tmp.size()==3){
//            System.out.println(index);
            if(isValid(s.substring(index))) {
                StringBuilder ss = new StringBuilder();
                for (int i = 0; i < tmp.size(); i++) {
                    ss.append(tmp.get(i));
                    ss.append(".");
                }
                ss.append(s.substring(index));
                result.add(ss.toString());
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if(isValid(str)){
//                s=s.substring(0,i+1)+"."+s.substring(i+1);
                tmp.add(str);
                if(i+1<s.length())
                backTracking(s,i+1);
//                s=s.substring(0,i+1)+s.substring(i+2);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public void backTracking(String s,int index,int potNum){
        if(potNum==3){
            if(isValid(s,index,s.length()-1))
                result.add(s);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if(isValid(s,index,i)){
                s=s.substring(0,i+1)+"."+s.substring(i+1);
                backTracking(s,i+2,potNum+1);
                s=s.substring(0,i+1)+s.substring(i+2);
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

    private Boolean isValid(String s) {
//        if (s.length()==1) {
//            return false;
//        }
        if (s.charAt(0) == '0'&&s.length()>1) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L93 l93 = new L93();
//        System.out.println(l93.isValid("2",0,0));
        System.out.println(l93.restoreIpAddresses("101023"));
    }
}
