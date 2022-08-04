package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L450删除二叉搜索树中的节点
 * @author: Ladidol
 * @description: 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 提示：
 * 没找到删除的节点：
 * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
 * 找到删除的节点：
 * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
 * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
 * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
 * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
 * @date: 2022/8/4 16:38
 * @version: 1.0
 */
public class L450删除二叉搜索树中的节点 {


    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return root;
            if (root.val == key) {//找到要删除的了
                if (root.left == null && root.right == null) return null;//左右都为空，直接删除
                if (root.left == null && root.right != null) return root.right;//一边为空，返回另一个
                if (root.left != null && root.right == null) return root.left;
                else {//子节点两边都存在，将左孩子变成右孩子的最左边的孩子的左孩子
                    TreeNode leftChild = root.left;
                    TreeNode cur = root.right;
                    while (cur.left != null) {
                        cur = cur.left;
                    }
                    cur.left = leftChild;
                    return root.right;//当前右孩子已经变样了！！！变长了！
                }
            }
            if (root.val > key) root.left = deleteNode(root.left, key);
            if (root.val < key) root.right = deleteNode(root.right, key);
            return root;
        }
    }
}
