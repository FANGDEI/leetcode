package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/20 20:44
 **/
@SuppressWarnings("all")
public class O55I二叉树的深度 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
