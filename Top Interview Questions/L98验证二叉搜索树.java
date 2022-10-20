import java.util.*;

public class L98验证二叉搜索树 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public class TreeNode {
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

    class Solution {
        List<Integer> ans = new ArrayList<>();

        public boolean isValidBST(TreeNode root) {
            process(root);
            int pro = ans.get(0);
            for (int i = 1; i < ans.size(); i++) {
                int value = ans.get(i);
                if (value <= pro) {
                    return false;
                }
                pro = value;
            }
            return true;
        }

        public void process(TreeNode root) {
            if (root != null) {
                if (root.left != null) {
                    process(root.left);
                }
                ans.add(root.val);
                if (root.right != null) {
                    process(root.right);
                }
            }
        }
    }
}
