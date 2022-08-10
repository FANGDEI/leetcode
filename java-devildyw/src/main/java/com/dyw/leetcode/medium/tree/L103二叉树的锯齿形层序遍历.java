package com.dyw.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-08-10-10:03
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
@SuppressWarnings("all")
public class L103二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        System.out.println(new L103二叉树的锯齿形层序遍历().zigzagLevelOrder(treeNode));
    }

    /**
     * 双端队列 当计数器为偶数时遍历队列的头部插入队列尾部 当为奇数时遍历队列的尾部插入队列的头部(且左右子树要翻着查如队列)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        queue.addLast(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                if (count % 2 == 0) {
                    TreeNode treeNode = queue.pollFirst();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.addLast(treeNode.right);
                    }
                } else {
                    TreeNode treeNode = queue.pollLast();
                    list.add(treeNode.val);
                    if (treeNode.right != null) {
                        queue.addFirst(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        queue.addFirst(treeNode.left);
                    }
                }
            }
            lists.add(list);
            count++;
        }
        return lists;
    }
}
