package com.dyw.leetcode.algorithm.slidingWindow;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-07-16-11:46
 * <p>
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
@SuppressWarnings("all")
public class L567字符串的排列 {
    public static void main(String[] args) {
        System.out.println(new L567字符串的排列().checkInclusion("adc", "dcda"));
    }

    /**
     * 滑动窗口 非优化版本
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int right = 0;

        for (int i = 0; i < m; i++) {
            while (right - i + 1 < n) {
                right++;
            }
            if (right + 1 <= m && checkString(s1, s2.substring(i, right + 1))) {
                return true;
            }
        }
        return false;
    }

    // TODO: 2022/7/16 后续优化字符串比较的时间复杂度 
    private boolean checkString(String s1, String substring) {
        int[] cnt = new int[26];
        int[] cnt1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < substring.length(); i++) {
            cnt1[substring.charAt(i) - 'a']++;
        }
        return Arrays.equals(cnt, cnt1);
    }
}
