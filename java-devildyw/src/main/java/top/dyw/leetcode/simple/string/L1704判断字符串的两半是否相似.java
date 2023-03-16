package top.dyw.leetcode.simple.string;

import java.util.HashSet;

/**
 *
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 *
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 *
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 *
 * @author Devil
 * @since 2022-11-11-10:49
 */
@SuppressWarnings("all")
public class L1704判断字符串的两半是否相似 {

    public static void main(String[] args) {
        System.out.println(new L1704判断字符串的两半是否相似().halvesAreAlike("book"));
    }

    HashSet<Character> set = new HashSet<>();
    public boolean halvesAreAlike(String s) {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int count1 = 0;
        int count2 = 0;

        int n = s.length();
        String s1 = s.substring(0, n/2);
        String s2 = s.substring(n/2);

        for (int i = 0; i < s1.length(); i++) {
            if (set.contains(s1.charAt(i))){
                count1++;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s1.charAt(i))){
                count2++;
            }
        }


        return count1==count2;
    }
}
