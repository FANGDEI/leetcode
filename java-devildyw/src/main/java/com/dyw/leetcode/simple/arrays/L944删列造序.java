package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-07-08-10:50
 * <p>
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 * 你需要找出并删除 不是按字典序升序排列的 列。
 * 返回你需要删除的列数。
 */
@SuppressWarnings("all")
public class L944删列造序 {
    public static void main(String[] args) {
        System.out.println(new L944删列造序().minDeletionSize(new String[]{"rrjk", "furt", "guzm"}));
    }

    /**
     * 就按列遍历
     *
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int[] flag = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    flag[i] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < flag.length; i++) {
            res += flag[i];
        }
        return res;
    }


    /**
     * 改良版
     *
     * @param strs
     * @return
     */
    public int minDeletionSize01(String[] strs) {
        //初始化参数
        int n = strs.length;
        int m = strs[0].length();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //如果出现不满足升序的条件时 说明该列不满足条件 res++ 且break;
                if (strs[j-1].charAt(i)>strs[j].charAt(i)){
                    res++;
                    break;
                }
            }
        }
        //返回
        return res;
    }
}