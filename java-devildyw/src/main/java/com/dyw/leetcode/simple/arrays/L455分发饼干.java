package com.dyw.leetcode.simple.arrays;

import java.util.Arrays;

/**
 * @author Devil
 * @date 2022-05-17-14:25
 */
@SuppressWarnings("all")
public class L455分发饼干 {
    public static void main(String[] args) {

    }

    /**
     * 排序+贪心
     * 将两个数组进行排序 优先满足胃口小的孩子
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLength = g.length;
        int sLength = s.length;

        int count = 0;
        for (int i = 0, j = 0; i < gLength && j < sLength; i++, j++) {
            while (j < sLength && g[i] > s[j]) {
                j++;
            }
            if (j < sLength) {
                count++;
            }
        }
        return count;
    }
}
