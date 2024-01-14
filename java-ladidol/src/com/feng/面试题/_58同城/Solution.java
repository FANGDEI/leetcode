package com.feng.面试题._58同城;

public class Solution {


    public int maximumScore(int[] nums, int k) {
        // write code here
        int n = nums.length;
        int res = 0;
        int maxs = 0;
        for (int i = 0; i < n; i++) {
            maxs = Math.max(maxs, nums[i]);
        }
        int[] sum = new int[maxs + 1];
        for (int i = 0; i <= maxs; i++) {
            sum[i] = 0;
        }
        for (int i = 0; i < n; i++) {

            int tmp = Math.max(nums[i] - k, 0);
            sum[tmp] = sum[tmp] + 1;

            tmp = Math.min(nums[i] + k + 1, maxs);
            sum[tmp] = sum[tmp] - 1;
        }
        res = sum[0];
        for (int i = 1; i <= maxs; i++) {
            sum[i] = sum[i] + sum[i - 1];
            res = Math.max(res, sum[i]);
        }

        return res;

    }

    public int subsequence(String source, String pattern) {
        // write code here
        int count = 0;
        char[] sChars = source.toCharArray();
        char[] subChars = pattern.toCharArray();
        count = dfs(sChars, subChars, 0, 0);
        return count;


    }

    private int dfs(char[] sChars, char[] subChars, int sIndex, int subIndex) {
        if (subIndex == subChars.length) {
            return 1;
        }
        if (sIndex == sChars.length) {
            return 0;
        }

        int count = 0;
        if (sChars[sIndex] == subChars[subIndex]) {
            count += dfs(sChars, subChars, sIndex + 1, subIndex + 1);
        }
        count += dfs(sChars, subChars, sIndex + 1, subIndex);

        return count;
    }


}