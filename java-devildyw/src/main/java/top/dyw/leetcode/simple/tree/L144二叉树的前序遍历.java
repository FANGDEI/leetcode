package top.dyw.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-07-20-14:32
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
@SuppressWarnings("all")
public class L144二叉树的前序遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> integers = new L144二叉树的前序遍历().preorderTraversal(treeNode);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        preorder(list, root);
        return list;
    }

    private void preorder(List list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            preorder(list, root.left);
        }
        if (root.right != null) {
            preorder(list, root.right);
        }
    }
}
