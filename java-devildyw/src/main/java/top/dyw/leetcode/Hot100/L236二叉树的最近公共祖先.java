package top.dyw.leetcode.Hot100;

public class L236二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // 如果当前找到了p或者q就立刻返回当前节点 因为
        // 1. 如果q是p的子节点 那么再往下找不可能有公共的祖先了 只能返回p没问题
        // 2. 如果q在另一个子树上 那么上层还会去查找另一个子树的 不用担心
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 两颗子树分别找到了p和q 那么当前就是最近的公共祖先了
        if (left != null && right != null) {
            return root;
        }

        // 两颗子树都没找到 且当前节点也不是p和q 那么就返回null 证明根本不在以当前root为祖先的下面
        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        }
        return left;
    }
}
