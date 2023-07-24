package com.feng.leetcode.offer._07搜索和回溯;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 21:16
 * @description: {}
 */
public class 剑指Offer32_I从上到下打印二叉树 {


    //bfs
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) return new int[]{};
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            List<Integer> res = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }
    }

}
