package top.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-03-01-20:55
 */
@SuppressWarnings("all")
public class O110平衡二叉树 {


    public static void main(String[] args) {

    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }

    private int getHeight(TreeNode root) {
        if (root==null){
            return 0;
        }


        int leftHeight = getHeight(root.left);
        if (leftHeight==-1){
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight==-1){
            return -1;
        }

        if (Math.abs(rightHeight-leftHeight)>1){
            return -1;
        }

        return Math.max(leftHeight,rightHeight)+1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
