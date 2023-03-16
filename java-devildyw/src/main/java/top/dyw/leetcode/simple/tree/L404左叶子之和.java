package top.dyw.leetcode.simple.tree;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * @author Devil
 * @since 2022-09-24-13:05
 */
@SuppressWarnings("all")
public class L404左叶子之和 {

    public static void main(String[] args) {

    }

    /**
     * 递归
     * <p>
     * 首先要注意是判断左叶子，不是二叉树左侧节点，所以不要上来想着层序遍历。
     * <p>
     * 节点A的左孩子不为空，且左孩子的左右孩子都为空（说明是叶子节点），那么A节点的左孩子为左叶子节点
     * <p>
     * 那么判断当前节点是不是左叶子是无法判断的，必须要通过节点的父节点来判断其左孩子是不是左叶子。
     * <p>
     * 如果该节点的左节点不为空，该节点的左节点的左节点为空，该节点的左节点的右节点为空，则找到了一个左叶子
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        //终止条件
        if (root == null) {
            return 0;
        }
        int leftValue = 0;

        //判断是否是左叶子节点的条件
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftValue = root.left.val;
        }
        //加上其左右节点上的左叶子节点值
        return leftValue + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
