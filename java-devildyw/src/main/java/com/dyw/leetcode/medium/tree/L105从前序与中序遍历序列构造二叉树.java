package com.dyw.leetcode.medium.tree;

/**
 * @author Devil
 * @since 2022-08-10-9:26
 * <p>
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历，
 * inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
@SuppressWarnings("all")
public class L105从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     * 我们先根据先序遍历得到根节点，然后在中序遍历中找到根节点的位置，它的左边就是左子树的节点，右边就是右子树的节点
     * 根据上述规律就可以按规律的递归生成左子树和右子树了
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        //preorder 为空, 直接返回null 终止条件
        if (p_start == p_end) {
            return null;
        }
        //先找到根节点
        int root_val = preorder[p_start];
        //生成节点
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        //遍历查找中序遍历中的根节点位置
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        //计算出左节点的个数 根据这个左节点个数去构造左右子树
        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    private TreeNode buildTreeHelper01(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start == p_end) {
            return null;
        }

        //找到指定返回内的前序遍历的第一个元素 该元素就是根节点对应的值
        int root_val = preorder[p_start];
        //创建根节点
        TreeNode root = new TreeNode(root_val);

        int i_root_index = 0;
        //查找中序遍历中根节点的位置
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == root_val) {
                i_root_index = i;
                break;
            }
        }

        //计算出左子树节点数量
        int leftNum = i_root_index - i_start;
        //构建二叉树
        root.left = buildTreeHelper01(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        root.right = buildTreeHelper01(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;

    }
}
