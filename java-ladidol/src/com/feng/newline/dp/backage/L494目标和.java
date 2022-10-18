package com.feng.newline.dp.backage;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L494目标和
 * @author: Ladidol
 * @description: 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1
 * 输出：1
 * @date: 2022/8/18 2:32
 * @version: 1.0
 */
public class L494目标和 {
    // ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓==DFS==↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 数据范围只有 20，而且每个数据只有 +/− 两种选择，因此可以直接使用 DFS 进行「爆搜」。
    // dfs（第一种，纯回溯模板）
    //用回溯做一下。aaaaa我想说这题分明回溯就能做啊！！！
    class Solution3 {
        int[] nums;
        int target;
        //        int curSum;
        int res = 0;

        public int findTargetSumWays(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
            backtracking(0, 0);//第一次是没算进去的。
            return res;
        }

        void backtracking(int startIndex, int curSum) {
            if (startIndex == nums.length && curSum == target) {
                res++;
                return;
            }
            if (startIndex == nums.length) return;
            backtracking(startIndex + 1, curSum - nums[startIndex]);
            backtracking(startIndex + 1, curSum + nums[startIndex]);
        }
    }

    // dfs（dfs模板）
    //用回溯做一下。aaaaa我想说这题分明回溯就能做啊！！！
    class Solution4 {
        int[] nums;
        int target;

        public int findTargetSumWays(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
            int res = dfs(0, 0);//第一次是没算进去的。
            return res;
        }

        int dfs(int startIndex, int curSum) {
            if (startIndex == nums.length) {
                return curSum == target ? 1 : 0;
            }
            int left = dfs(startIndex + 1, curSum + nums[startIndex]);
            int right = dfs(startIndex + 1, curSum - nums[startIndex]);
            return left + right;
        }
    }


    // 记忆性搜索
    class Solution5 {
        // 不难发现，在 DFS 的函数签名中只有「数值下标 startIndex」和「当前结算结果 curSum」为可变参数，考虑将其作为记忆化容器的两个维度，
        // 返回值作为记忆化容器的记录值。由于 curSum 存在负权值，为了方便，我们这里不设计成静态数组，而是使用「哈希表」进行记录。
        int[] nums;
        int target;
        Map<String, Integer> cache = new HashMap<>();//缓存器

        public int findTargetSumWays(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
            return dfs(0, 0);
        }

        int dfs(int startIndex, int curSum) {
            String key = startIndex + "_" + curSum;//以这两个可变参数作为key，代替i和j的角色
            if (cache.containsKey(key)) return cache.get(key);
            if (startIndex == nums.length) {
                return curSum == target ? 1 : 0;
            }
            int left = dfs(startIndex + 1, curSum + nums[startIndex]);
            int right = dfs(startIndex + 1, curSum - nums[startIndex]);
            //维护cache
            cache.put(key, left + right);
            return left + right;
        }
    }


    // ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓==动态规划==↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓


    //正常dp思路, 根据记忆性搜索很轻易得到。因为这里有负数的存在，所以普通的ij下标不足以满足要求，这里要右偏移一点。

    class Solution1 {
        public int findTargetSumWays(int[] nums, int target) {
            //可能有nums的最大和也到不了target的绝对值，直接不合法咯
            int absSum = 0;
            for (int num : nums) {
                absSum += Math.abs(num);
            }
            if (absSum < Math.abs(target)) return 0;
            //初始化dp
            int[][] dp = new int[nums.length + 1][absSum * 2 + 1];//dp[0][s]是有意义的，代表的是没有nums，不是代表的nums第一位数字。
            dp[0][absSum] = 1;//代表不考虑任何数，凑出计算结果为 0 的方案数为 1 种。

            for (int i = 1; i <= nums.length; i++) {
                int x = nums[i - 1];
                for (int j = -absSum; j <= absSum; j++) {
                    //有负数target，所以在2*absSum+1的第二维度上，是需要有个absSum的偏移值。
                    if (j - x + absSum >= 0) dp[i][j + absSum] += dp[i - 1][j - x + absSum];
                    if (j + x + absSum <= 2 * absSum) dp[i][j + absSum] += dp[i - 1][j + x + absSum];
                }
            }
            return dp[nums.length][absSum + target];
        }
    }
    //在上述「动态规划」分析中，我们总是尝试将所有的状态值都计算出来，当中包含很多对「目标状态」不可达的“额外”状态值。
    //即达成某些状态后，不可能再回到我们的「目标状态」。
    //例如当我们的 target 不为 -s 和 s 时，-s 和 s 就是两个对「目标状态」不可达的“额外”状态值，到达 -s 或 s 已经使用所有数值，对 target 不可达。
    //我们可以从哪些数值使用哪种符号来分析，即划分为「负值部分」&「非负值部分」，令「负值部分」的绝对值总和为 m，即可得：


    // (absSum - m)- m = target =====> m = (absSum - target) / 2;只统计负数总和背包情况。
    //01背包二维思路：
    //1. 确定dp数组以及下标的含义： 表示负值部分为j的，只考虑0-i数字有多少种可能。总结就是负值背包（同时你可以是正值背包）
    //2. 确定递推公式：存在 选 与 不选 的情况：dp[i][j] = dp[i - 1][j] + dp[i - 1][j - x]
    //3. dp数组如何初始化：dp[0][0]=1 代表不考虑任何数，凑出计算结果为 0 的方案数为 1 种。
    class Solution2 {
        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            int absSum = 0;
            for (int i : nums) absSum += Math.abs(i);
            if (target > absSum || (absSum - target) % 2 != 0) return 0;//这是推导过程中要的。例如：absSum 是5，target是2的话其实就是无解的
            int m = (absSum - target) / 2;
            int[][] dp = new int[n + 1][m + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int x = nums[i - 1];
                for (int j = 0; j <= m; j++) {
                    dp[i][j] += dp[i - 1][j];//负值背包中不包括nums[i];
                    if (j >= x) dp[i][j] += dp[i - 1][j - x];//负值背包中包括nums[i];
                }
            }
            return dp[n][m];
        }
    }


    //转换一下思考：假设加法的总和为x，那么减法对应的总和就是absSum - x。所以我们要求的是 x - (absSum - x) = target   x = (target + absSum) / 2


    //01背包一维数组思路：
    //1. 确定dp数组以及下标的含义：dp[j]填满j（包括j）这么大容积的包，有dp[j]种方法
    //2. 确定递推公式：dp[j] += dp[j - nums[i]];
    //3. dp数组如何初始化：dp[0] = 1，理论上也很好解释，装满容量为0的背包，有1种方法，就是装0件物品。
    //4. 确定遍历顺序：dp一维滚动数组遍历
    //5. 举例推导dp数组：
    class Solution234 {
        public int findTargetSumWays(int[] nums, int target) {
            int absSum = 0;
            for (int i = 0; i < nums.length; i++) absSum += nums[i];
            if (Math.abs(target) > absSum) return 0;//没有方案；
            if ((target + absSum) % 2 != 0) return 0;//没有解；
            int size = (target + absSum) / 2;//size一定是大于等于0；

            // 核心是这里
            int[] dp = new int[size + 1];
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = size; j >= nums[i]; j--) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[size];
        }
    }


    // (absSum - m)- m = target =====> m = (absSum - target) / 2;只统计负数总和背包情况。
    class Solution8 {// 计算差

        public int findTargetSumWays(int[] nums, int target) {
            int absSum = 0;
            for (int i = 0; i < nums.length; i++) absSum += nums[i];
            if (Math.abs(target) > absSum) return 0;//没有方案；
            if ((target + absSum) % 2 != 0) return 0;//没有解；
            int size = (absSum - target) / 2;//

            // 核心是这里
            int[] dp = new int[size + 1];
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = size; j >= nums[i]; j--) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[size];
        }
    }

    //这种题，能用回溯就用回溯咯，何必想那么多。
    //简单的dfs
    class Solution1234242 {//2022年10月17日13:31:28再做一遍。

        /**
         * 参数：[nums, target]
         * 返回值：int
         * 作者： ladidol
         * 描述：
         */
        public int findTargetSumWays(int[] nums, int target) {
            dfs(0, 0, target, nums);
            return res;
        }

        int res = 0;

        void dfs(int curIndex, int curSum, int target, int[] nums) {
            if (curSum == target && curIndex == nums.length) {
                res++;
                return;
            }
            if (curIndex == nums.length) return;

            dfs(curIndex + 1, curSum + nums[curIndex], target, nums);
            dfs(curIndex + 1, curSum - nums[curIndex], target, nums);
        }
    }

    // 记忆性搜索：
    // 不难发现，在 DFS 的函数签名中只有「数值下标 startIndex」和「当前结算结果 curSum」为可变参数，考虑将其作为记忆化容器的两个维度，
    // 返回值作为记忆化容器的记录值。由于 curSum 存在负权值，为了方便，我们这里不设计成静态数组，而是使用「哈希表」进行记录。
    class Solution {
        Map<String, Integer> map = new HashMap<>();

        public int findTargetSumWays(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
            int res = dfs(0, 0);
            return res;
        }

        int[] nums;
        int target;

        int dfs(int curIndex, int curSum) {
            String key = curIndex + "_" + curSum;
            if (map.containsKey(key)) return map.get(key);
            if (curIndex == nums.length) {
                if (curSum == target) return 1;
                return 0;
            }
            int left = dfs(curIndex + 1, curSum - nums[curIndex]);
            int right = dfs(curIndex + 1, curSum + nums[curIndex]);
            map.put(key, left + right);
            return left + right;
        }
    }
}
