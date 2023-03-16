package top.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2022-09-23-11:35
 */
@SuppressWarnings("all")
public class L110平衡二叉树 {

    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        //左右子树高度差大于1,返回高度已经没有意义 所以这里返回一个标志 return -1 表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        //人工高度差小于等于1，则返回最大的那个高度加1(加上这层的高度)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
