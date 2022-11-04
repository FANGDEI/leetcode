package com.dyw.leetcode.simple.string;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-11-03-18:09
 */
@SuppressWarnings("all")
public class L1668最大重复子字符串 {

    public static void main(String[] args) {
        System.out.println(new L1668最大重复子字符串().maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

    /**
     * 简单枚举 + 动态规划
     * @param sequence
     * @param word
     * @return
     */
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();

        if (n<m){
            return 0;
        }

        //初始化一个dp数组
        int[] f = new int[n];
        //从 m-1 开始遍历 即满足条件的最小子串的长度应该和 word的字符串长度一致
        for (int i = m -1; i<n; ++i){
            boolean valid = true;
            //如果 字符比对不相等就跳出循环并指定标识为 false
            for (int j = 0; j < m; j++) {
                if (sequence.charAt(i-m+j+1)!=word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            //如果标识为true就更新dp数组
            if (valid){
                //根据前面的更新后续的
                f[i] = (i==m-1?0:f[i-m])+1;
            }
        }

        return Arrays.stream(f).max().getAsInt();


    }

}
