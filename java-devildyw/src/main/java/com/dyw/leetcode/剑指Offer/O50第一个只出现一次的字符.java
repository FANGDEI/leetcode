package com.dyw.leetcode.剑指Offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Devil
 * @since 2023-03-05-20:22
 */
@SuppressWarnings("all")
public class O50第一个只出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(new O50第一个只出现一次的字符().firstUniqChar("bacd"));
    }

    public char firstUniqChar(String s) {

        char ans = ' ';
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==1) {
                ans=chars[i];
                break;
            }
        }
        return ans;
    }

}
