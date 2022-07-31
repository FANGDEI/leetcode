package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L222完全二叉树的节点个数
 * @author: Ladidol
 * @description: 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，
 * 则该层包含 1~ 2h 个节点。
 * @date: 2022/7/31 16:43
 * @version: 1.0
 */
public class L222完全二叉树的节点个数 {


    //===普通二叉树思路
    //dfs 递归
    class Solution1 {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            return 1 + countNodes(root.right) + countNodes(root.left);
        }
    }
    //bfs 层序
    class Solution3 {
        //代码略
    }

    //===完全二叉树思路
    //dfs 递归+剪枝 最优解！！！
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null) return 1;//剪枝，左节点没有的话，就没有右节点了，直接返回当前节点个数1
            return 1 + countNodes(root.right) + countNodes(root.left);
        }
    }
    //dfs 再来一个， 这个看看就行。
    class Solution4 {
        /**
         * 针对完全二叉树的解法
         *
         * 满二叉树的结点数为：2^depth - 1
         */
        public int countNodes(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            if (leftDepth == rightDepth) {// 左子树是满二叉树
                // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
                return (1 << leftDepth) + countNodes(root.right);
            } else {// 右子树是满二叉树
                return (1 << rightDepth) + countNodes(root.left);
            }
        }

        private int getDepth(TreeNode root) {
            int depth = 0;
            while (root != null) {
                root = root.left;
                depth++;
            }
            return depth;
        }
    }


}
