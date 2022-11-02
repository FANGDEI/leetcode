package com.feng.newline.greedy;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L55跳跃游戏
 * @author: Ladidol
 * @description: 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * @date: 2022/8/13 17:12
 * @version: 1.0
 */
public class L55跳跃游戏 {
    //这个问题就转化为跳跃覆盖范围究竟可不可以覆盖到终点！
    //每次移动取最大跳跃步数（得到最大的覆盖范围），每移动一个单位，就更新最大覆盖范围。
    //贪心算法局部最优解：在当前最大覆盖范围内，每次取最大跳跃步数（取最大覆盖范围），整体最优解：最后得到整体最大覆盖范围，看是否能到终点。
    //局部最优推出全局最优，找不出反例，试试贪心！
    class Solution1 {
        public boolean canJump(int[] nums) {
            if (nums.length <= 1) return true;
            int cover = 0;//默认覆盖到第0个
            for (int i = 0; i <= cover; i++) {//在覆盖范围内更新最大的覆盖范围 重点*****
                cover = Math.max(i + nums[i], cover);//最大覆盖范围，看是否需要更新。
                if (cover >= nums.length - 1) return true;
            }
            return false;
        }
    }


    // dp，淳朴做法。
    class Solution2 {//2022年11月1日17:34:27

        /**
         * 参数：[nums]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：dp[i] = true 表示当前i下标可以到达。
         */
        public boolean canJump(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];
            dp[0] = true;

            for (int i = 0; i < n; i++) {
                if (dp[i]) {
                    for (int j = i + 1; j < n && j <= i + nums[i]; j++) {
                        dp[j] = true;
                    }
                } else {
                    return false;
                }
            }

            return true;
        }
    }


    // dp，就是贪心的做法，靠北了。
    class Solution {//2022年11月1日17:34:27

        /**
         * 参数：[nums]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：dp[i] = j 表示当前i下标可以到达最远的地方j。
         */
        public boolean canJump(int[] nums) {
            int n = nums.length;
            if (n <= 1) return true;
            int[] dp = new int[n];
            //初始化一下dp
            dp[0] = nums[0];
            if (dp[0]==0) return false;
            for (int i = 1; i < n-1; i++) {//只需要判断到n-2的位置就行了。
                dp[i] = Math.max(dp[i - 1], i + nums[i]);//注意值，是下标i+nums[i]
                if (dp[i] <= i) return false;
            }
            return true;
        }

    }


}
