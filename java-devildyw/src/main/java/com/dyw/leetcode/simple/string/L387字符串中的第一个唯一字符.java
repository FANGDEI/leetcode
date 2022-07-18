package com.dyw.leetcode.simple.string;

import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-06-24-13:34
 *
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 */
@SuppressWarnings("all")
public class L387字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        System.out.println(new L387字符串中的第一个唯一字符().firstUniqChar("leetcode"));

    }

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i==s.lastIndexOf(s.charAt(i))&&i==s.indexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar01(String s) {
        int[] array = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            array[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (array[s.charAt(i)-'a']==1){
                return i;
            }
        }

        return -1;
    }


    public int firstUniqChar02(String s) {
        //使用对应小写字母的数组 来存储字母出现的关系
        int[] ints = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            ints[s.charAt(i)-'a']++;
        }
        //再通过遍历原字符串的顺序找到第一个唯一出现一次的字符串
        for (int i = 0; i < n; i++) {
            if (ints[s.charAt(i)-'a']== 1){
                return i;
            }
        }
        return -1;
    }












}

