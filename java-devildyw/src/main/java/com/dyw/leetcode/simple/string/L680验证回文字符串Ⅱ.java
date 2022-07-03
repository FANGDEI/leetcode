package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-03-13:59
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
@SuppressWarnings("all")
public class L680验证回文字符串Ⅱ {
    public static void main(String[] args) {
        System.out.println(new L680验证回文字符串Ⅱ().validPalindrome("abca"));
    }

    /**
     * 双指针
     *
     * <img src="https://assets.leetcode-cn.com/solution-static/680/680_fig1.png">
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;

        //双指针 前后遍历 如果两边一直到结束都相等那么返回true
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                //两边对应位置相等 指针同时偏移
                ++low;
                --high;
            } else {
                //如果在遍历过程中又发现不相等 那么久判断删除两边任意一个是否满足是回文串
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
