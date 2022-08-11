package com.feng.newline.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L46全排列
 * @author: Ladidol
 * @description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * @date: 2022/8/11 21:21
 * @version: 1.0
 */
public class L46全排列 {
    //而used数组，其实就是记录此时path里都有哪些元素使用了，一个排列里一个元素只能使用一次。
    //是纵向的，所以used数组需要回溯。
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        int[] nums;
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            used = new boolean[nums.length];
            backtracking();
            return res;
        }

        void backtracking() {//直接从0开始，因为是全排列。
            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;//当前支路中已经使用过当前元素了，就直接跳过。
                }
                cur.add(nums[i]);
                used[i] = true;
                backtracking();
                cur.removeLast();//回溯
                used[i] = false;//回溯
            }
        }
    }
}
