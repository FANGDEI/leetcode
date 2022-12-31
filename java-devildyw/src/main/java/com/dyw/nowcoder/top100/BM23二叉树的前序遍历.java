package com.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-12-31-13:38
 */
@SuppressWarnings("all")
public class BM23二叉树的前序遍历 {

    public static void main(String[] args) {

    }

    public int[] preorderTraversal(TreeNode root) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>();
        preorderTraversalHelper(root,result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preorderTraversalHelper(TreeNode root, ArrayList<Integer> result) {
        if (root==null){
            return;
        }

        result.add(root.val);
        preorderTraversalHelper(root.left,result);
        preorderTraversalHelper(root.right,result);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
