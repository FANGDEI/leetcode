package com.feng.review.哈希;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L383赎金信
 * @author: Ladidol
 * @description:
 * @date: 2022/7/10 20:45 2023年3月1日00:03:57
 * @version: 1.0
 */
public class L383赎金信 {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
//            int[] arrR = new int[26];
            int[] arrM = new int[26];
            for (char c : magazine.toCharArray()) {
                arrM[c - 'a']++;
            }
            for (char c : ransomNote.toCharArray()) {
                arrM[c - 'a']--;
            }

            for (int i = 0; i < 26; i++) {
                if (arrM[i] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
