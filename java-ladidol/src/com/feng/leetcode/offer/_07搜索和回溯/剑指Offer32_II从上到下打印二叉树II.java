package com.feng.leetcode.offer._07搜索和回溯;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 21:24
 * @description: {}
 */
public class 剑指Offer32_II从上到下打印二叉树II {

    //层序遍历
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return new LinkedList<>();
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            List<List<Integer>> res = new LinkedList<>();
            while (!queue.isEmpty()) {
                int curSize = queue.size();
                List<Integer> tmp = new LinkedList<>();
                for (int i = 0; i < curSize; i++) {
                    TreeNode poll = queue.poll();
                    tmp.add(poll.val);
                    if (poll.left != null) queue.offer(poll.left);
                    if (poll.right != null) queue.offer(poll.right);
                }
                res.add(tmp);
            }
            return res;
        }
    }
}
