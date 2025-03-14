package com.feng.leetcode.hot100._04二叉树;

public class h226翻转二叉树 {
    // //bfs
    // class Solution {
    //     public TreeNode invertTree(TreeNode root) {
    //         if(root == null) return root;
    //         ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    //         queue.offer(root);
    //         while(!queue.isEmpty()){
    //             int levelSize = queue.size();
    //             while(levelSize>0){
    //                 TreeNode cur = queue.poll();
    //                 TreeNode tmp = cur.left;
    //                 cur.left = cur.right;
    //                 cur.right = tmp;
    //                 if (cur.left != null) queue.add(cur.left);
    //                 if (cur.right != null) queue.add(cur.right);
    //                 levelSize--;
    //             }
    //         }
    //         return root;
    //     }
    // }
    //dfs递归
    class Solution {
        /**
         * 前后序遍历都可以
         * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;
            swap(root);invertTree(root.left);
            invertTree(root.right);

            return root;
        }
        public void swap(TreeNode node){
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }

}
