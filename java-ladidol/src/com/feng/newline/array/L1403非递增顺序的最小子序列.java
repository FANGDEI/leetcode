package com.feng.newline.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1403非递增顺序的最小子序列
 * @author: Ladidol
 * @description: 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
 * 注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
 * 示例 1：
 * 输入：nums = [4,3,10,9,8]
 * 输出：[10,9]
 * 解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。 
 * @date: 2022/8/4 18:17 七夕简单题，今天在力扣这里过七夕！
 * @version: 1.0
 */
public class L1403非递增顺序的最小子序列 {
    class Solution {
        //我们对数组进行排序，然后计算出总和sum，为了保证数字个数最少，每次都取最大的元素放入答案，判断ans的和是否大于剩余即可。
        public List<Integer> minSubsequence(int[] nums) {
            Arrays.sort(nums);
            int sum = Arrays.stream(nums).sum();//用api来求数组和！！！
            int ansSum = 0;
            List<Integer> ans = new ArrayList<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                ans.add(nums[i]);
                sum -= nums[i];
                ansSum += nums[i];
                if (ansSum > sum) break;
            }
            return ans;
        }
    }
}
