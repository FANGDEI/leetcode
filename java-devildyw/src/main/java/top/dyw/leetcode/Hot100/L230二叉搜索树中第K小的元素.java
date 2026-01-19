package top.dyw.leetcode.Hot100;

public class L230二叉搜索树中第K小的元素 {
    int result = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        kthSmallestHelper(root, k);
        return result;
    }

    public void kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return ;
        }

        if (count > k) {
            return;
        }

        kthSmallestHelper(root.left, k);
        count++;
        if (count==k) {
            result = root.val;
            return ;
        }

        kthSmallestHelper(root.right, k);

    }
}
