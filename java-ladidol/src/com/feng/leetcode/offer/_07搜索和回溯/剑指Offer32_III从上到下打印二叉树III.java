package com.feng.leetcode.offer._07搜索和回溯;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 21:29
 * @description: {}
 */
public class 剑指Offer32_III从上到下打印二叉树III {


    //层序遍历 + linkedlist
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return new LinkedList<>();
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            List<List<Integer>> res = new LinkedList<>();
            boolean flag = true;
            while (!queue.isEmpty()) {
                int curSize = queue.size();
                LinkedList<Integer> tmp = new LinkedList<>();
                for (int i = 0; i < curSize; i++) {
                    TreeNode poll = queue.poll();
                    if (flag) {
                        tmp.addLast(poll.val);
                    } else {
                        tmp.addFirst(poll.val);
                    }
                    if (poll.left != null) queue.offer(poll.left);
                    if (poll.right != null) queue.offer(poll.right);
                }
                flag = !flag;
                res.add(tmp);
            }
            return res;
        }
    }


}
