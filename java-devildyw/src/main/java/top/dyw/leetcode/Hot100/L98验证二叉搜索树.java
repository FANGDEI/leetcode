package top.dyw.leetcode.Hot100;

public class L98验证二叉搜索树 {
    Integer pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (pre == null) {
            pre = root.val;
        } else {
            if (pre >= root.val) {
                return false;
            }
            pre = root.val;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
