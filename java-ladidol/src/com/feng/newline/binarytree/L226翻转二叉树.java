package com.feng.newline.binarytree;

import java.util.ArrayDeque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L226翻转二叉树
 * @author: Ladidol
 * @description: 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @date: 2022/7/30 12:33
 * @version: 1.0
 */
public class L226翻转二叉树 {


    //bfs
    class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return root;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int levelSize = queue.size();
                while(levelSize>0){
                    TreeNode cur = queue.poll();
                    TreeNode tmp = cur.left;
                    cur.left = cur.right;
                    cur.right = tmp;
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                    levelSize--;
                }
            }
            return root;
        }
    }

    /*可以发现想要翻转它，其实就把每一个节点的左右孩子交换一下就可以了。
    关键在于遍历顺序，前中后序应该选哪一种遍历顺序？ （
    一些同学这道题都过了，但是不知道自己用的是什么顺序）
    这边建议直接用前序遍历或者后序遍历*/
    //dfs递归
    class Solution {
        /**
         * 前后序遍历都可以
         * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;
            invertTree(root.left);
            invertTree(root.right);
            swap(root);//放在前面后面都行。现在是后续遍历
            return root;
        }
        public void swap(TreeNode node){
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }



}
