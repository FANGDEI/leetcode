package com.dyw.leetcode.simple.arrays;

import java.util.ArrayList;

/**
 * @author Devil
 * @since 2022-06-19-14:02
 * <p>
 * 给你一个字符串s和一个字符c ，且c是s中出现过的字符。
 * <p>
 * 返回一个整数数组answer其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * <p>
 * 两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 */
@SuppressWarnings("all")
public class L821字符的最短距离 {
    public static void main(String[] args) {
        int[] ints = new L821字符的最短距离().shortestToChar01("loveleetcode", 'e');
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 笨方法: 两次遍历找最小值
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] res = new int[length];

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i)==c){
                integers.add(i);
            }
        }

        for (int i = 0; i < length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < integers.size(); j++) {
                if (Math.abs(i-integers.get(j))<min){
                    min = Math.abs(i-integers.get(j));
                }
            }
            res[i] = min;
        }
        return res;
    }

    /**
     * leetcode官方题解:
     * 问题可以转换成，对 ss 的每个下标 ii，求
     *
     * s[i]s[i] 到其左侧最近的字符 cc 的距离
     * s[i]s[i] 到其右侧最近的字符 cc 的距离
     * 这样左右两边的距离进行比较就能得到最小值
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar01(String s, char c){
        int n = s.length();
        int[] res = new int[n];

        //先从左往右遍历 初始化下标idx表示在遍历的过程中出现的c的字符的下标 遇到则更新
        for (int i = 0, idx = -n; i < n; i++) {
            if (s.charAt(i)==c){
                idx = i;
            }
            //从左往右遍历 每次遍历都会更新数组此时下标到c对应下标的距离
            res[i] = i-idx;//因为从左往右 所以最近出现的c对应下标一定是在左边的 所以是i-idx
        }

        //从右往左遍历 初始化下标idx表示在遍历的过程中出现的c的字符的下标 遇到则更新
        for (int i = n-1, idx=2*n; i >=0 ; i--) {
            if (s.charAt(i)==c){
                idx = i;
            }
            //这次遍历会取两次遍历中的最小值更新最终结果
            res[i] = Math.min(res[i],idx-i);//同上
        }
        return res;
    }
}
