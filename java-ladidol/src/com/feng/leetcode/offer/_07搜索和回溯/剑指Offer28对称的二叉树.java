package com.feng.leetcode.offer._07搜索和回溯;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 21:50
 * @description: {}
 */
public class 剑指Offer28对称的二叉树 {



    //bfs 双指针的样子，对称行动，从外面向内部移动。
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;//或者是false

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {

                TreeNode leftOne = queue.poll();
                TreeNode rightOne = queue.poll();
                if (leftOne == null && rightOne == null) continue;//都是没有不存在的节点，即为null的时候
                if (leftOne == null || rightOne == null || leftOne.val != rightOne.val) return false;

                queue.offer(leftOne.left);
                queue.offer(rightOne.right);
                queue.offer(leftOne.right);
                queue.offer(rightOne.left);
            }
            return true;
        }
    }


}
