package com.feng.review.哈希;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L242有效的字母异位词
 * @author: Ladidol
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * @date: 2022/7/10 20:33 2023年2月28日22:54:15
 * @version: 2.0
 */
public class L242有效的字母异位词 {

    class Solution {
        //法1 哈希法
        public boolean isAnagram(String s, String t) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()){
                arr[c-'a'] ++;
            }
            for (char c : t.toCharArray()){
                arr[c-'a'] --;
            }
            for (int i : arr) {
                if (i!=0){
                    return false;
                }
            }
            return true;
        }
        //法2
        public boolean isAnagram2(String s, String t) {
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            Arrays.sort(sChars);
            Arrays.sort(tChars);
            return Arrays.equals(sChars, tChars);
        }
    }
}
