package com.feng.newline.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L213打家劫舍II
 * @author: Ladidol
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * @date: 2022/9/2 20:52
 * @version: 1.0
 */
public class L213打家劫舍II {

    class Solution1234 {
        // 因为围成了一个圈：考虑第一个不考虑最后一个，不考虑第一个考虑最后一个。
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            int[] dpFirst = new int[nums.length], dpEnd = new int[nums.length];
            dpFirst[0] = nums[0];// 考虑第一个元素。
            dpFirst[1] = Math.max(nums[1], nums[0]);
            dpEnd[0] = 0;//不考虑第一个元素
            dpEnd[1] = nums[1];
            for (int i = 2; i < nums.length; i++) {
                dpEnd[i] = Math.max(dpEnd[i - 1], dpEnd[i - 2] + nums[i]);
                if (i + 1 != nums.length) {//dpFirst不考虑最后一个元素。
                    dpFirst[i] = Math.max(dpFirst[i - 1], dpFirst[i - 2] + nums[i]);
                } else {
                    dpFirst[i] = dpFirst[i - 1];
                }
            }
            return Math.max(dpFirst[nums.length - 1], dpEnd[nums.length - 1]);
        }
    }

    //dp
    class Solution12341 {
        /**
         * 参数：[nums]
         * 返回值：int
         * 作者： ladidol
         * 描述：循环数组，应对方式，二线dp。2022年10月27日21:31:55
         */
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return nums[0];
            int[][] dp = new int[n][2];//0表示不考虑第一个但考虑最后一个，1则相反。

            //初始化
            dp[0][0] = 0;
            dp[1][0] = Math.max(dp[0][0], nums[1]);
            dp[0][1] = Math.max(0, nums[0]);
            dp[1][1] = Math.max(dp[0][1], nums[1]);

            for (int i = 2; i < n; i++) {
                if (i == n - 1) {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1]);//不考虑最后一个
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
            }
            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }
    }


    //dp
    class Solution {//2022年11月2日08:44:22

        /**
         * 参数：[nums]
         * 返回值：int
         * 作者： ladidol
         * 描述：背都背到了，用两个互相错位的dp。
         */
        public int rob(int[] nums) {
            int n = nums.length;
            if (n==1) return nums[0];

            int[] leftDp = new int[n];
            int[] rightDp = new int[n];

            // 第一个dp考虑第一个元素。
            leftDp[0] = Math.max(0, nums[0]);
            leftDp[1] = Math.max(leftDp[0], nums[1]);

            // 第二个dp考虑第二个元素。
            rightDp[0] = 0;
            rightDp[1] = Math.max(0, nums[1]);

            for (int i = 2; i < n; i++) {
                if (i != n - 1) {
                    leftDp[i] = Math.max(leftDp[i - 1], leftDp[i - 2] + nums[i]);
                } else {
                    leftDp[i] = Math.max(leftDp[i - 1], leftDp[i - 2]);
                }
                rightDp[i] = Math.max(rightDp[i - 1], rightDp[i - 2] + nums[i]);
            }
            return Math.max(leftDp[n - 1], rightDp[n - 1]);
        }
    }


}
