package com.dyw.leetcode.simple.hash;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * @author Devil
 * @since 2022-09-06-10:53
 */
@SuppressWarnings("all")
public class L383赎金信 {

    public static void main(String[] args) {

    }


    /**
     * 数组也算是哈希表的一种哦
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            if (count[index] > 0) {
                count[index]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
