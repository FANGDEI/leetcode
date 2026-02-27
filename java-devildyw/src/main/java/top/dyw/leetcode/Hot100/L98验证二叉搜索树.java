package top.dyw.leetcode.Hot100;

public class L98验证二叉搜索树 {
    Integer preVal = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean rootLeft = isValidBST(root.left);

        if (preVal != null) {
            if (root.val <= preVal) {
                return false;
            }
        }
        preVal = root.val;

        boolean rootRight = isValidBST(root.right);

        return rootLeft && rootRight;
    }
}
