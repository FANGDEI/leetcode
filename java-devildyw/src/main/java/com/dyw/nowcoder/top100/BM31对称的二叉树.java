package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2023-01-10-22:56
 */
@SuppressWarnings("all")
public class BM31对称的二叉树 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null){
            return true;
        }
        return isSymmetricalHelper(pRoot.left,pRoot.right);
    }

    private boolean isSymmetricalHelper(TreeNode left, TreeNode right) {
        if (left==null&&right==null){
            return true;
        }

        if (left==null||right==null||left.val!=right.val){
            return false;
        }

        return isSymmetricalHelper(left.left,right.right)&&isSymmetricalHelper(left.right,right.left);
    }
}
