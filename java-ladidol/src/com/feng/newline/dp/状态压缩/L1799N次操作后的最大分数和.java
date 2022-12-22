package com.feng.newline.dp.状态压缩;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2022/12/22 15:36
 * @description: {}
 * 给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。
 * 在第 i 次操作时（操作编号从 1 开始），你需要：
 * 选择两个元素 x 和 y 。
 * 获得分数 i * gcd(x, y) 。
 * 将 x 和 y 从 nums 中删除。
 * 请你返回 n 次操作后你能获得的分数和最大为多少。
 * 函数 gcd(x, y) 是 x 和 y 的最大公约数。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2]
 * 输出：1
 * 解释：最优操作是：
 * (1 * gcd(1, 2)) = 1
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,6,8]
 * 输出：11
 * 解释：最优操作是：
 * (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,5,6]
 * 输出：14
 * 解释：最优操作是：
 * (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 7
 * nums.length == 2 * n
 * 1 <= nums[i] <= 106
 */
public class L1799N次操作后的最大分数和 {
    //状态压缩dp
    class Solution {
        public int maxScore(int[] nums) {
            return 0;
        }
    }

    //阿丽亚的解法
    class Solution1213 {
        public int maxScore(int[] nums) {
            int n = nums.length;

            // 预处理 gcd 数组
            int[][] g = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = gcd(nums[i], nums[j]);
                }
            }

            int[] f = new int[1 << n];
            for (int i = 0; i < 1 << n; i++) {
                int cnt = Integer.bitCount(i);
                for (int j = 0; j < n; j++) {
                    if (((i >> j) & 1) == 1) {
                        for (int k = j + 1; k < n; k++) {
                            if (((i >> k) & 1) == 1)
                                f[i] = Math.max(f[i], f[i ^ (1 << j) ^ (1 << k)] + cnt / 2 * g[j][k]);
                        }
                    }
                }
            }
            return f[(1 << n) - 1];
        }

        int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}
