package com.feng.newline.backtracking;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L491递增子序列
 * @author: Ladidol
 * @description: 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * 示例 1：
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * @date: 2022/8/11 20:41
 * @version: 1.0
 */
public class L491递增子序列 {

    class Solution {//听说和子集问题有点像，但又处处是陷阱
        //由于不能轻易改变递增关系，所以本题就不用了双指针来去重了。
        int[] nums;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            this.nums = nums;
            backtracking(0);
            return res;
        }

        void backtracking(int startIndex) {
            if (cur.size() >= 2) {
                res.add(new ArrayList<>(cur));
                // 注意这里不要加return，全遍历！
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = startIndex; i < nums.length; i++) {
                if (!set.add(nums[i])) {
                    continue;//同层去重，不用双指针了。
                }
                if (cur.size() != 0 && cur.getLast() > nums[i]) {//这里是重点，适合当前路径下最后一个节点值比较
                    continue;//可能同层后面还有符合条件的。
                }
                cur.add(nums[i]);
                backtracking(i + 1);
                cur.removeLast();
            }
        }
    }
}
