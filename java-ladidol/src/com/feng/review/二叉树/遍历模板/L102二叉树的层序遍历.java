package com.feng.review.二叉树.遍历模板;

import com.feng.review.二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L102二叉树的层序遍历
 * @author: Ladidol
 * @description: 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @date: 2022/7/29 17:00 2023年3月5日11:23:33
 * @version: 1.0
 */
public class L102二叉树的层序遍历 {
    //BFS--借助队列
    class Solution {//2023年3月5日11:23:29复习

        public List<List<Integer>> levelOrder(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            List<List<Integer>> res = new ArrayList<>();

            if (root != null) deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> curList = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode curNode = deque.poll();
                    curList.add(curNode.val);
                    if (curNode.left != null) deque.offer(curNode.left);
                    if (curNode.right != null) deque.offer(curNode.right);
                }
                res.add(curList);
            }
            return res;
        }
    }


}
