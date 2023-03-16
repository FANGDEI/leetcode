package top.dyw.leetcode.simple.arrays;

/**
 *
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * 请你返回 words 数组中 一致字符串 的数目。
 *
 * @author Devil
 * @since 2022-11-08-10:18
 */
@SuppressWarnings("all")
public class L1684统计一致字符串的数目 {

    public static void main(String[] args) {
        System.out.println(new L1684统计一致字符串的数目().countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"}));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int[] set = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            set[allowed.charAt(i)-'a']++;
        }
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (compare(set,words[i])){
                count++;
            }
        }
        return count;
    }

    private boolean compare(int[] set, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (set[word.charAt(i)-'a']==0){
                return false;
            }
        }
        return true;
    }

}
