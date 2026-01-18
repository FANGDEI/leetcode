package top.dyw.leetcode.Hot100;

import java.util.ArrayList;
import java.util.List;

public class L94二叉树的中序遍历 {
    List<Integer> result = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalHelper(root);
        return result;
    }

    public void inorderTraversalHelper(TreeNode root) {
        if (root==null) {
            return;
        }
        inorderTraversalHelper(root.left);
        result.add(root.val);
        inorderTraversalHelper(root.right);
    }
}
