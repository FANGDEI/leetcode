package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/26 18:33
 **/
@SuppressWarnings("all")
public class OII047二叉树剪枝 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        new OII047二叉树剪枝().pruneTree(root);
    }

    /**
     * 所有节点的值为 0 的子树都要删除
     * 递归处理左右子树 从最小的叶子节点开始处理
     * 如果当前节点的左右子树都为null 并且当前节点的值为0 则将当前节点置为null 满足题目条件
     *
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        //如果当前节点的左右子树都为null 并且当前节点的值为0 则将当前节点置为null
        if (root.left == null && root.right == null && root.val == 0) {
            root = null;
        }

        return root;
    }



    static class TreeNode {
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
