package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-04-13:25
 * <p>
 * 给定两个字符串, s和goal。如果在若干次旋转操作之后，s能变成goal，那么返回true。
 * <p>
 * s的 旋转操作 就是将s 最左边的字符移动到最右边。
 * <p>
 * 例如, 若s = 'abcde'，在旋转一次之后结果就是'bcdea'
 */
@SuppressWarnings("all")
public class L796旋转字符串 {
    public static void main(String[] args) {
        System.out.println(new L796旋转字符串().rotateString("abcde", "cdeab"));
    }

    public boolean rotateString(String s, String goal) {
        int n = goal.indexOf(s.charAt(0)) + s.length();
        char[] chars = s.toCharArray();
        int m = chars.length;
        char temp = 0;
        while (n-- > 0) {
            temp = chars[0];
            for (int i = 1; i < m; i++) {
                chars[i - 1] = chars[i];
            }
            chars[m - 1] = temp;
            if (new String(chars).equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
