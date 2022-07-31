package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L110平衡二叉树
 * @author: Ladidol
 * @description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * @date: 2022/7/31 17:23
 * @version: 1.0
 */
public class L110平衡二叉树 {

    //dfs 递归
    //思路，通过获取高度，高度有-1的情况（这时候就是不满足平衡二叉树的性质了。
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        int getHeight(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = getHeight(node.left);
            if (leftHeight == -1) return -1;//这里需要判断的原因是防止类似两条链表一样的情况，所以要将-1的结果一直传递下去。

            int rightHeight = getHeight(node.right);
            if (rightHeight == -1) return -1;

            if (Math.abs(leftHeight - rightHeight) > 1) return -1;
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
