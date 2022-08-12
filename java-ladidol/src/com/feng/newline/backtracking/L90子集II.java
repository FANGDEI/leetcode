package com.feng.newline.backtracking;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L90子集II
 * @author: Ladidol
 * @description: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @date: 2022/8/11 20:27
 * @version: 1.0
 */
public class L90子集II {//容易被迷惑，此题和78题区别就是集合里有重复元素了，而且求取的子集要去重。

    //本题：同层去重，同枝不去重。
    class Solution {
        int[] nums;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            this.nums = nums;
            Arrays.sort(nums);//回溯中间，一般用双指针来去重，就需要先对数组进行排序操作。
            backtracking(0);
            return res;
        }

        void backtracking(int startIndex) {
            res.add(new ArrayList<>(cur));//遍历全部节点！
            if (startIndex == nums.length) {//听说可以不用加。
                return;
            }
            int pre = -11;
            for (int i = startIndex; i < nums.length; i++) {
                if (nums[i] == pre) {
                    continue;
                }
                pre = nums[i];
                cur.add(nums[i]);
                backtracking(i + 1);
                cur.removeLast();//回溯
            }
        }
    }
}
