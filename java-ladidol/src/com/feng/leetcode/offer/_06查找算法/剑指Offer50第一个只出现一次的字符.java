package com.feng.leetcode.offer._06查找算法;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 20:22
 * @description: {}
 */
public class 剑指Offer50第一个只出现一次的字符 {


    //简单点
    class Solution {
        public char firstUniqChar(String s) {
            int[] cnt = new int[26];
            for(char c : s.toCharArray()){
                cnt[c - 'a']++;
            }
            for(char c : s.toCharArray()){
                if(cnt[c - 'a'] == 1) return c;
            }
            return ' ';
        }
    }

}
