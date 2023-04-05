package top.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2022-09-21-12:02
 */
@SuppressWarnings("all")
public class L111二叉树的最小深度 {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        //如果不是叶子节点 也要单独判断是否左右子树为空才行 因为取最小值我们需要找到叶子节点 不能在中途找到小的就算进去 因为可能该节点不是叶子节点
        if (root.left!=null){
            min_depth = Math.min(minDepth(root.left),min_depth);
        }

        if (root.right!=null){
            min_depth = Math.min(minDepth(root.right),min_depth);
        }

        return min_depth+1;
    }
}
