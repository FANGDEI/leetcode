package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-30-13:04
 *
 * 给你两个字符串a和b，请返回 这两个字符串中 最长的特殊序列 的长度。如果不存在，则返回 -1。
 *
 * 「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *
 * 字符串s的子序列是在从s中删除任意数量的字符后可以获得的字符串。
 *
 * 例如，"abc" 是 "aebdc" 的子序列，因为删除 "aebdc" 中斜体加粗的字符可以得到 "abc" 。 "aebdc" 的子序列还包括 "aebdc" 、 "aeb" 和 "" (空字符串)。
 *
 */
@SuppressWarnings("all")
public class L521最长特殊序列Ⅰ {
    public static void main(String[] args) {

    }

    /**
     * 脑筋急转弯
     *
     * 当两个字符串不同时 那么直接返回长度最大的那个子串 因为以长的为子串那么 短的那个更不不肯拥有这么长的子串 而且这也是最长的子串了
     * 如果两个相同时 那么就没了最长特殊序列了.直接返回-1;
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(),b.length()) : -1;
    }
}
