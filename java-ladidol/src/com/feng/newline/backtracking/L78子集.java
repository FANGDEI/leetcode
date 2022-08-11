package com.feng.newline.backtracking;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L78子集
 * @author: Ladidol
 * @description: 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @date: 2022/8/11 19:55
 * @version: 1.0
 */
public class L78子集 {//子集问题可以说是回溯的模板题，还是很简单那种。

    class Solution {
        int[] nums;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;
            backtracking(0);
            return res;
        }

        void backtracking(int startIndex) {
            res.add(new ArrayList<>(cur));//遍历全部节点！
            if (startIndex == nums.length) {//听说可以不用加。
                return;
            }
            for (int i = startIndex; i < nums.length; i++) {
                cur.add(nums[i]);
                backtracking(i + 1);
                cur.removeLast();//回溯
            }
        }
    }
}
