package com.feng.newline.array;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/10/9 14:31
 * @description: 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class L238除自身以外数组的乘积 {


    //前缀和（积）
    class Solution {
        /**
         * 参数：[nums]
         * 返回值：int[]
         * 作者： ladidol
         * 描述：
         * 用前缀和和后缀和。
         * 做到一般发现可以直接总积除以当前数，发现有0的元素就不能成功了。
         */
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n];
            int[] suffix = new int[n];

            //初始化后缀积
            suffix[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] * nums[i];
            }

            int[] res = new int[n];

            prefix[0] = nums[0];
            res[0] = suffix[1];
            for (int i = 1; i < n - 1; i++) {
                res[i] = prefix[i - 1] * suffix[i + 1];
                prefix[i] = prefix[i - 1] * nums[i];
            }
            res[n - 1] = prefix[n - 2];

            return res;
        }
    }
}