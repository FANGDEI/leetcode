package top.dyw.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-07-20-14:49
 * <p>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
@SuppressWarnings("all")
public class L94二叉树的中序遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> integers = new L94二叉树的中序遍历().inorderTraversal(treeNode);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inorder(list, root);
        return list;
    }

    private void inorder(List list, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(list, root.right);
        }
    }
}
