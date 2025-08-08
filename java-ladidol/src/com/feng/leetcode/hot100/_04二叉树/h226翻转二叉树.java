package com.feng.leetcode.hot100._04二叉树;

import java.util.ArrayDeque;

public class h226翻转二叉树 {
    //dfs递归
    class Solution1 {
        /**
         * 前后序遍历都可以
         * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;
            swap(root);
            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
        public void swap(TreeNode node){
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }


    //  层序遍历 bfs
    class Solution {

      public TreeNode invertTree(TreeNode root) {
        if (root == null) {
          return root;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
          int curLevelSize = queue.size();
          for (int i = 0; i < curLevelSize; i++) {
            TreeNode curNode = queue.poll();
            swap(curNode);
            if (curNode.left!=null) queue.offer(curNode.left);
            if (curNode.right!=null) queue.offer(curNode.right);
          }
        }

        return root;
      }

      public void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
      }
    }



}
