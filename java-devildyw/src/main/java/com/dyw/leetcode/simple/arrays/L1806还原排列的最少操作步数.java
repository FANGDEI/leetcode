package com.dyw.leetcode.simple.arrays;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2023-01-09-22:18
 */
@SuppressWarnings("all")
public class L1806还原排列的最少操作步数 {

    public static void main(String[] args) {
        System.out.println(new L1806还原排列的最少操作步数().reinitializePermutation(6));
    }

    /**
     * 模拟
     *
     * @param n
     * @return
     */
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }

        int step = 0;
        while (true){
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i%2==0){
                    arr[i] = perm[i/2];
                }else{
                    arr[i] = perm[n/2+(i-1)/2];
                }
            }
            perm = arr;
            step++;
            if (Arrays.equals(perm,target)){
                break;
            }
        }

        return step;
    }
}
