package com.feng.leetcode.offer._07搜索和回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 22:16
 * @description: {}
 */
public class 剑指Offer34二叉树中和为某一值的路径 {

    //dfs+回溯
    class Solution {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root ==null) return res;
            path.add(root.val);
            traversal(root, root.val, targetSum);
            return res;

        }

        void traversal(TreeNode root, int sum, int targetSum) {
            if (root.left == null && root.right == null && sum == targetSum) {
                res.add(new LinkedList<>(path));
                return;
            }
            if (root.left == null && root.right == null) return;//到底但是没满足直接return

            if (root.left != null) {
                sum += root.left.val;
                path.add(root.left.val);
                traversal(root.left, sum, targetSum);
                sum -= root.left.val;
                path.removeLast();
            }
            if (root.right != null) {
                sum += root.right.val;
                path.add(root.right.val);
                traversal(root.right, sum, targetSum);
                sum -= root.right.val;
                path.removeLast();
            }

        }
    }

}
