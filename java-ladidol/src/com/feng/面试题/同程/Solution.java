package com.feng.面试题.同程;

import java.util.Arrays;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/14 19:21
 * @description: {}
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param envelopes int整型二维数组
     * @return int整型
     */
    public int maxEnvelopes(int[][] envelopes) {
        // write code here
        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (check(envelopes, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }

    private boolean check(int[][] envelopes, int mid, int i) {
        return envelopes[mid][0] < envelopes[i][0] && envelopes[mid][1] < envelopes[i][1];
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 快速排序
     *
     * @param arr int整型一维数组 到各城市的距离
     * @return int整型一维数组
     */
    public int[] quickSort(int[] arr) {
        // write code here
        sort(0,arr.length-1,arr);
        return arr;
    }

    public void sort(int p, int r, int[] nums) {
        if (p >= r) {
            return;
        }
        int q = partition(p, r, nums);
        sort(p, q - 1, nums);
        sort(q + 1, r, nums);


    }

    private int partition(int start, int end, int[] nums) {
        int pivot = end;
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] > nums[pivot]) {
                swap(i++, j, nums);
            }
        }
        swap(i, pivot, nums);
        return i;
    }

    private void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}