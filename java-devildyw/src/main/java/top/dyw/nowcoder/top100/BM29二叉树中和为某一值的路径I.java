package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2023-01-10-21:16
 */
@SuppressWarnings("all")
public class BM29二叉树中和为某一值的路径I {

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        return hasPathSumHelper(root,sum);
    }

    private boolean hasPathSumHelper(TreeNode root, int sum) {
        if (root==null){
            return true;
        }

        if (root.left==null&&root.right==null){
            return sum-root.val==0;
        }

        return hasPathSumHelper(root.left,sum-root.val)||hasPathSumHelper(root.right,sum-root.val);

    }
}
