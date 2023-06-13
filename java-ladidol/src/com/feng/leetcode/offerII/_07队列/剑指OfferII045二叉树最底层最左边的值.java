package com.feng.leetcode.offerII._07队列;

import com.feng.newline.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/13 10:15
 * @description: {}
 */
public class 剑指OfferII045二叉树最底层最左边的值 {


    //bfs 层序遍历
    class Solution {
        /**
         * 层序遍历的二叉树，永远那么简单
         * @param root
         * @return
         */
        public int findBottomLeftValue(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int ans = root.val;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = queue.poll();
                    if (i == 0) {
                        ans = cur.val;
                    }
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }

            }
            return ans;
        }
    }



}

