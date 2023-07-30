package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/30 11:27
 **/
@SuppressWarnings("all")
public class OII052展平二叉搜索树 {

    public static void main(String[] args) {

    }

    private TreeNode resNode;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        increasingBSTHelper(root);
        //之所以返回dummyNode.right是因为resNode一直在变化
        return dummyNode.right;
    }

    private void increasingBSTHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        //中序遍历 改变节点指针指向
        increasingBSTHelper(root.left);
        //改变节点指向
        resNode.right = root;
        root.left = null;
        resNode = root;
        increasingBSTHelper(root.right);
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
