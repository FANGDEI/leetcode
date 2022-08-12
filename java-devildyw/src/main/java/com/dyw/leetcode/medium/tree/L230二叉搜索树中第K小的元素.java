package com.dyw.leetcode.medium.tree;

/**
 * @author Devil
 * @since 2022-08-12-9:45
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 */
@SuppressWarnings("all")
public class L230二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        System.out.println(new L230二叉搜索树中第K小的元素().kthSmallest(treeNode, 1));
    }

    int count = 0;
    int result = -1;

    /**
     * 递归 中序遍历 通过递归的性质 初始一个计数器 递归是自下而上的 所以我们可以借助这一点再通过计数器和二叉搜索树的性质 就可以找到倒数第k个最小的值
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root,k);
    }

    private int kthSmallestHelper(TreeNode root, int k) {
        if (root==null){
            return -1;
        }
        if (root.left!=null){
            result = kthSmallestHelper(root.left,k);
        }
        count++;
        if (count==k&&result==-1){
            result = root.val;
        }
        System.out.println(count+":"+k+":"+root.val+":"+result);
        if (root.right!=null){
            result = kthSmallestHelper(root.right,k);
        }
        return result;
    }
}
