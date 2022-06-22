package com.dyw.leetcode.simple.string;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-06-22-13:30
 */
@SuppressWarnings("all")
public class L290单词规律 {
    public static void main(String[] args) {
        System.out.println(new L290单词规律().wordPattern("abba","dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        int length = str.length;
        if (length!=pattern.length()){
            return false;
        }
        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> sMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char c = pattern.charAt(i);
            if ((patternMap.containsKey(c)&&!patternMap.get(c).equals(str[i]))||(sMap.containsKey(str[i])&&sMap.get(str[i])!=c)){
                return false;
            }
            patternMap.put(c,str[i]);
            sMap.put(str[i],c);
        }
        return true;
    }
}
