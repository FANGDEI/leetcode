package com.feng.newline.dp.backage;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L416分割等和子集
 * @author: Ladidol
 * @description: 给你一个 只包含正整数 的 非空 数组nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * @date: 2022/8/17 22:12
 * @version: 1.0
 */
public class L416分割等和子集 {
    //一眼看过去感觉就是简单的dp类型题。
    //只有确定了如下四点，才能把01背包问题套到本题上来:
    //背包的体积为sum / 2
    //背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
    //背包如果正好装满，说明找到了总和为 sum / 2 的子集。
    //背包中每一个元素是不可重复放入。


    //1. 确定dp数组以及下标的含义：dp[j]表示 背包总容量是j，最大可以凑成j的子集总和为dp[j]。背包像一个上界一样。
    //2. 确定递推公式：dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
    //3. dp数组如何初始化：dp[i] = 0;
    //4. 确定遍历顺序：01背包一维dp滚动数组
    //5. 举例推导dp数组：d


    class Solution12314 {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 != 0) return false;//总和为奇数，不能平分

            int[] dp = new int[sum / 2 + 1];
//            int[] dp = new int[sum / 2 + 1];
            for (int i = 0; i < nums.length; i++) {
                for (int j = sum / 2; j >= nums[i]; j--) {
                    //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            return dp[sum / 2] == sum / 2;
        }
    }

    //二维dp，看一下
    class Solution2 {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            if (sum % 2 == 1) return false;//不能被二整除一定不合法。
            int target = sum / 2;

            //dp[i][j]代表可装物品为0-i，背包容量为j的情况下，背包内容量的最大价值
            int[][] dp = new int[nums.length][target + 1];

            //初始化,dp[0][j]的最大价值nums[0](if j > weight[i])
            //dp[i][0]均为0，不用初始化
            for (int j = nums[0]; j <= target; j++) {
                dp[0][j] = nums[0];
            }

            //遍历物品，遍历背包
            //递推公式:
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= target; j++) {
                    //背包容量可以容纳nums[i]
                    if (j >= nums[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[nums.length - 1][target] == target;
        }
    }


    //滚动数组优化
    class Solution3 {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) return false;//不能被二整除一定不合法。
            int target = sum / 2;

            //dp[i][j]代表可装物品为0-i，背包容量为j的情况下，背包内容量的最大价值
            int[][] dp = new int[2][target + 1];

            //初始化,dp[0][j]的最大价值nums[0](if j > weight[i])
            //dp[i][0]均为0，不用初始化
            for (int j = nums[0]; j <= target; j++) {
                dp[0][j] = nums[0];
            }

            //遍历物品，遍历背包
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= target; j++) {
                    //背包容量可以容纳nums[i]
                    if (j >= nums[i]) {
                        dp[i & 1][j] = Math.max(dp[(i - 1) & 1][j], dp[(i - 1) & 1][j - nums[i]] + nums[i]);
                    } else {
                        dp[i & 1][j] = dp[(i - 1) & 1][j];
                    }
                }
            }

            return dp[(nums.length - 1) & 1][target] == target;
        }
    }


    //直接求解，背包问题——能否取到价值最大化
    class Solution4 {
        //有用到一个技巧：事实上，这里有一个技巧，就是我们增加一个「不考虑任何物品」的情况讨论。
        //所以这里多了一层f[0][j]表示「不考虑任何物品」，f[0][0] = true;
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            //「等和子集」的和必然是总和的一半
            int sum = 0;
            for (int i : nums) sum += i;
            int target = sum / 2;
            if (target * 2 != sum) return false;

            // f[i][j] 代表考虑前 i 件物品，能否凑出价值「恰好」为 j 的方案
            // 修改「物品维度」为 2
            boolean[][] f = new boolean[2][target + 1];
            f[0][0] = true;//这里很关键，只有这里是true，后面的true都是这个转化过来的。
            for (int i = 1; i <= n; i++) {
                int t = nums[i - 1];
                for (int j = 0; j <= target; j++) {
                    boolean no = f[(i - 1) & 1][j];
                    boolean yes = j >= t ? f[(i - 1) & 1][j - t] : false;
                    f[i & 1][j] = no | yes;
                }
            }
            return f[n & 1][target];
        }
    }

    //简单背包问题，01背包问题
    class Solution123 {//2022年10月17日13:53:46，再做一遍。

        /**
         * 参数：[nums]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：dp[i][j]：考虑前i个数字，用背包容量j能装的最大容量。
         * <p>
         * dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i])
         */
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if ((sum & 1) == 1) return false;
            int m = sum / 2;
            int n = nums.length;
            int[][] dp = new int[n][m + 1];

            //dp初始化
            for (int j = nums[0]; j <= m; j++) {
                dp[0][j] = nums[0];
            }

            for (int i = 1; i < n; i++) {
                // for (int j = nums[i]; j <= m; j++) {//这里因为是二维数组，需要更新每一层中的每一个dp，所以这里不能从nums[i]中得到。
                for (int j = 0; j <= m; j++) {//这里因为是二维数组，需要更新每一层中的每一个dp，所以这里不能从nums[i]中得到。
                    int no = dp[i - 1][j];
                    int yes = j >= nums[i] ? dp[i - 1][j - nums[i]] + nums[i] : 0;
                    dp[i][j] = Math.max(no, yes);
                }
            }
            return dp[n - 1][m] == m;
        }
    }

    //简单的01背包问题再做一下
    class Solution1232133 {
        /**
         * 参数：[nums]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：2022年10月27日23:05:08
         */
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            if ((sum & 1) == 1) return false;
            int m = sum / 2;
            int[][] dp = new int[n][m + 1];
            //初始化dp数组
            for (int j = nums[0]; j < m + 1; j++) {
                dp[0][j] = nums[0];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m + 1; j++) {
                    int no = dp[i - 1][j];
                    int yes = j >= nums[i] ? dp[i - 1][j - nums[i]] + nums[i] : 0;
                    dp[i][j] = Math.max(no, yes);
                }
            }
            return dp[n - 1][m] == m;
        }
    }

    //简单的01背包，一维数组优化一下。
    class Solution {
        /**
         * 参数：[nums]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：
         */
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            if ((sum & 1) == 1) return false;
            int m = sum / 2;
            int[] dp = new int[m + 1];
            //初始化dp数组
            for (int j = nums[0]; j < m + 1; j++) {
                dp[j] = nums[0];
            }

            for (int i = 1; i < n; i++) {
                for (int j = m; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }


            return dp[m] == m;
        }
    }


}
