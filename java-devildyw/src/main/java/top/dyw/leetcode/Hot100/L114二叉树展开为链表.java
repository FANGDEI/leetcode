package top.dyw.leetcode.Hot100;

public class L114二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return ;
        }

        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                TreeNode left= cur.left;
                TreeNode predecessor = left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                //接上去
                predecessor.right = cur.right;
                cur.left = null;
                cur.right = left;
            }
            cur = cur.right;
        }
    }
}
