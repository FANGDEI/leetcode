package com.feng.newline.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L47全排列II
 * @author: Ladidol
 * @description: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @date: 2022/8/11 21:39
 * @version: 1.0
 */
public class L47全排列II {


    //区别在与给定一个可包含重复数字的序列，要返回所有不重复的全排列。
    //还要强调的是去重一定要对元素进行排序，这样我们才能通过双指针简单判断是否使用过。
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        int[] nums;
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            this.nums = nums;
            used = new boolean[nums.length];
            backtracking();
            return res;
        }
        void backtracking() {//直接从0开始，因为是全排列。
            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
            }
            int pre = -11;
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;//当前支路中已经使用过当前元素了，就直接跳过。
                }
                if (pre == nums[i]){
                    continue;
                }
                pre = nums[i];
                cur.add(nums[i]);
                used[i] = true;
                backtracking();
                cur.removeLast();//回溯
                used[i] = false;//回溯
            }
        }
    }
}
