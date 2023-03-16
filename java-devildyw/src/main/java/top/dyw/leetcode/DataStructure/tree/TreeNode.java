package top.dyw.leetcode.DataStructure.tree;

/**
 * @author Devil
 * @since 2022-09-19-10:48
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
