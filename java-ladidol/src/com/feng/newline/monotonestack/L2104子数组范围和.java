package com.feng.newline.monotonestack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.monotonestack
 * @className: L2104子数组范围和
 * @author: Ladidol
 * @description: 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * 返回 nums 中 所有 子数组范围的 和 。
 * 子数组是数组中一个连续 非空 的元素序列。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [2]，范围 = 2 - 2 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,2]，范围 = 2 - 1 = 1
 * [2,3]，范围 = 3 - 2 = 1
 * [1,2,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [3]，范围 = 3 - 3 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,3]，范围 = 3 - 1 = 2
 * [3,3]，范围 = 3 - 3 = 0
 * [1,3,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
 * 示例 3：
 * <p>
 * 输入：nums = [4,-2,-3,4,1]
 * 输出：59
 * 解释：nums 中所有子数组范围的和是 59
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -109 <= nums[i] <= 109
 * 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？
 * @date: 2022/9/15 23:33
 * @version: 1.0
 */
public class L2104子数组范围和 {

    // 先用暴力
    class Solution1 {
        public long subArrayRanges(int[] nums) {
            long res = 0;
            for (int i = 0; i < nums.length; i++) {
                int min = nums[i];
                int max = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    res += max - min;
                }
            }
            return res;
        }
    }


    //单调栈：L907子数组的最小值之和的升级版
    // 问题能轻易转换为：假设有 m 个区间，最终的表达式为 m 个等式 max−min 之和。(k1 - k2) * nums[i] 为 nums[i] 对于最终答案的贡献。
    class Solution {
        public long subArrayRanges(int[] nums) {
            // 求贡献最小值次数和最大值次数。
            long[] minCnt = getCnt(nums, true);
            long[] maxCnt = getCnt(nums, false);
            long ans = 0L;
            for (int i = 0; i < nums.length; i++) {
                ans += (maxCnt[i] - minCnt[i]) * nums[i];
            }
            return ans;

        }

        //就是907中用两个for循环用连个left和right数组分别存上下界。
        long[] getCnt(int[] nums, boolean isMin) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] right = new int[nums.length];
            int[] left = new int[nums.length];
            Arrays.fill(right, nums.length);
            Arrays.fill(left, -1);


            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && (isMin ? nums[stack.peek()] >= nums[i] : nums[stack.peek()] <= nums[i])) {
                    right[stack.peek()] = i;
                    stack.pop();
                }
                stack.push(i);
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && (isMin ? nums[stack.peek()] > nums[i] : nums[stack.peek()] < nums[i])) {
                    left[stack.peek()] = i;
                    stack.pop();
                }
                stack.push(i);
            }
            stack.clear();
            long[] cnt = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                //乘法法则
                cnt[i] = (long) (i - left[i]) * (right[i] - i);
            }
            return cnt;
        }

    }
}
