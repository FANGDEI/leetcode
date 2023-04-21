package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/21 14:30
 **/
@SuppressWarnings("all")
public class O55II平衡二叉树 {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root)!=-1;
    }


    private int isBalancedHelper(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = isBalancedHelper(root.left);
        if (left==-1) return -1;
        int right = isBalancedHelper(root.right);
        if (right==-1) return -1;

        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
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
