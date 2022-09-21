package com.feng.newline.dfs;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.sub_sequence
 * @className: L698划分为k个相等的子集
 * @author: Ladidol
 * @description: 给定一个整数数组nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 * 提示：
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 * @date: 2022/9/20 23:06
 * @version: 1.0
 */
public class L698划分为k个相等的子集 {


    //dfs（顺序剪枝，先取最大值的贪心）
    class Solution {

        //用贪心加顺序是为了更好的顺序剪枝。好像是，我这样理解还是有点模糊。
        public boolean canPartitionKSubsets(int[] nums, int k) {
            n = nums.length;
            this.k = k;
            this.nums = nums;
            used = new boolean[n];
            int allSum = Arrays.stream(nums).sum();
            if (allSum % k != 0) return false;//不评分直接淘汰；
            target = allSum / k;//每一组要符合的值。

            Arrays.sort(nums);//贪心所在，正常dfs就可以不用这个排序，这里只是为了（顺序剪枝）。

            return dfs(n - 1, 0, 0);


        }

        boolean[] used;// nums[i]中是否被使用
        int k;//共多少组。
        int target;//每组的大小；
        int n;
        int[] nums;


        boolean dfs(int startIndex, int curSum, int count) {//当前开始下标，当前小集合的和，当前已经找到的集合数。
            if (count == k) return true;//一定是相等的。
            if (curSum == target) return dfs(n - 1, 0, count + 1);//从头开始找咯，然后就是curSum归零，count+1；
            for (int i = startIndex; i >= 0; i--) {
                if (used[i] || curSum > target) continue;//如果当前值在之前的小组中有被使用，如果当前curSum值不满足：往小处再寻找；
                used[i] = true;
                if (dfs(i - 1, curSum + nums[i], count)) return true;
                used[i] = false;//回溯，当前被使用的情况。
                //这里是剪枝的重点部分！（可行性剪枝）
                if (curSum == 0) return false;//如果此层放不进去（未被使用中的数），则说明这条路没有解。
            }
            return false;
        }
    }

    //还有一种模拟退火
    //https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solution/by-ac_oier-mryw/

}
