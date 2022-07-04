package com.dyw.leetcode.simple.string;

import java.util.ArrayList;

/**
 * @author Devil
 * @since 2022-07-04-12:44
 *
 * 给定一个字符串s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 *
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 *
 *
 */
@SuppressWarnings("all")
public class L696计数二进制子串 {
    public static void main(String[] args) {
        System.out.println(new L696计数二进制子串().countBinarySubstrings("00110011"));
    }

    /**
     * 官方题解一: 使用一个数组存储字符串中连续出现的0个1的个数分段存储 这样数组相邻的数一定代表1和0
     * 这样由于要有相同个数的1和0且连续, 连续我们数组以及做到了 相同数量即是去相邻两个数中的最小值即可(0011两边同时去掉一个0和一个1依然满足 所以如果两边0和1个数相同 可以组成的子串就为0或1的个数)
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        ArrayList<Integer> counts = new ArrayList<>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                count++;
                ptr++;
            }
            counts.add(count);

        }
        int ans = 0;
        for (int i = 1; i < counts.size(); i++) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }

    /**
     * 官方题解改良版 其实数组中只用到了前一个数和后一个数 就此我们可以简化空间复杂度 使用一个变量来存储前一个数
     * @param s
     * @return
     */
    public int countBinarySubstrings01(String s) {
        int n = s.length();
        //初始化存储上一次计数结果的变量last 遍历指针ptr 结果计数ans
        int last = 0, ptr = 0, ans = 0;
        while (ptr<n){
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr<n&&s.charAt(ptr)==c){
                count++;
                ptr++;
            }
            //这次的连续字段计数与上一次的字段计数去最小值
            ans += Math.min(last,count);
            //记录上一次的结果
            last = count;

        }
        return ans;
    }
}