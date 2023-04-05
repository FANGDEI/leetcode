package top.dyw.leetcode.simple.hash;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * @author Devil
 * @since 2022-09-06-10:47
 */
@SuppressWarnings("all")
public class L242有效的字母异位词 {

    public static void main(String[] args) {

    }

    /**
     * 使用数组来记录字母的出现次数 如果出现次数相同则代表是异位词
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[s.charAt(i) - 'a']--;
        }

        //判断是否有不为0出现次数的字母 返回false
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
