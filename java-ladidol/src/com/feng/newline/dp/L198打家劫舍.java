package com.feng.newline.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L198打家劫舍
 * @author: Ladidol
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * @date: 2022/9/2 20:21
 * @version: 1.0
 */
public class L198打家劫舍 {

    // 如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i] ，即：第i-1房一定是不考虑的，找出 下标i-2（包括i-2）以内的房屋，最多可以偷窃的金额为dp[i-2] 加上第i房间偷到的钱。
    // 如果不偷第i房间，那么dp[i] = dp[i - 1]，即考虑i-1房，（注意这里是考虑，并不是一定要偷i-1房，这是很多同学容易混淆的点）
    // dp[i] = math.max(dp[i-1],dp[i-2]+ nums[i]);
    class Solution123 {
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);// 这里初始化留一个小心眼，要满足最大，才能装进dp数组。
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }

    //dp
    class Solution12341 {
        /**
         * 参数：[nums]
         * 返回值：int
         * 作者： ladidol
         * 描述：主要是判断当前房屋考虑不。2022年10月27日20:58:35。好像用状态机dp多此一举了。
         */
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return nums[0];
            int[] dp = new int[n];
            dp[0] = Math.max(nums[0], 0);//选与不选当前房屋。
            dp[1] = Math.max(nums[1], dp[0]);

            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

            }
            return dp[n - 1];
        }
    }


    //dp
    class Solution { //2022年11月2日08:39:07很巧，又碰到这题了
        /**
         * 参数：[nums]
         * 返回值：int
         * 作者： ladidol
         * 描述：对以前的答案依稀还有记忆，只用一个一维dp就能做。
         */
        public int rob(int[] nums) {
            int n = nums.length;

            if (n==1)return nums[0];

            int[] dp = new int[n];
            dp[0] = Math.max(0, nums[0]);
            dp[1] = Math.max(dp[0], nums[1]);//依旧是默认从当前位置的房屋考虑一下偷不偷。
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[n - 1];
        }
    }


}
