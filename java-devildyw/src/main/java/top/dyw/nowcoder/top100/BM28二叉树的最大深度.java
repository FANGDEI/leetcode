package top.dyw.nowcoder.top100;

import java.util.Map;

/**
 * @author Devil
 * @since 2023-01-09-23:15
 */
@SuppressWarnings("all")
public class BM28二叉树的最大深度 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        // write code here
        return maxDepthHelper(root);

    }

    private int maxDepthHelper(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepthHelper(root.left)+1,maxDepthHelper(root.right)+1);

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
