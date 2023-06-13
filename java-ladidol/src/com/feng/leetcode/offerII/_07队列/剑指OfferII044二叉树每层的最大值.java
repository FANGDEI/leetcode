package com.feng.leetcode.offerII._07队列;

import com.feng.newline.binarytree.TreeNode;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/13 10:12
 * @description: {}
 */
public class 剑指OfferII044二叉树每层的最大值 {

    class Solution {
        //层序遍历
        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                //Collections.emptyList()是空链表
                return Collections.emptyList();
            }
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            //第一步先把根节点放进去!
            queue.offer(root);
            while (!queue.isEmpty()) {
                //只要不为空就继续向它子节点遍历!
                int max = Integer.MIN_VALUE;//-2^32;
                for (int i = queue.size(); i > 0; i--) {
                    //对该层的每一个节点的子节点都进行遍历!
                    TreeNode curNode = queue.poll();
                    max = Math.max(max, curNode.val);
                    if (curNode.left != null) queue.add(curNode.left);
                    if (curNode.right != null) queue.add(curNode.right);
                }
                res.add(max);
            }
            return res;
        }
    }
}
