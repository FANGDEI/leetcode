package top.dyw.leetcode.simple.string;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-06-21-12:57
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */
@SuppressWarnings("all")
public class L242有效的字母异位词 {
    public static void main(String[] args) {
        System.out.println(new L242有效的字母异位词().isAnagram("bnagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr2[t.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 排序
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram01(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public boolean isAnagram02(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars);

        return new String(chars1).equals(new String(chars));
    }
}
