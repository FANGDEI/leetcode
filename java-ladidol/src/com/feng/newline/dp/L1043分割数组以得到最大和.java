package com.feng.newline.dp;

import java.util.Arrays;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/19 16:51
 * @description: {}
 */
public class L1043分割数组以得到最大和 {

    //dfs记忆化搜索，加缓存，枚举每个长度加缓存
    class Solution {
        /**
         * @param arr
         * @param k
         * @return
         */
        public int maxSumAfterPartitioning(int[] arr, int k) {
            // TODO: 2023/4/21 为啥感觉这里只算到了后面，没有辐射到前面的，可以试一下看看是不是i = index的地方
            return 0;

        }

    }

    static class Solution3 {
        // 思路：记忆化搜索，枚举每个长度，并记忆化
        // 时间复杂度：O（nk）状态个数n*单个状态的计算时间k
        // 空间复杂度：O（n）
        int[] record;

        public int maxSumAfterPartitioning(int[] arr, int k) {
            record = new int[arr.length];
            Arrays.fill(record, -1);
            return dfs(arr, k, 0);
        }

        int dfs(int[] nums, int k, int index) {
            if (index >= nums.length) {
                return 0;
            }
            if (record[index] != -1) {
                return record[index];
            }
            int sum = 0;
            int max = nums[index];
            for (int i = index; i < index + k && i < nums.length; i++) {
                max = Math.max(max, nums[i]);
                sum = Math.max(sum, max * (i - index + 1) + dfs(nums, k, i + 1));
            }
            record[index] = sum;
            return sum;
        }
    }

    //区间dp
    class Solution2 {
        /**
         * @param arr
         * @param k
         * @return
         */
        public int maxSumAfterPartitioning(int[] arr, int k) {
            return 0;
        }
    }

    public static void main(String[] args) {
//        Solution3 solution3 = new Solution3();
//        int[]
//        solution3.maxSumAfterPartitioning()
    }







}
