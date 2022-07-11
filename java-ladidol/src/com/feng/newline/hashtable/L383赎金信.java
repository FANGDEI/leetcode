package com.feng.newline.hashtable;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L383赎金信
 * @author: Ladidol
 * @description:
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例:
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * @date: 2022/7/10 20:45
 * @version: 1.0
 */
public class L383赎金信 {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] arrR = new int[26];
            int[] arrM = new int[26];
            for (char c : ransomNote.toCharArray()){
                arrR[c-'a'] ++;
            }
            for (char c : magazine.toCharArray()){
                arrM[c-'a'] ++;
            }
            for (int i = 0; i < 26; i++) {
                if (arrR[i]>arrM[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
